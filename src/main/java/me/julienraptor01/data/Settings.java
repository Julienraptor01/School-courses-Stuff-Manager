package me.julienraptor01.data;

/**
 * This singleton class is used to store the settings of the application.
 */
public class Settings {
	public static final boolean DEFAULT_START_MAXIMIZED = true;
	public static final String DEFAULT_DATETIME_FORMAT = "YYYY/MM/dd HH:mm:ss";

	private static Boolean startMaximized = null;
	private static String datetimeFormat = null;

	private static Settings instance = null;

	private Settings() {
	}

	public static Settings getInstance() {
		return instance == null ? instance = new Settings() : instance;
	}

	public boolean isStartMaximized() {
		return startMaximized == null ? DEFAULT_START_MAXIMIZED : startMaximized;
	}

	public void setStartMaximized(Boolean startMaximized) {
		Settings.startMaximized = startMaximized;
	}

	public String getDatetimeFormat() {
		return datetimeFormat == null ? DEFAULT_DATETIME_FORMAT : datetimeFormat;
	}

	public void setDatetimeFormat(String datetimeFormat) {
		Settings.datetimeFormat = datetimeFormat;
	}
}
