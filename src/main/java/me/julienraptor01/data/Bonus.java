package me.julienraptor01.data;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.util.logging.Logger;

public class Bonus extends BasicElement implements Serializable {
	public static final Logger LOGGER = Logger.getLogger(BasicElement.class.getName());

	private double value;

	private Bonus(@NotNull Builder builder) {
		super(builder.name, builder.identifier, builder.textureLocation, builder.timestamp);
		this.setValue(builder.value);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.format("Bonus{%s, value=%f}", super.toString(), value);
	}

	public static class Builder {
		private String name = "";
		private String identifier = "";
		private String textureLocation = "";
		private Long timestamp = Instant.now().getEpochSecond();
		private double value = 0.0;

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

		public Builder value(double value) {
			this.value = value;
			return this;
		}

		public Bonus build() {
			return new Bonus(this);
		}
	}
}
