package ua.nure.maxim.baykalov.filecounter.utils;

import java.io.File;

import ua.nure.maxim.baykalov.filecounter.exceptions.PathIsNotDirException;

public class FileCounter {
	
	private static boolean isActive = true;

	/**
	 * The method calculate count file in directory and sub-directory 
	 * 
	 * @param path - directory path 
	 * @throws PathIsNotDirException if path isn't directory
	 * @return if directory path is valid return count files on this path else throws PathIsNotDirException
	 */
	public static int getFileCountFromPath(String path) throws PathIsNotDirException {
		File dir;
		dir = getDirByPath(path);
		return getFileCountInDir(dir);
	}
	
	/**
	 * Method return obj of directory if path is valid else throw PathIsNotDirException
	 * 
	 * @throws PathIsNotDirException if path isn't directory 
	 * @return obj directory
	 */
	private static File getDirByPath(String path) throws PathIsNotDirException {
	
		File dir = new File(path);
		if (!dir.isDirectory())
			throw new PathIsNotDirException();
		
		return dir;	
	}

	/**
	 * Method calculate files count in the directory and sub-directories 
	 * Warning: Recursion is used
	 * 
	 * @param dir - obj is a File that is checking directory 
	 * @throws PathIsNotDirException if path isn't directory 
	 * @return count file in directory and sub-directory
	 */
	private static int getFileCountInDir(File dir) {
		if (!dir.isDirectory())
			throw new PathIsNotDirException();
		
		int count = 0;
		
		File[] items = dir.listFiles();
		if (items != null) {
			for (File i : items) {
				if (i.isDirectory() && isActive) {	// if file is directory and program is active
					count += getFileCountInDir(i); // Recursion call return file count in sub-directory
				}
				else {
					count++;
				}
			}
		}
		return count;	
	}
	
	public static void stop() {
		isActive = false;
	}
}
