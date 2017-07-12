package ua.nure.maxim.baykalov.filecounter.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import ua.nure.maxim.baykalov.filecounter.exceptions.ReadingPathFileException;

public class PathLoader {

	public final String PATH_FILE_NAME;
	
	public PathLoader(String pathFileName) {
		this.PATH_FILE_NAME = pathFileName;
	}
	
	/**
	 * The method read file and return lines that contain path as list
	 * @throws ReadingPathFileException if the file can not be opened
	 * @return list of paths
	 */
	public List<String> getPathList() throws ReadingPathFileException{
		
		try {
			List<String> pathList = Files.readAllLines(Paths.get(PATH_FILE_NAME), StandardCharsets.UTF_8) // file reading
					.stream()
					.filter(path -> !path.matches("(\\*)+.*")) // remove comments 
					.collect(Collectors.toList());	// get list
			return pathList;
			
		} catch (IOException e) {
			throw new ReadingPathFileException("File not found or is unreading");
		}
	}

}
