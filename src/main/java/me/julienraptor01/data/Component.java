package me.julienraptor01.data;

public class Component extends BasicElement {
	private Rarity rarity;

	public Component(String name, String identifier, String textureLocation, Rarity rarity) {
		super(name, identifier, textureLocation);
		this.rarity = rarity;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}
}
