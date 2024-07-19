package me.julienraptor01.data;

import org.jetbrains.annotations.NotNull;

public class Stats {
	private int health;
	private int defense;
	private int strength;
	private int intelligence;
	private int critChance;
	private int critDamage;

	private Stats(@NotNull Builder builder) {
		this.health = builder.health;
		this.defense = builder.defense;
		this.strength = builder.strength;
		this.intelligence = builder.intelligence;
		this.critChance = builder.critChance;
		this.critDamage = builder.critDamage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getCritChance() {
		return critChance;
	}

	public void setCritChance(int critChance) {
		this.critChance = critChance;
	}

	public int getCritDamage() {
		return critDamage;
	}

	public void setCritDamage(int critDamage) {
		this.critDamage = critDamage;
	}

	@Override
	public String toString() {
		return String.format("Stats{health=%d, defense=%d, strength=%d, intelligence=%d, critChance=%d, critDamage=%d}", health, defense, strength, intelligence, critChance, critDamage);
	}

	public static class Builder {
		private int health = 0;
		private int defense = 0;
		private int strength = 0;
		private int intelligence = 0;
		private int critChance = 0;
		private int critDamage = 0;

		public Builder health(int health) {
			this.health = health;
			return this;
		}

		public Builder defense(int defense) {
			this.defense = defense;
			return this;
		}

		public Builder strength(int strength) {
			this.strength = strength;
			return this;
		}

		public Builder intelligence(int intelligence) {
			this.intelligence = intelligence;
			return this;
		}

		public Builder critChance(int critChance) {
			this.critChance = critChance;
			return this;
		}

		public Builder critDamage(int critDamage) {
			this.critDamage = critDamage;
			return this;
		}

		public Stats build() {
			return new Stats(this);
		}
	}
}
