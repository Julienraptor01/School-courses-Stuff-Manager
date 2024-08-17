package me.julienraptor01.data.complex;

import java.io.Serializable;
import java.time.Instant;

import org.jetbrains.annotations.NotNull;

import me.julienraptor01.data.template.BasicElement;
import me.julienraptor01.data.template.Rarity;

public class Component extends BasicElement implements Serializable {
	private Rarity rarity;

	protected Component(String name, String identifier, String textureLocation, Long timestamp, Rarity rarity) {
		super(-1, name, identifier, textureLocation, timestamp);
		this.rarity = rarity;
	}

	protected Component(@NotNull Builder builder) {
		super(-1, builder.name, builder.identifier, builder.textureLocation, builder.timestamp);
		this.rarity = builder.rarity;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	@Override
	public String toString() {
		return String.format("Component{%s, rarity=%s}", super.toString(), rarity);
	}

	public static class Builder {
		private String name = "";
		private String identifier = "";
		private String textureLocation = "";
		private Long timestamp = Instant.now().getEpochSecond();
		private Rarity rarity = Rarity.COMMON;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder identifier(String identifier) {
			this.identifier = identifier;
			return this;
		}

		public Builder textureLocation(String textureLocation) {
			this.textureLocation = textureLocation;
			return this;
		}

		public Builder timestamp(Long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder rarity(Rarity rarity) {
			this.rarity = rarity;
			return this;
		}

		public Component build() {
			return new Component(this);
		}
	}
}
