package me.julienraptor01.data;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * This singleton class is used to store the elements of the application.
 */
public class Elements extends ArrayList<BasicElement> {
	private static Elements instance = null;

	/**
	 * Private constructor to prevent instantiation
	 */
	private Elements() {
	}

	/**
	 * Get the instance of the Elements class or create a new one if it doesn't exist
	 *
	 * @return the instance of the Elements class
	 */
	public static Elements getInstance() {
		return instance == null ? instance = new Elements() : instance;
	}

	@Override
	public String toString() {
		return String.format("Elements[%s%s]", this.stream().map(element -> String.format("\n\t%s", element)).collect(Collectors.joining()), this.isEmpty() ? " " : "\n");
	}
}
