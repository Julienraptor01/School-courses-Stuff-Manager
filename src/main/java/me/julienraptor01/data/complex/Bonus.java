package me.julienraptor01.data.complex;

import java.io.Serializable;
import java.time.Instant;

import org.jetbrains.annotations.NotNull;

import me.julienraptor01.data.template.BasicElement;

public class Bonus extends BasicElement implements Serializable {
	private double value;

	private Bonus(@NotNull Builder builder) {
		super(-1, builder.name, builder.identifier, builder.textureLocation, builder.timestamp);
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
