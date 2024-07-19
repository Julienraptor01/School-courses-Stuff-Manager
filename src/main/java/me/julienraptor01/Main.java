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

	private static final Settings settings = Settings.getInstance();
	private static final Container container = Container.getInstance();

	public static void main(String[] args) {
		Config.loadConfig();
		LOGGER.info(String.format("The current time is : %s | The application will start maximized : %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern(settings.getDatetimeFormat())), settings.isStartMaximized()));
		settings.setStartMaximized(Settings.DEFAULT_START_MAXIMIZED);
		settings.setDatetimeFormat(Settings.DEFAULT_DATETIME_FORMAT);
		Config.saveConfig();
		LOGGER.info(container.toString());
		container.elements.add(new Bonus.Builder().name("Bonus").identifier("bonus").value(0.0).build());
		LOGGER.info(container.toString());
		container.elements.add(new Component.Builder().name("Component").identifier("component").rarity(Rarity.ADMIN).build());
		LOGGER.info(container.toString());
		container.elements.add(new Item.Builder().name("Item").identifier("item").rarity(Rarity.ADMIN).reforge("reforge").build());
		LOGGER.info(container.toString());
		container.elements.add(new Pet.Builder().name("Pet").identifier("pet").rarity(Rarity.ADMIN).petItem((Item) container.elements.stream().filter(element -> element instanceof Item).findFirst().orElse(null)).build());
		LOGGER.info(container.toString());
		container.elements.stream().filter(element -> element instanceof Item).findFirst().ifPresent(element -> container.elements.remove(element));
		LOGGER.info(container.toString());
		container.elements.remove(1);
		LOGGER.info(container.toString());
		container.elements.stream().filter(element -> element instanceof Pet).findFirst().ifPresent(element -> container.elements.remove(element));
		LOGGER.info(container.toString());
		container.elements.removeFirst();
		LOGGER.info(container.toString());
		container.elements.add(new Bonus.Builder().name("Bonus").identifier("bonus").value(0.0).build());
		LOGGER.info(container.toString());
		container.elements.removeLast();
		LOGGER.info(container.toString());
		container.elements.addAll(List.of(new Item.Builder().name("Item").identifier("item").rarity(Rarity.ADMIN).reforge("reforge").build(), new Pet.Builder().name("Pet").identifier("pet").rarity(Rarity.ADMIN).build()));
		LOGGER.info(container.toString());
		container.elements.clear();
		LOGGER.info(container.toString());
	}
}
