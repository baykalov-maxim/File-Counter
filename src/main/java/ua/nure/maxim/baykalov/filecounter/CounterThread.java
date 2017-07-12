package ua.nure.maxim.baykalov.filecounter;

import ua.nure.maxim.baykalov.filecounter.exceptions.CreateOutputCSVFileException;
import ua.nure.maxim.baykalov.filecounter.exceptions.PathIsNotDirException;
import ua.nure.maxim.baykalov.filecounter.exceptions.ReadingPathFileException;
import ua.nure.maxim.baykalov.filecounter.utils.FileCounter;
import ua.nure.maxim.baykalov.filecounter.utils.FormatOutput;
import ua.nure.maxim.baykalov.filecounter.utils.OutputFileWriter;
import ua.nure.maxim.baykalov.filecounter.utils.PathLoader;

public class CounterThread extends Thread {
	
	private static boolean isActive = true;
	private String inputFilePath;
	private String outputFilePath;
	
	public CounterThread(String inputFilePath, String outputFilePath) {
		this.inputFilePath = inputFilePath;
		this.outputFilePath = outputFilePath;
	}

	public void stopCount() {
		isActive = false;
		FileCounter.stop();
	}

	@Override
	public void run() {
		isActive = true;
		PathLoader pathLoader = null;
		OutputFileWriter outputFileWriter = null;
		
		try {
			pathLoader = new PathLoader(inputFilePath);
			outputFileWriter = new OutputFileWriter(outputFilePath);
			int count;
			int i = 0;
			
			FormatOutput.renderHeader();
			for (String path : pathLoader.getPathList()) {
				if (!isActive) {
					break;
				}
				i++;
				try {
					count = FileCounter.getFileCountFromPath(path);
					FormatOutput.renderLine(i, path, count);
					outputFileWriter.addLine(path, count);
					
					outputFileWriter.flush();
				} catch (PathIsNotDirException e) {
					FormatOutput.renderErrorLine(i, path);
				}
			}
		} catch (ReadingPathFileException e1) {
			System.err.println("Error open input path file");	
		} catch (CreateOutputCSVFileException e2) {
			System.err.println("Error create output csv file");
		}
		finally {
			if (outputFileWriter != null)
				outputFileWriter.close();
			System.exit(1);
		}
	}
}
