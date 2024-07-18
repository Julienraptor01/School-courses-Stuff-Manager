package me.julienraptor01.data;

public class Bonus extends BasicElement {
	private double value;

	public Bonus(String name, String identifier, String textureLocation, double value) {
		super(name, identifier, textureLocation);
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
