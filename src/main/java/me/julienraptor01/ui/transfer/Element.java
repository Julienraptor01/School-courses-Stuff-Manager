package me.julienraptor01.ui.transfer;

import java.time.Instant;

import org.jetbrains.annotations.NotNull;

import me.julienraptor01.data.complex.Bonus;
import me.julienraptor01.data.template.Rarity;

public class Element {
	public String type;
	public String name;
	public String identifier;
	public String textureLocation;
	public Long timestamp;
	public double value;
	public Rarity rarity;
	public int health;
	public int defense;
	public int strength;
	public int intelligence;
	public int critChance;
	public int critDamage;
	public String reforge;
	public String petItemName;
	public String petItemIdentifier;
	public String petItemTextureLocation;
	public Long petItemTimestamp;
	public Rarity petItemRarity;
	public int petItemHealth;
	public int petItemDefense;
	public int petItemStrength;
	public int petItemIntelligence;
	public int petItemCritChance;
	public int petItemCritDamage;
	public String petItemReforge;

	public Element() {
		this.type = Bonus.class.getSimpleName();
		this.name = "";
		this.identifier = "";
		this.textureLocation = "";
		this.timestamp = Instant.now().getEpochSecond();
		this.value = 0.0;
		this.rarity = Rarity.COMMON;
		this.health = 0;
		this.defense = 0;
		this.strength = 0;
		this.intelligence = 0;
		this.critChance = 0;
		this.critDamage = 0;
		this.reforge = "";
		this.petItemName = "";
		this.petItemIdentifier = "";
		this.petItemTextureLocation = "";
		this.petItemTimestamp = Instant.now().getEpochSecond();
		this.petItemRarity = Rarity.COMMON;
		this.petItemHealth = 0;
		this.petItemDefense = 0;
		this.petItemStrength = 0;
		this.petItemIntelligence = 0;
		this.petItemCritChance = 0;
		this.petItemCritDamage = 0;
		this.petItemReforge = "";
	}

	public Element(String type, String name, String identifier, String textureLocation, Long timestamp, double value, Rarity rarity, int health, int defense, int strength, int intelligence, int critChance, int critDamage, String reforge, String petItemName, String petItemIdentifier, String petItemTextureLocation, Long petItemTimestamp, Rarity petItemRarity, int petItemHealth, int petItemDefense, int petItemStrength, int petItemIntelligence, int petItemCritChance, int petItemCritDamage, String petItemReforge) {
		this.type = type;
		this.name = name;
		this.identifier = identifier;
		this.textureLocation = textureLocation;
		this.timestamp = timestamp;
		this.value = value;
		this.rarity = rarity;
		this.health = health;
		this.defense = defense;
		this.strength = strength;
		this.intelligence = intelligence;
		this.critChance = critChance;
		this.critDamage = critDamage;
		this.reforge = reforge;
		this.petItemName = petItemName;
		this.petItemIdentifier = petItemIdentifier;
		this.petItemTextureLocation = petItemTextureLocation;
		this.petItemTimestamp = petItemTimestamp;
		this.petItemRarity = petItemRarity;
		this.petItemHealth = petItemHealth;
		this.petItemDefense = petItemDefense;
		this.petItemStrength = petItemStrength;
		this.petItemIntelligence = petItemIntelligence;
		this.petItemCritChance = petItemCritChance;
		this.petItemCritDamage = petItemCritDamage;
		this.petItemReforge = petItemReforge;
	}

	public static void resetType(@NotNull Element element) {
		element.type = Bonus.class.getSimpleName();
	}

	public static void resetName(@NotNull Element element) {
		element.name = "";
	}

	public static void resetIdentifier(@NotNull Element element) {
		element.identifier = "";
	}

	public static void resetTextureLocation(@NotNull Element element) {
		element.textureLocation = "";
	}

	public static void resetTimestamp(@NotNull Element element) {
		element.timestamp = Instant.now().getEpochSecond();
	}

	public static void resetValue(@NotNull Element element) {
		element.value = 0.0;
	}

	public static void resetRarity(@NotNull Element element) {
		element.rarity = Rarity.COMMON;
	}

	public static void resetHealth(@NotNull Element element) {
		element.health = 0;
	}

	public static void resetDefense(@NotNull Element element) {
		element.defense = 0;
	}

	public static void resetStrength(@NotNull Element element) {
		element.strength = 0;
	}

	public static void resetIntelligence(@NotNull Element element) {
		element.intelligence = 0;
	}

	public static void resetCritChance(@NotNull Element element) {
		element.critChance = 0;
	}

	public static void resetCritDamage(@NotNull Element element) {
		element.critDamage = 0;
	}

	public static void resetReforge(@NotNull Element element) {
		element.reforge = "";
	}

	public static void resetPetItemName(@NotNull Element element) {
		element.petItemName = "";
	}

	public static void resetPetItemIdentifier(@NotNull Element element) {
		element.petItemIdentifier = "";
	}

	public static void resetPetItemTextureLocation(@NotNull Element element) {
		element.petItemTextureLocation = "";
	}

	public static void resetPetItemTimestamp(@NotNull Element element) {
		element.petItemTimestamp = Instant.now().getEpochSecond();
	}

	public static void resetPetItemRarity(@NotNull Element element) {
		element.petItemRarity = Rarity.COMMON;
	}

	public static void resetPetItemHealth(@NotNull Element element) {
		element.petItemHealth = 0;
	}

	public static void resetPetItemDefense(@NotNull Element element) {
		element.petItemDefense = 0;
	}

	public static void resetPetItemStrength(@NotNull Element element) {
		element.petItemStrength = 0;
	}

	public static void resetPetItemIntelligence(@NotNull Element element) {
		element.petItemIntelligence = 0;
	}

	public static void resetPetItemCritChance(@NotNull Element element) {
		element.petItemCritChance = 0;
	}

	public static void resetPetItemCritDamage(@NotNull Element element) {
		element.petItemCritDamage = 0;
	}

	public static void resetPetItemReforge(@NotNull Element element) {
		element.petItemReforge = "";
	}
}
