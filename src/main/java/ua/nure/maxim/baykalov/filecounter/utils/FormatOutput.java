package ua.nure.maxim.baykalov.filecounter.utils;

public class FormatOutput {
	
	public static void renderHeader() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("|  ¹   |                        Path                              |     Count    |");
		System.out.println("----------------------------------------------------------------------------------");
	}

	public static void renderLine(int i, String path, int count) {
		System.out.println("| " + getFormatedI(i) +" | " + getFormatedPath(path) + " | " + getFormatedCount(count) + "  |");
		System.out.println("----------------------------------------------------------------------------------");
	}

	private static String getFormatedI(int i) {
		return String.format("%-4s", Integer.valueOf(i));
	}
	
	private static String getFormatedPath(String path) {
		return String.format("%-56s", path);
	}
	
	private static String getFormatedCount(int count) {
		return String.format("%-11s", Integer.valueOf(count));
	}

	public static void renderErrorLine(int i, String path) {
		System.out.println("| " + getFormatedI(i) +" | " + getFormatedPath(path) + " | invalid path |");
		System.out.println("----------------------------------------------------------------------------------");
	}
}
