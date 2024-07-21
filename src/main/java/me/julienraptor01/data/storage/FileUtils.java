package me.julienraptor01.data.storage;

import java.io.File;

public class FileUtils {
	public static final String ROOT_PATH = String.join(File.separator, System.getProperty("user.home"), "School-Courses-Java");
	public static final String CONFIG_PATH = String.join(File.separator, ROOT_PATH, "config.properties");
	public static final String DATA_PATH = String.join(File.separator, ROOT_PATH, "data");
}
