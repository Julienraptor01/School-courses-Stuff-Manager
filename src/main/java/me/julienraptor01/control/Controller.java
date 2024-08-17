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
import me.julienraptor01.data.template.Rarity;
import me.julienraptor01.data.template.Stats;
import me.julienraptor01.ui.UIAccessLayer;

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
		dataAccessLayer.add(new Bonus.Builder().name("Bonus").build());
		dataAccessLayer.add(new Component.Builder().name("Component").build());
		dataAccessLayer.add(new Item.Builder().name("Item").build());
		dataAccessLayer.add(new Pet.Builder().name("Pet").build());
		dataAccessLayer.add(new Pet.Builder().name("Pet 2").identifier("PET_2").rarity(Rarity.ADMIN).stats(new Stats.Builder().critChance(69).critDamage(42).health(13).defense(7).strength(1000).intelligence(-50).build()).petItem(new Item.Builder().name("Pet Item").reforge("Wise").build()).build());
		dataAccessLayer.save();
		dataAccessLayer.load();
		uiAccessLayer.update(dataAccessLayer.getElements());
	}

	@Override
	public void actionPerformed(@NotNull ActionEvent e) {
		switch (e.getActionCommand()) {
			case String event when event.equals(Actions.ADD) -> {
				BasicElement element = uiAccessLayer.askForElement();
				if (element == null) {
					break;
				}
				dataAccessLayer.add(element);
				uiAccessLayer.update(dataAccessLayer.getElements());
			}
			case String event when event.equals(Actions.UPDATE) -> {
				int id = uiAccessLayer.getSelectedInternalId();
				if (id < 0 || id >= dataAccessLayer.getInternalId()) {
					break;
				}
				BasicElement element = uiAccessLayer.askForElement();
				if (element == null) {
					break;
				}
				dataAccessLayer.set(id, element);
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
				ArrayList<UIAccessLayer.detailTuple> details = new ArrayList<>();
				if (id >= 0 && id < dataAccessLayer.getInternalId()) {
					BasicElement element = dataAccessLayer.get(id);
					details.addAll(List.of(
							new UIAccessLayer.detailTuple("Internal ID", element.getInternalId()),
							new UIAccessLayer.detailTuple("Type", element.getClass().getSimpleName()),
							new UIAccessLayer.detailTuple("Name", element.getName()),
							new UIAccessLayer.detailTuple("Identifier", element.getIdentifier()),
							new UIAccessLayer.detailTuple("Texture Location", element.getTextureLocation()),
							new UIAccessLayer.detailTuple("Icon", element.getIcon()),
							new UIAccessLayer.detailTuple("Timestamp", element.getTimestamp())
					));
					switch (element) {
						case Bonus bonus -> details.add(new UIAccessLayer.detailTuple("Value", bonus.getValue()));
						case Component component -> {
							details.add(new UIAccessLayer.detailTuple("Rarity", component.getRarity()));
							switch (component) {
								case Item item -> details.addAll(List.of(
										new UIAccessLayer.detailTuple("Health", item.getStats().getHealth()),
										new UIAccessLayer.detailTuple("Defense", item.getStats().getDefense()),
										new UIAccessLayer.detailTuple("Strength", item.getStats().getStrength()),
										new UIAccessLayer.detailTuple("Intelligence", item.getStats().getIntelligence()),
										new UIAccessLayer.detailTuple("Crit Chance", item.getStats().getCritChance()),
										new UIAccessLayer.detailTuple("Crit Damage", item.getStats().getCritDamage()),
										new UIAccessLayer.detailTuple("Reforge", item.getReforge())
								));
								case Pet pet -> details.addAll(List.of(
										new UIAccessLayer.detailTuple("Health", pet.getStats().getHealth()),
										new UIAccessLayer.detailTuple("Defense", pet.getStats().getDefense()),
										new UIAccessLayer.detailTuple("Strength", pet.getStats().getStrength()),
										new UIAccessLayer.detailTuple("Intelligence", pet.getStats().getIntelligence()),
										new UIAccessLayer.detailTuple("Crit Chance", pet.getStats().getCritChance()),
										new UIAccessLayer.detailTuple("Crit Damage", pet.getStats().getCritDamage()),
										new UIAccessLayer.detailTuple("Pet Item Name", pet.getPetItem().getName()),
										new UIAccessLayer.detailTuple("Pet Item Identifier", pet.getPetItem().getIdentifier()),
										new UIAccessLayer.detailTuple("Pet Item Texture Location", pet.getPetItem().getTextureLocation()),
										new UIAccessLayer.detailTuple("Pet Item Icon", pet.getPetItem().getIcon()),
										new UIAccessLayer.detailTuple("Pet Item Timestamp", pet.getPetItem().getTimestamp()),
										new UIAccessLayer.detailTuple("Pet Item Rarity", pet.getPetItem().getRarity()),
										new UIAccessLayer.detailTuple("Pet Item Health", pet.getPetItem().getStats().getHealth()),
										new UIAccessLayer.detailTuple("Pet Item Defense", pet.getPetItem().getStats().getDefense()),
										new UIAccessLayer.detailTuple("Pet Item Strength", pet.getPetItem().getStats().getStrength()),
										new UIAccessLayer.detailTuple("Pet Item Intelligence", pet.getPetItem().getStats().getIntelligence()),
										new UIAccessLayer.detailTuple("Pet Item Crit Chance", pet.getPetItem().getStats().getCritChance()),
										new UIAccessLayer.detailTuple("Pet Item Crit Damage", pet.getPetItem().getStats().getCritDamage()),
										new UIAccessLayer.detailTuple("Pet Item Reforge", pet.getPetItem().getReforge())
								));
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
			default -> throw new IllegalStateException("Unexpected value: " + e);
		}
	}
}
