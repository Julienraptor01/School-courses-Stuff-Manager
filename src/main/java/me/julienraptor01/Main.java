package me.julienraptor01;

import me.julienraptor01.data.Container;
import me.julienraptor01.data.config.Config;
import me.julienraptor01.data.config.Settings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	private static final Settings settings = Settings.getInstance();
	private static final Container container = Container.getInstance();

	public static void main(String[] args) {
		Config.loadConfig();
		LOGGER.info(String.format("The current time is : %s | The application will start maximized : %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern(settings.getDatetimeFormat())), settings.isStartMaximized()));
		settings.setStartMaximized(Settings.DEFAULT_START_MAXIMIZED);
		settings.setDatetimeFormat(Settings.DEFAULT_DATETIME_FORMAT);
		Config.saveConfig();
		LOGGER.info(container.toString());
	}
}
