package me.julienraptor01.data;

import org.jetbrains.annotations.NotNull;

import java.time.Instant;

public class Item extends Component {
	private Stats stats;
	private String reforge;

	private Item(@NotNull Builder builder) {
		super(builder.name, builder.identifier, builder.textureLocation, builder.timestamp, builder.rarity);
		this.setStats(builder.stats);
		this.setReforge(builder.reforge);
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public String getReforge() {
		return reforge;
	}

	public void setReforge(String reforge) {
		this.reforge = reforge;
	}

	@Override
	public String toString() {
		return String.format("Item{%s, stats=%s, reforge='%s'}", super.toString(), stats, reforge);
	}

	public static class Builder {
		private String name = "";
		private String identifier = "";
		private String textureLocation = "";
		private Long timestamp = Instant.now().getEpochSecond();
		private Rarity rarity = Rarity.COMMON;
		private Stats stats = new Stats.Builder().build();
		private String reforge = "";

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

		public Builder reforge(String reforge) {
			this.reforge = reforge;
			return this;
		}

		public Item build() {
			return new Item(this);
		}
	}
}
