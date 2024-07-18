package me.julienraptor01.data;

public class Pet {
	private Component component;
	private Stats stats;
	private Item petItem;

	public Pet(Component component, Stats stats, Item petItem) {
		this.component = component;
		this.stats = stats;
		this.petItem = petItem;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
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
}
