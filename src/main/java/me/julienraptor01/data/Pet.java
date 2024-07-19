package me.julienraptor01.data;

import org.jetbrains.annotations.NotNull;

import java.time.Instant;

public class Pet extends Component {
	private Stats stats;
	private Item petItem;

	private Pet(@NotNull Builder builder) {
		super(builder.name, builder.identifier, builder.textureLocation, builder.timestamp, builder.rarity);
		this.stats = builder.stats;
		this.petItem = builder.petItem;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public Item getPetItem() {
		return petItem;
	}

	public void setPetItem(Item petItem) {
		this.petItem = petItem;
	}

	@Override
	public String toString() {
		return String.format("Pet{%s, stats=%s, petItem=%s}", super.toString(), stats, petItem);
	}

	public static class Builder {
		private String name = "";
		private String identifier = "";
		private String textureLocation = "";
		private Long timestamp = Instant.now().getEpochSecond();
		private Rarity rarity = Rarity.COMMON;
		private Stats stats = new Stats.Builder().build();
		private Item petItem = null;

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

		public Builder stats(Stats stats) {
			this.stats = stats;
			return this;
		}

		public Builder petItem(Item petItem) {
			this.petItem = petItem;
			return this;
		}

		public Pet build() {
			return new Pet(this);
		}
	}
}
