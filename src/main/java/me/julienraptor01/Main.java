package me.julienraptor01;

import me.julienraptor01.control.Controller;
import me.julienraptor01.control.DataAccessLayer;
import me.julienraptor01.control.GuiAccessLayer;
import me.julienraptor01.data.Container;
import me.julienraptor01.gui.MainWindow;

import java.util.logging.Logger;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	private static final DataAccessLayer MODEL = Container.getInstance();
	private static final GuiAccessLayer VIEW = MainWindow.getInstance();

	public static void main(String[] args) {
		/*
		Settings.load();
		LOGGER.info(String.format("The current time is : %s | The application will start maximized : %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern(SETTINGS.getDatetimeFormat())), SETTINGS.isStartMaximized()));
		SETTINGS.setStartMaximized(Settings.DEFAULT_START_MAXIMIZED);
		SETTINGS.setDatetimeFormat(Settings.DEFAULT_DATETIME_FORMAT);
		Settings.save();
		LOGGER.info(CONTAINER.toString());
		CONTAINER.add(new Component.Builder().name("Component").identifier("component").rarity(Rarity.ADMIN).build());
		LOGGER.info(CONTAINER.toString());
		CONTAINER.add(new Bonus.Builder().name("Bonus").identifier("bonus").value(0.0).build());
		LOGGER.info(CONTAINER.toString());
		CONTAINER.add(new Item.Builder().name("Item").identifier("item").rarity(Rarity.ADMIN).reforge("reforge").build());
		LOGGER.info(CONTAINER.toString());
		//CONTAINER.add(new Pet.Builder().name("Pet").identifier("pet").rarity(Rarity.ADMIN).petItem((Item) CONTAINER.stream().filter(element -> element instanceof Item).findFirst().orElse(null)).build());
		//LOGGER.info(CONTAINER.toString());
		//CONTAINER.stream().filter(element -> element instanceof Item).findFirst().ifPresent(CONTAINER::remove);
		//LOGGER.info(CONTAINER.toString());
		//CONTAINER.remove(1);
		//LOGGER.info(CONTAINER.toString());
		//CONTAINER.stream().filter(element -> element instanceof Pet).findFirst().ifPresent(CONTAINER::remove);
		//LOGGER.info(CONTAINER.toString());
		//CONTAINER.removeFirst();
		//LOGGER.info(CONTAINER.toString());
		//CONTAINER.add(new Bonus.Builder().name("Bonus").identifier("bonus").value(0.0).build());
		//LOGGER.info(CONTAINER.toString());
		//CONTAINER.removeLast();
		//LOGGER.info(CONTAINER.toString());
		//CONTAINER.addAll(List.of(new Item.Builder().name("Item").identifier("item").rarity(Rarity.ADMIN).reforge("reforge").build(), new Pet.Builder().name("Pet").identifier("pet").rarity(Rarity.ADMIN).build()));
		//LOGGER.info(CONTAINER.toString());
		CONTAINER.clear();
		LOGGER.info(CONTAINER.toString());
		IntStream.range(0, 100).forEach(i -> {
			CONTAINER.add(new Component.Builder().name("Component").identifier("component").rarity(Rarity.ADMIN).textureLocation(String.join(File.separator, Assets.TEXTURE_LOCATION, "icon.png")).build());
			CONTAINER.add(new Bonus.Builder().name("Bonus").identifier("bonus").value(0.0).build());
			CONTAINER.add(new Item.Builder().name("Item").identifier("item").rarity(Rarity.ADMIN).reforge("reforge").build());
			CONTAINER.add(new Pet.Builder().name("Pet").identifier("pet").rarity(Rarity.ADMIN).build());
		});
		LOGGER.info(CONTAINER.toString());
		SETTINGS.setStartMaximized(false);
		new MainWindow();
		SETTINGS.setStartMaximized(null);
		*/
		Controller controller = new Controller(MODEL, VIEW);
		controller.start();
	}
}
