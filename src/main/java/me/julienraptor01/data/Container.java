package me.julienraptor01.data;

import me.julienraptor01.data.storage.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * This singleton class is used to store the elements of the application.
 */
public class Container extends ArrayList<BasicElement> implements Serializable {
	public static final Logger LOGGER = Logger.getLogger(BasicElement.class.getName());

	private static Container instance = null;

	/**
	 * Private constructor to prevent instantiation
	 */
	private Container() {
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
		container.add(new Pet.Builder().name("Pet 1").rarity(Rarity.VERY_SPECIAL).build());
		LOGGER.info("Container: " + container);
		//try to serialize to a file
		container.saveToFile();

		//try to deserialize from a file
		Container deserializedContainer = null;
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(String.join(File.separator, FileUtils.ROOT_SAVE_PATH, "container.ser")))) {
			deserializedContainer = (Container) objectInputStream.readObject();
		} catch (Exception e) {
			LOGGER.severe("An error occurred while deserializing the container: " + e.getMessage());
			e.printStackTrace();
		}

		//add all elements from the deserialized container to the original container
		container.addAll(deserializedContainer);
		LOGGER.info("Container after deserialization: " + container);
	}

	public void saveToFile() {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(String.join(File.separator, FileUtils.ROOT_SAVE_PATH, "container.ser")))) {
			objectOutputStream.writeObject(this);
		} catch (Exception e) {
			LOGGER.severe("An error occurred while serializing the container: " + e.getMessage());
		}
	}

	public void loadFromFile() {
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(String.join(File.separator, FileUtils.ROOT_SAVE_PATH, "container.ser")))) {
			Container deserializedContainer = (Container) objectInputStream.readObject();
			this.addAll(deserializedContainer);
		} catch (Exception e) {
			LOGGER.severe("An error occurred while deserializing the container: " + e.getMessage());
		}
	}

	@Override
	public String toString() {
		return String.format("Container[%s%s]", this.stream().map(element -> String.format("\n\t%s", element)).collect(Collectors.joining()), this.isEmpty() ? " " : "\n");
	}
}
