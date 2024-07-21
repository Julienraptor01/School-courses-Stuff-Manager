package me.julienraptor01.data;

import me.julienraptor01.control.DataAccessLayer;
import me.julienraptor01.data.storage.FileUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * This singleton class is used to store the elements of the application.
 */
public class Container implements DataAccessLayer {
	public static final Logger LOGGER = Logger.getLogger(BasicElement.class.getName());

	private static Container instance = null;

	private static ArrayList<BasicElement> elements = new ArrayList<>();

	/**
	 * Private constructor to prevent instantiation
	 */
	private Container() {
		load();
	}

	/**
	 * Get the instance of the Container class or create a new one if it doesn't exist
	 *
	 * @return the instance of the Container class
	 */
	public static Container getInstance() {
		return instance == null ? instance = new Container() : instance;
	}

	public static void main(String[] args) {
		Container container = Container.getInstance();
		container.add(new Pet.Builder().name("Pet").identifier("pet").rarity(Rarity.VERY_SPECIAL).build());
		LOGGER.info(container.toString());
		container.save();
		LOGGER.info(container.toString());
		container.clear();
		LOGGER.info(container.toString());
		container.load();
		LOGGER.info(container.toString());
	}

	/**
	 * Save the elements to the file
	 */
	@Override
	public void save() {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FileUtils.DATA_PATH))) {
			objectOutputStream.writeObject(elements);
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
	}

	/**
	 * Load the elements from the file
	 */
	@Override
	public void load() {
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FileUtils.DATA_PATH))) {
			elements = ((ArrayList<?>) objectInputStream.readObject()).stream().filter(element -> element instanceof BasicElement).map(element -> (BasicElement) element).collect(Collectors.toCollection(ArrayList::new));
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
	}

	/**
	 * Get the number of elements in the container
	 *
	 * @return the number of elements
	 */
	@Override
	public int size() {
		return elements.size();
	}

	/**
	 * Set the element at the index
	 *
	 * @param index the index of the element
	 */
	@Override
	public void set(int index, BasicElement element) {
		elements.set(index, element);
	}

	/**
	 * Get an element from the container
	 *
	 * @param index the index of the element
	 * @return the element
	 */
	@Override
	public BasicElement get(int index) {
		return elements.get(index);
	}

	/**
	 * Add an element to the container
	 *
	 * @param element the element to add
	 */
	@Override
	public void add(BasicElement element) {
		elements.add(element);
	}

	/**
	 * Remove an element from the container
	 *
	 * @param index the index of the element to remove
	 */
	@Override
	public void remove(int index) {
		elements.remove(index);
	}

	/**
	 * Clear the container
	 */
	@Override
	public void clear() {
		elements.clear();
	}

	@Override
	public String toString() {
		return String.format("Container[%s%s]", elements.stream().map(element -> String.format("\n\t%s", element)).collect(Collectors.joining()), elements.isEmpty() ? " " : "\n");
	}
}
