package me.julienraptor01.data;

public class Item extends Component {
	private Stats stats;
	private String reforge;

	public Item(String name, String identifier, String textureLocation, Rarity rarity, Stats stats, String reforge) {
		super(name, identifier, textureLocation, rarity);
		this.stats = stats;
		this.reforge = reforge;
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
}
