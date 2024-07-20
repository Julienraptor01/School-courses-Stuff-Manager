package me.julienraptor01.data.storage;

import me.julienraptor01.data.config.Config;

import java.io.File;
import java.util.logging.Logger;

public class FileUtils {
	public static final String ROOT_SAVE_PATH = String.join(File.separator, System.getProperty("user.home"), "School-Courses-Java");
	private static final Logger LOGGER = Logger.getLogger(Config.class.getName());
}
