package me.julienraptor01.data;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This singleton class is used to store the elements of the application.
 */
public class Container {
	private static Container instance = null;
	public List<BasicElement> elements = new LinkedList<>();

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

	@Override
	public String toString() {
		return String.format("Container[%s%s]", elements.stream().map(element -> String.format("\n\t%s", element)).collect(Collectors.joining()), elements.isEmpty() ? " " : "\n");
	}
}
