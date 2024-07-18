package me.julienraptor01.data.config;

/**
 * This singleton class is used to store the settings of the application.
 */
public class Settings {
	public static final boolean DEFAULT_START_MAXIMIZED = true;
	public static final String DEFAULT_DATETIME_FORMAT = "YYYY/MM/dd HH:mm:ss";

	private static Boolean startMaximized = null;
	private static String datetimeFormat = null;

	private static Settings instance = null;

	/**
	 * Private constructor to prevent instantiation
	 */
	private Settings() {
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
		Settings.startMaximized = startMaximized;
	}

	/**
	 * Get the startMaximized value
	 *
	 * @return the startMaximized value
	 */
	protected Boolean getStartMaximizedValue() {
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
		Settings.datetimeFormat = datetimeFormat;
	}

	/**
	 * Get the datetimeFormat value
	 *
	 * @return the datetimeFormat value
	 */
	protected String getDatetimeFormatValue() {
		return datetimeFormat;
	}
}
