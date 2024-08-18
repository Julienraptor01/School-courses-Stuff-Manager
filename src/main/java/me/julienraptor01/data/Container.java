package me.julienraptor01.data;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import me.julienraptor01.data.complex.Pet;
import me.julienraptor01.data.storage.FileUtils;
import me.julienraptor01.data.template.BasicElement;
import me.julienraptor01.data.template.Rarity;

/**
 * This singleton class is used to store the elements of the application.
 */
public class Container implements DataAccessLayer {
	private static final Logger LOGGER = Logger.getLogger(Container.class.getName());

	private static Container instance = null;

	private static Map<Integer, BasicElement> elements = new HashMap<>();

	private int internalId = 0;

	/**
	 * Private constructor to prevent instantiation
	 */
	private Container() {
	}

	/**
	 * Get the instance of the Container class or create a new one if it doesn't exist
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
		LOGGER.info(container.toString());
		container.load();
		LOGGER.info(container.toString());
	}

	/**
	 * Save the elements to the file
	 */
	@Override
	public void save() {
		File file = new File(FileUtils.DATA_PATH);
		if (!file.exists()) {
			boolean ignored = file.getParentFile().mkdirs();
		}
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FileUtils.DATA_PATH))) {
			objectOutputStream.writeObject(internalId);
			objectOutputStream.writeObject(new ArrayList<>(elements.values()));
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
			internalId = (int) objectInputStream.readObject();
			elements = ((ArrayList<?>) objectInputStream.readObject()).stream().collect(Collectors.toMap(element -> ((BasicElement) element).getInternalId(), element -> (BasicElement) element));
			LOGGER.info(String.format("Loaded %d elements", elements.size()));
			LOGGER.info(String.format("Internal : %d", internalId));
			LOGGER.info(elements.toString());
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
	}

	/**
	 * Get the elements
	 * @return the elements
	 */
	public ArrayList<BasicElement> getElements() {
		return new ArrayList<>(elements.values());
	}

	/**
	 * Set the Element at the index
	 * @param id the index of the Element
	 */
	@Override
	public void set(int id, BasicElement element) {
		elements.put(id, element);
	}

	/**
	 * Get an Element from the container
	 * @param id the index of the Element
	 * @return the Element
	 */
	@Override
	public BasicElement get(int id) {
		return elements.get(id);
	}

	/**
	 * Add an Element to the container
	 * @param element the Element to add
	 */
	@Override
	public void add(BasicElement element) {
		element.setInternalId(internalId++);
		elements.put(element.getInternalId(), element);
	}

	/**
	 * Remove an Element from the container
	 * @param id the index of the Element to remove
	 */
	@Override
	public void remove(int id) {
		elements.remove(id);
	}

	/**
	 * Get the internal id
	 * @return the internal id
	 */
	public int getInternalId() {
		return internalId;
	}

	@Override
	public String toString() {
		return String.format("Container[%s%s]", elements.values().stream().map(basicElement -> String.format("\n\t%s", basicElement)).collect(Collectors.joining()), elements.isEmpty() ? " " : "\n");
	}
}
