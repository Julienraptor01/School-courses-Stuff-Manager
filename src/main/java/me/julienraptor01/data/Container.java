package me.julienraptor01.data;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * This singleton class is used to store the elements of the application.
 */
public class Container {
	private static final Logger LOGGER = Logger.getLogger(Container.class.getName());

	private static List<BasicElement> elements = List.of();

	private static Container instance = null;

	/**
	 * Private constructor to prevent instantiation
	 */
	private Container() {
		elements = List.of(new Bonus.Builder().name("Bonus").identifier("bonus").value(0.0).build(), new Component.Builder().name("Component").identifier("component").rarity(Rarity.ADMIN).build(), new Item.Builder().name("Item").identifier("item").rarity(Rarity.ADMIN).reforge("reforge").build(), new Pet.Builder().name("Pet").identifier("pet").rarity(Rarity.ADMIN).petItem(new Item.Builder().build()).build());
	}

	/**
	 * Get the instance of the Container class or create a new one if it doesn't exist
	 *
	 * @return the instance of the Container class
	 */
	public static Container getInstance() {
		return instance == null ? instance = new Container() : instance;
	}

	/**
	 * Get the elements of the application
	 *
	 * @return the elements of the application
	 */
	public List<BasicElement> getElements() {
		return elements;
	}

	@Override
	public String toString() {
		return String.format("Container[%s%s]", elements.stream().map(element -> String.format("\n\t%s", element)).collect(Collectors.joining()), elements.isEmpty() ? " " : "\n");
	}
}
