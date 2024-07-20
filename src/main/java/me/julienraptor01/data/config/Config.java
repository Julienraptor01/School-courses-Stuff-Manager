package me.julienraptor01.data.config;

import me.julienraptor01.data.storage.FileUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Config {
	private static final Logger LOGGER = Logger.getLogger(Config.class.getName());

	private static final Settings settings = Settings.getInstance();

	private static final String savePath = String.join(File.separator, FileUtils.ROOT_SAVE_PATH, "config.properties");

	private static final String START_MAXIMIZED = "startMaximized";
	private static final String DATETIME_FORMAT = "datetimeFormat";

	public static void loadConfig() {
		try (FileInputStream fileInputStream = new FileInputStream(savePath)) {
			Properties properties = new Properties();
			properties.load(fileInputStream);
			settings.setStartMaximized(BooleanUtils.toBooleanObject(properties.getProperty(START_MAXIMIZED)));
			settings.setDatetimeFormat(StringUtils.equals(properties.getProperty(DATETIME_FORMAT), "null") ? null : properties.getProperty(DATETIME_FORMAT));
		} catch (IOException e) {
			LOGGER.warning("Failed to load the properties : " + e.getMessage());
		}
	}

	public static void saveConfig() {
		if (!new File(savePath).exists() && !new File(savePath).getParentFile().mkdirs()) {
			LOGGER.severe("Failed to create the save directory");
		}
		Properties properties = new Properties();
		properties.setProperty(START_MAXIMIZED, String.valueOf(settings.getStartMaximizedValue()));
		properties.setProperty(DATETIME_FORMAT, String.valueOf(settings.getDatetimeFormatValue()));
		try (FileOutputStream fileOutputStream = new FileOutputStream(savePath)) {
			properties.store(fileOutputStream, null);
		} catch (IOException e) {
			LOGGER.severe("Failed to save the properties : " + e.getMessage());
		}
	}
}
