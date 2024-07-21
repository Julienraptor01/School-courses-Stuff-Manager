package me.julienraptor01.data;

import me.julienraptor01.data.storage.FileUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * This singleton class is used to store the settings of the application.
 */
public class Settings {
	public static final boolean DEFAULT_START_MAXIMIZED = true;
	public static final String DEFAULT_DATETIME_FORMAT = "YYYY/MM/dd HH:mm:ss";

	private static final Logger LOGGER = Logger.getLogger(Settings.class.getName());

	private static final String START_MAXIMIZED_PROPERTY = "startMaximized";
	private static final String DATETIME_FORMAT_PROPERTY = "datetimeFormat";

	private static Settings instance = null;

	private Boolean startMaximized = null;
	private String datetimeFormat = null;

	/**
	 * Private constructor to prevent instantiation
	 */
	private Settings() {
		load();
	}

	/**
	 * Get the instance of the Settings class or create a new one if it doesn't exist
	 *
	 * @return the instance of the Settings class
	 */
	public static Settings getInstance() {
		return instance == null ? instance = new Settings() : instance;
	}

	/**
	 * Load the settings from the file
	 */
	public void load() {
		try (FileInputStream fileInputStream = new FileInputStream(FileUtils.CONFIG_PATH)) {
			Properties properties = new Properties();
			properties.load(fileInputStream);
			startMaximized = BooleanUtils.toBooleanObject(properties.getProperty(START_MAXIMIZED_PROPERTY));
			String datetimeFormatString = properties.getProperty(DATETIME_FORMAT_PROPERTY);
			datetimeFormat = StringUtils.equals(datetimeFormatString, "null") ? null : datetimeFormatString;
		} catch (IOException e) {
			LOGGER.warning(e.getMessage());
		}
	}

	/**
	 * Save the settings to the file
	 */
	public void save() {
		if (!new File(FileUtils.CONFIG_PATH).exists() && !new File(FileUtils.CONFIG_PATH).getParentFile().mkdirs()) {
			LOGGER.severe("Failed to create the save directory");
		}
		Properties properties = new Properties();
		properties.setProperty(START_MAXIMIZED_PROPERTY, String.valueOf(startMaximized));
		properties.setProperty(DATETIME_FORMAT_PROPERTY, String.valueOf(datetimeFormat));
		try (FileOutputStream fileOutputStream = new FileOutputStream(FileUtils.CONFIG_PATH)) {
			properties.store(fileOutputStream, null);
		} catch (IOException e) {
			LOGGER.severe(e.getMessage());
		}
	}

	/**
	 * If the startMaximized is null, {@link #DEFAULT_START_MAXIMIZED} is returned
	 *
	 * @return weather the application should start maximized or not
	 */
	public boolean isStartMaximized() {
		return startMaximized == null ? DEFAULT_START_MAXIMIZED : startMaximized;
	}

	/**
	 * Set if the application should start maximized or not<br>
	 * When set to null {@link #isStartMaximized()} returns {@link #DEFAULT_START_MAXIMIZED}
	 *
	 * @param startMaximized if the application should start maximized or not
	 */
	public void setStartMaximized(Boolean startMaximized) {
		this.startMaximized = startMaximized;
	}

	/**
	 * Get the startMaximized value
	 *
	 * @return the startMaximized value
	 */
	public Boolean getStartMaximizedValue() {
		return startMaximized;
	}

	/**
	 * If the datetimeFormat is null, {@link #DEFAULT_DATETIME_FORMAT} is returned
	 *
	 * @return the format of the date and time
	 */
	public String getDatetimeFormat() {
		return datetimeFormat == null ? DEFAULT_DATETIME_FORMAT : datetimeFormat;
	}

	/**
	 * Set the format of the date and time<br>
	 * See {@link java.time.format.DateTimeFormatter} for the format syntax<br>
	 * When set to null {@link #getDatetimeFormat()} returns {@link #DEFAULT_DATETIME_FORMAT}
	 *
	 * @param datetimeFormat the format of the date and time
	 */
	public void setDatetimeFormat(String datetimeFormat) {
		this.datetimeFormat = datetimeFormat;
	}

	/**
	 * Get the datetimeFormat value
	 *
	 * @return the datetimeFormat value
	 */
	public String getDatetimeFormatValue() {
		return datetimeFormat;
	}
}
