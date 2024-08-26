package me.julienraptor01.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import me.julienraptor01.data.DataAccessLayer;
import me.julienraptor01.data.complex.Bonus;
import me.julienraptor01.data.complex.Component;
import me.julienraptor01.data.complex.Item;
import me.julienraptor01.data.complex.Pet;
import me.julienraptor01.data.template.BasicElement;
import me.julienraptor01.data.template.Stats;
import me.julienraptor01.ui.UIAccessLayer;
import me.julienraptor01.ui.transfer.DetailTuple;
import me.julienraptor01.ui.transfer.Element;

public class Controller implements ActionListener {
	private final DataAccessLayer dataAccessLayer;
	private final UIAccessLayer uiAccessLayer;

	public Controller(@NotNull DataAccessLayer dataAccessLayer, @NotNull UIAccessLayer uiAccessLayer) {
		this.dataAccessLayer = dataAccessLayer;
		this.uiAccessLayer = uiAccessLayer;
		uiAccessLayer.setController(this);
	}

	public void start() {
		uiAccessLayer.start();
		dataAccessLayer.load();
		uiAccessLayer.update(dataAccessLayer.getElements());
	}

	@Override
	public void actionPerformed(@NotNull ActionEvent e) {
		switch (e.getActionCommand()) {
			case String event when event.equals(Actions.ADD) -> {
				Element element = uiAccessLayer.askForElement(null);
				if (element == null) {
					break;
				}
				BasicElement newElement = switch (element.type) {
					case String type when type.equals(Bonus.class.getSimpleName()) -> new Bonus.Builder().name(element.name).identifier(element.identifier).textureLocation(element.textureLocation).timestamp(element.timestamp).value(element.value).build();
					case String type when type.equals(Component.class.getSimpleName()) -> new Component.Builder().name(element.name).identifier(element.identifier).textureLocation(element.textureLocation).timestamp(element.timestamp).rarity(element.rarity).build();
					case String type when type.equals(Item.class.getSimpleName()) -> new Item.Builder().name(element.name).identifier(element.identifier).textureLocation(element.textureLocation).timestamp(element.timestamp).rarity(element.rarity).stats(new Stats.Builder().health(element.health).defense(element.defense).strength(element.strength).intelligence(element.intelligence).critChance(element.critChance).critDamage(element.critDamage).build()).reforge(element.reforge).build();
					case String type when type.equals(Pet.class.getSimpleName()) -> new Pet.Builder().name(element.name).identifier(element.identifier).textureLocation(element.textureLocation).timestamp(element.timestamp).rarity(element.rarity).stats(new Stats.Builder().health(element.health).defense(element.defense).strength(element.strength).intelligence(element.intelligence).critChance(element.critChance).critDamage(element.critDamage).build()).petItem(new Item.Builder().name(element.petItemName).identifier(element.petItemIdentifier).textureLocation(element.petItemTextureLocation).timestamp(element.petItemTimestamp).rarity(element.petItemRarity).stats(new Stats.Builder().health(element.petItemHealth).defense(element.petItemDefense).strength(element.petItemStrength).intelligence(element.petItemIntelligence).critChance(element.petItemCritChance).critDamage(element.petItemCritDamage).build()).reforge(element.petItemReforge).build()).build();
					default -> throw new IllegalStateException("Unexpected value: " + element.type);
				};
				if (newElement == null) {
					break;
				}
				dataAccessLayer.add(newElement);
				uiAccessLayer.update(dataAccessLayer.getElements());
			}
			case String event when event.equals(Actions.UPDATE) -> {
				int id = uiAccessLayer.getSelectedInternalId();
				if (id < 0 || id >= dataAccessLayer.getInternalId()) {
					break;
				}
				Element oldElement;
				BasicElement oldBasicElement = dataAccessLayer.get(id);
				switch (oldBasicElement) {
					case Pet pet -> oldElement = new Element(Pet.class.getSimpleName(), pet.getName(), pet.getIdentifier(), pet.getTextureLocation(), pet.getTimestamp(), 0, pet.getRarity(), pet.getStats().getHealth(), pet.getStats().getDefense(), pet.getStats().getStrength(), pet.getStats().getIntelligence(), pet.getStats().getCritChance(), pet.getStats().getCritDamage(), null, pet.getPetItem().getName(), pet.getPetItem().getIdentifier(), pet.getPetItem().getTextureLocation(), pet.getPetItem().getTimestamp(), pet.getPetItem().getRarity(), pet.getPetItem().getStats().getHealth(), pet.getPetItem().getStats().getDefense(), pet.getPetItem().getStats().getStrength(), pet.getPetItem().getStats().getIntelligence(), pet.getPetItem().getStats().getCritChance(), pet.getPetItem().getStats().getCritDamage(), pet.getPetItem().getReforge());
					case Item item -> oldElement = new Element(Item.class.getSimpleName(), item.getName(), item.getIdentifier(), item.getTextureLocation(), item.getTimestamp(), 0, item.getRarity(), item.getStats().getHealth(), item.getStats().getDefense(), item.getStats().getStrength(), item.getStats().getIntelligence(), item.getStats().getCritChance(), item.getStats().getCritDamage(), item.getReforge(), null, null, null, null, null, 0, 0, 0, 0, 0, 0, null);
					case Component component -> oldElement = new Element(Component.class.getSimpleName(), component.getName(), component.getIdentifier(), component.getTextureLocation(), component.getTimestamp(), 0, component.getRarity(), 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, null);
					case Bonus bonus -> oldElement = new Element(Bonus.class.getSimpleName(), bonus.getName(), bonus.getIdentifier(), bonus.getTextureLocation(), bonus.getTimestamp(), bonus.getValue(), null, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, null);
					default -> throw new IllegalStateException("Unexpected value: " + oldBasicElement.getClass());
				}
				Element element = uiAccessLayer.askForElement(oldElement);
				if (element == null) {
					break;
				}
				BasicElement newElement = switch (element.type) {
					case String type when type.equals(Bonus.class.getSimpleName()) -> new Bonus.Builder().name(element.name).identifier(element.identifier).textureLocation(element.textureLocation).timestamp(element.timestamp).value(element.value).build();
					case String type when type.equals(Component.class.getSimpleName()) -> new Component.Builder().name(element.name).identifier(element.identifier).textureLocation(element.textureLocation).timestamp(element.timestamp).rarity(element.rarity).build();
					case String type when type.equals(Item.class.getSimpleName()) -> new Item.Builder().name(element.name).identifier(element.identifier).textureLocation(element.textureLocation).timestamp(element.timestamp).rarity(element.rarity).stats(new Stats.Builder().health(element.health).defense(element.defense).strength(element.strength).intelligence(element.intelligence).critChance(element.critChance).critDamage(element.critDamage).build()).reforge(element.reforge).build();
					case String type when type.equals(Pet.class.getSimpleName()) -> new Pet.Builder().name(element.name).identifier(element.identifier).textureLocation(element.textureLocation).timestamp(element.timestamp).rarity(element.rarity).stats(new Stats.Builder().health(element.health).defense(element.defense).strength(element.strength).intelligence(element.intelligence).critChance(element.critChance).critDamage(element.critDamage).build()).petItem(new Item.Builder().name(element.petItemName).identifier(element.petItemIdentifier).textureLocation(element.petItemTextureLocation).timestamp(element.petItemTimestamp).rarity(element.petItemRarity).stats(new Stats.Builder().health(element.petItemHealth).defense(element.petItemDefense).strength(element.petItemStrength).intelligence(element.petItemIntelligence).critChance(element.petItemCritChance).critDamage(element.petItemCritDamage).build()).reforge(element.petItemReforge).build()).build();
					default -> null;
				};
				if (newElement == null) {
					break;
				}
				newElement.setInternalId(id);
				dataAccessLayer.set(id, newElement);
				uiAccessLayer.update(dataAccessLayer.getElements());
			}
			case String event when event.equals(Actions.DELETE) -> {
				int id = uiAccessLayer.getSelectedInternalId();
				if (id < 0 || id >= dataAccessLayer.getInternalId()) {
					break;
				}
				dataAccessLayer.remove(id);
				uiAccessLayer.update(dataAccessLayer.getElements());
			}
			case String event when event.equals(Actions.DETAILS) -> {
				int id = uiAccessLayer.getSelectedInternalId();
				ArrayList<DetailTuple> details = new ArrayList<>();
				if (id >= 0 && id < dataAccessLayer.getInternalId()) {
					BasicElement element = dataAccessLayer.get(id);
					details.addAll(List.of(new DetailTuple("Internal ID", element.getInternalId()), new DetailTuple("Type", element.getClass().getSimpleName()), new DetailTuple("Name", element.getName()), new DetailTuple("Identifier", element.getIdentifier()), new DetailTuple("Texture Location", element.getTextureLocation()), new DetailTuple("Icon", element.getIcon()), new DetailTuple("Timestamp", element.getTimestamp())));
					switch (element) {
						case Bonus bonus -> details.add(new DetailTuple("Value", bonus.getValue()));
						case Component component -> {
							details.add(new DetailTuple("Rarity", component.getRarity()));
							switch (component) {
								case Item item -> details.addAll(List.of(new DetailTuple("Health", item.getStats().getHealth()), new DetailTuple("Defense", item.getStats().getDefense()), new DetailTuple("Strength", item.getStats().getStrength()), new DetailTuple("Intelligence", item.getStats().getIntelligence()), new DetailTuple("Crit Chance", item.getStats().getCritChance()), new DetailTuple("Crit Damage", item.getStats().getCritDamage()), new DetailTuple("Reforge", item.getReforge())));
								case Pet pet -> details.addAll(List.of(new DetailTuple("Health", pet.getStats().getHealth()), new DetailTuple("Defense", pet.getStats().getDefense()), new DetailTuple("Strength", pet.getStats().getStrength()), new DetailTuple("Intelligence", pet.getStats().getIntelligence()), new DetailTuple("Crit Chance", pet.getStats().getCritChance()), new DetailTuple("Crit Damage", pet.getStats().getCritDamage()), new DetailTuple("Pet Item Name", pet.getPetItem().getName()), new DetailTuple("Pet Item Identifier", pet.getPetItem().getIdentifier()), new DetailTuple("Pet Item Texture Location", pet.getPetItem().getTextureLocation()), new DetailTuple("Pet Item Icon", pet.getPetItem().getIcon()), new DetailTuple("Pet Item Timestamp", pet.getPetItem().getTimestamp()), new DetailTuple("Pet Item Rarity", pet.getPetItem().getRarity()), new DetailTuple("Pet Item Health", pet.getPetItem().getStats().getHealth()), new DetailTuple("Pet Item Defense", pet.getPetItem().getStats().getDefense()), new DetailTuple("Pet Item Strength", pet.getPetItem().getStats().getStrength()), new DetailTuple("Pet Item Intelligence", pet.getPetItem().getStats().getIntelligence()), new DetailTuple("Pet Item Crit Chance", pet.getPetItem().getStats().getCritChance()), new DetailTuple("Pet Item Crit Damage", pet.getPetItem().getStats().getCritDamage()), new DetailTuple("Pet Item Reforge", pet.getPetItem().getReforge())));
								default -> {
								}
							}
						}
						default -> throw new IllegalStateException("Unexpected value: " + element.getClass());
					}
				}
				uiAccessLayer.detail(details);
			}
			case String event when event.equals(Actions.SAVE) -> dataAccessLayer.save();
			case String event when event.equals(Actions.LOAD) -> {
				dataAccessLayer.load();
				uiAccessLayer.update(dataAccessLayer.getElements());
			}
			case String event when event.equals(Actions.EXPORT) -> dataAccessLayer.exportFile(uiAccessLayer.askForFile());
			case String event when event.equals(Actions.IMPORT) -> {}
			default -> throw new IllegalStateException("Unexpected value: " + e);
		}
	}
}
