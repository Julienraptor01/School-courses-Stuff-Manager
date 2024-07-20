package me.julienraptor01;

import me.julienraptor01.data.*;
import me.julienraptor01.data.config.Config;
import me.julienraptor01.data.config.Settings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	private static final Settings SETTINGS = Settings.getInstance();
	private static final Elements ELEMENTS = Elements.getInstance();

	public static void main(String[] args) {
		Config.loadConfig();
		LOGGER.info(String.format("The current time is : %s | The application will start maximized : %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern(SETTINGS.getDatetimeFormat())), SETTINGS.isStartMaximized()));
		SETTINGS.setStartMaximized(Settings.DEFAULT_START_MAXIMIZED);
		SETTINGS.setDatetimeFormat(Settings.DEFAULT_DATETIME_FORMAT);
		Config.saveConfig();
		LOGGER.info(ELEMENTS.toString());
		ELEMENTS.add(new Component.Builder().name("Component").identifier("component").rarity(Rarity.ADMIN).build());
		LOGGER.info(ELEMENTS.toString());
		ELEMENTS.add(new Bonus.Builder().name("Bonus").identifier("bonus").value(0.0).build());
		LOGGER.info(ELEMENTS.toString());
		ELEMENTS.add(new Item.Builder().name("Item").identifier("item").rarity(Rarity.ADMIN).reforge("reforge").build());
		LOGGER.info(ELEMENTS.toString());
		ELEMENTS.add(new Pet.Builder().name("Pet").identifier("pet").rarity(Rarity.ADMIN).petItem((Item) ELEMENTS.stream().filter(element -> element instanceof Item).findFirst().orElse(null)).build());
		LOGGER.info(ELEMENTS.toString());
		ELEMENTS.stream().filter(element -> element instanceof Item).findFirst().ifPresent(ELEMENTS::remove);
		LOGGER.info(ELEMENTS.toString());
		ELEMENTS.remove(1);
		LOGGER.info(ELEMENTS.toString());
		ELEMENTS.stream().filter(element -> element instanceof Pet).findFirst().ifPresent(ELEMENTS::remove);
		LOGGER.info(ELEMENTS.toString());
		ELEMENTS.removeFirst();
		LOGGER.info(ELEMENTS.toString());
		ELEMENTS.add(new Bonus.Builder().name("Bonus").identifier("bonus").value(0.0).build());
		LOGGER.info(ELEMENTS.toString());
		ELEMENTS.removeLast();
		LOGGER.info(ELEMENTS.toString());
		ELEMENTS.addAll(List.of(new Item.Builder().name("Item").identifier("item").rarity(Rarity.ADMIN).reforge("reforge").build(), new Pet.Builder().name("Pet").identifier("pet").rarity(Rarity.ADMIN).build()));
		LOGGER.info(ELEMENTS.toString());
		ELEMENTS.clear();
		LOGGER.info(ELEMENTS.toString());
	}
}
