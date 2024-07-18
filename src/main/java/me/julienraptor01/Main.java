package me.julienraptor01;

import me.julienraptor01.data.config.Config;
import me.julienraptor01.data.config.Settings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		Config.loadConfig();
		LOGGER.info("Current time : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern(Settings.getInstance().getDatetimeFormat())));
		LOGGER.info("The application will start maximized : " + Settings.getInstance().isStartMaximized());
	}
}
