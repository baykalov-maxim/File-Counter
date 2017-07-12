package ua.nure.maxim.baykalov.filecounter.utils;

import java.io.FileWriter;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVWriter;
import ua.nure.maxim.baykalov.filecounter.exceptions.CreateOutputCSVFileException;

public class OutputFileWriter {
	
	private CSVWriter writer;
	private String[] buff;
	
	public OutputFileWriter(String nameCSVFile) throws CreateOutputCSVFileException {
		buff = new String[2];
		try {
			new CSVWriter(new FileWriter(nameCSVFile)).close();	// clear file
			writer = new CSVWriter(new FileWriter(nameCSVFile, true), ';');	// create stream for add new line to file with separator ';'
		} catch (IOException e) {
			throw new CreateOutputCSVFileException();
		}
	}
	
	/**
	 * Add new line to stream
	 */
	public void addLine(String path, int count) {
		buff[0] = path;
		buff[1] = Integer.toString(count);
		writer.writeNext(buff);
	}

	/**
	 * Close stream 
	 */
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			System.err.println("Result has not been saved");
		}
	}
	
	/**
	 * Save stream to output file
	 */
	public void flush() {
		try {
			writer.flush();
		} catch (IOException e) {
			System.err.println("Flush is bad");
		}
	}
}
