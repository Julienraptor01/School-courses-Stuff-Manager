package me.julienraptor01.ui;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.swing.*;

import me.julienraptor01.data.complex.Bonus;
import me.julienraptor01.data.complex.Component;
import me.julienraptor01.data.complex.Item;
import me.julienraptor01.data.complex.Pet;
import me.julienraptor01.data.template.Rarity;
import me.julienraptor01.ui.idk.Element;

public class ElementDialog extends JDialog {
	private static final String NAME = "Element Dialog";

	public ElementDialog(JFrame parent, Element element) {
		super(parent, NAME, true);
		ElementPanel elementPanel = new ElementPanel(element);
		this.setContentPane(elementPanel);
		this.pack();
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

	public Element askForElement() {
		return ElementPanel.isReady ? ElementPanel.element : null;
	}

	private static class ElementPanel extends JPanel {
		private static final String[] TYPES = Stream.of(Bonus.class, Component.class, Item.class, Pet.class).map(Class::getSimpleName).toArray(String[]::new);
		private static final Rarity[] RARITIES = Rarity.values();
		private static final String[] LABELS_TEXT = new String[]{"Type:", "Name:", "Identifier:", "Texture Location:", "Timestamp:", "Value:", "Rarity:", "Health:", "Defense:", "Strength:", "Intelligence:", "Crit Chance:", "Crit Damage:", "Reforge:", "Pet Item Name:", "Pet Item Identifier:", "Pet Item Texture Location:", "Pet Item Timestamp:", "Pet Item Rarity:", "Pet Item Health:", "Pet Item Defense:", "Pet Item Strength:", "Pet Item Intelligence:", "Pet Item Crit Chance:", "Pet Item Crit Damage:", "Pet Item Reforge:"};
		private static final String RESET_TEXT = "Reset";
		private static final JLabel[] LABELS = Stream.of(LABELS_TEXT).map(JLabel::new).toArray(JLabel[]::new);
		private static final JButton OK = new JButton("OK") {{
			addActionListener(event -> {
				isReady = true;
				((JDialog) getParent().getParent().getParent().getParent()).dispose();
			});
		}};
		private static boolean isReady = false;
		private static Element element = null;
		private static final JComboBox<String> TYPE = new JComboBox<>(TYPES) {{
			addItemListener(event -> {
				if (event.getStateChange() != ItemEvent.SELECTED) {
					return;
				}
				int index = getSelectedIndex();
				if (index == -1) {
					return;
				}
				element.type = TYPES[index];
			});
		}};
		private static final JButton RESET_TYPE = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetType(element);
				TYPE.setSelectedIndex(List.of(TYPES).indexOf(element.type));
			});
		}};
		private static final JTextField NAME = new JTextField() {{
			addActionListener(event -> element.name = getText());
		}};
		private static final JButton RESET_NAME = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetName(element);
				NAME.setText(element.name);
			});
		}};
		private static final JTextField IDENTIFIER = new JTextField() {{
			addActionListener(event -> element.identifier = getText());
		}};
		private static final JButton RESET_IDENTIFIER = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetIdentifier(element);
				IDENTIFIER.setText(element.identifier);
			});
		}};
		private static final JTextField TEXTURE_LOCATION = new JTextField() {{
			addActionListener(event -> element.textureLocation = getText());
		}};
		private static final JButton RESET_TEXTURE_LOCATION = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetTextureLocation(element);
				TEXTURE_LOCATION.setText(element.textureLocation);
			});
		}};
		private static final JSpinner TIMESTAMP = new JSpinner() {{
			addChangeListener(event -> {
				Object value = getValue();
				element.timestamp = switch (value) {
					case Integer integer -> (long) integer;
					case Long longValue -> longValue;
					default -> throw new IllegalStateException("Unexpected value: " + value);
				};
			});
		}};
		private static final JButton RESET_TIMESTAMP = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetTimestamp(element);
				TIMESTAMP.setValue(element.timestamp);
			});
		}};
		private static final JSpinner VALUE = new JSpinner() {{
			addChangeListener(event -> {
				Object value = getValue();
				element.value = switch (value) {
					case Integer integer -> (double) integer;
					case Double doubleValue -> doubleValue;
					default -> throw new IllegalStateException("Unexpected value: " + value);
				};
			});
		}};
		private static final JButton RESET_VALUE = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetValue(element);
				VALUE.setValue(element.value);
			});
		}};
		private static final JComboBox<Rarity> RARITY = new JComboBox<>(RARITIES) {{
			addItemListener(event -> {
				if (event.getStateChange() != ItemEvent.SELECTED) {
					return;
				}
				element.rarity = RARITIES[getSelectedIndex()];
			});
		}};
		private static final JButton RESET_RARITY = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetRarity(element);
				RARITY.setSelectedIndex(List.of(RARITIES).indexOf(element.rarity));
			});
		}};
		private static final JSpinner HEALTH = new JSpinner() {{
			addChangeListener(event -> element.health = (int) getValue());
		}};
		private static final JButton RESET_HEALTH = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetHealth(element);
				HEALTH.setValue(element.health);
			});
		}};
		private static final JSpinner DEFENSE = new JSpinner() {{
			addChangeListener(event -> element.defense = (int) getValue());
		}};
		private static final JButton RESET_DEFENSE = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetDefense(element);
				DEFENSE.setValue(element.defense);
			});
		}};
		private static final JSpinner STRENGTH = new JSpinner() {{
			addChangeListener(event -> element.strength = (int) getValue());
		}};
		private static final JButton RESET_STRENGTH = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetStrength(element);
				STRENGTH.setValue(element.strength);
			});
		}};
		private static final JSpinner INTELLIGENCE = new JSpinner() {{
			addChangeListener(event -> element.intelligence = (int) getValue());
		}};
		private static final JButton RESET_INTELLIGENCE = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetIntelligence(element);
				INTELLIGENCE.setValue(element.intelligence);
			});
		}};
		private static final JSpinner CRIT_CHANCE = new JSpinner() {{
			addChangeListener(event -> element.critChance = (int) getValue());
		}};
		private static final JButton RESET_CRIT_CHANCE = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetCritChance(element);
				CRIT_CHANCE.setValue(element.critChance);
			});
		}};
		private static final JSpinner CRIT_DAMAGE = new JSpinner() {{
			addChangeListener(event -> element.critDamage = (int) getValue());
		}};
		private static final JButton RESET_CRIT_DAMAGE = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetCritDamage(element);
				CRIT_DAMAGE.setValue(element.critDamage);
			});
		}};
		private static final JTextField REFORGE = new JTextField() {{
			addActionListener(event -> element.reforge = getText());
		}};
		private static final JButton RESET_REFORGE = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetReforge(element);
				REFORGE.setText(element.reforge);
			});
		}};
		private static final JTextField PET_ITEM_NAME = new JTextField() {{
			addActionListener(event -> element.petItemName = getText());
		}};
		private static final JButton RESET_PET_ITEM_NAME = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetPetItemName(element);
				PET_ITEM_NAME.setText(element.petItemName);
			});
		}};
		private static final JTextField PET_ITEM_IDENTIFIER = new JTextField() {{
			addActionListener(event -> element.petItemIdentifier = getText());
		}};
		private static final JButton RESET_PET_ITEM_IDENTIFIER = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetPetItemIdentifier(element);
				PET_ITEM_IDENTIFIER.setText(element.petItemIdentifier);
			});
		}};
		private static final JTextField PET_ITEM_TEXTURE_LOCATION = new JTextField() {{
			addActionListener(event -> element.petItemTextureLocation = getText());
		}};
		private static final JButton RESET_PET_ITEM_TEXTURE_LOCATION = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetPetItemTextureLocation(element);
				PET_ITEM_TEXTURE_LOCATION.setText(element.petItemTextureLocation);
			});
		}};
		private static final JSpinner PET_ITEM_TIMESTAMP = new JSpinner() {{
			addChangeListener(event -> {
				Object value = getValue();
				element.petItemTimestamp = switch (value) {
					case Integer integer -> (long) integer;
					case Long longValue -> longValue;
					default -> throw new IllegalStateException("Unexpected value: " + value);
				};
			});
		}};
		private static final JButton RESET_PET_ITEM_TIMESTAMP = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetPetItemTimestamp(element);
				PET_ITEM_TIMESTAMP.setValue(element.petItemTimestamp);
			});
		}};
		private static final JComboBox<Rarity> PET_ITEM_RARITY = new JComboBox<>(RARITIES) {{
			addItemListener(event -> {
				if (event.getStateChange() != ItemEvent.SELECTED) {
					return;
				}
				element.petItemRarity = RARITIES[getSelectedIndex()];
			});
		}};
		private static final JButton RESET_PET_ITEM_RARITY = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetPetItemRarity(element);
				PET_ITEM_RARITY.setSelectedIndex(List.of(RARITIES).indexOf(element.petItemRarity));
			});
		}};
		private static final JSpinner PET_ITEM_HEALTH = new JSpinner() {{
			addChangeListener(event -> element.petItemHealth = (int) getValue());
		}};
		private static final JButton RESET_PET_ITEM_HEALTH = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetPetItemHealth(element);
				PET_ITEM_HEALTH.setValue(element.petItemHealth);
			});
		}};
		private static final JSpinner PET_ITEM_DEFENSE = new JSpinner() {{
			addChangeListener(event -> element.petItemDefense = (int) getValue());
		}};
		private static final JButton RESET_PET_ITEM_DEFENSE = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetPetItemDefense(element);
				PET_ITEM_DEFENSE.setValue(element.petItemDefense);
			});
		}};
		private static final JSpinner PET_ITEM_STRENGTH = new JSpinner() {{
			addChangeListener(event -> element.petItemStrength = (int) getValue());
		}};
		private static final JButton RESET_PET_ITEM_STRENGTH = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetPetItemStrength(element);
				PET_ITEM_STRENGTH.setValue(element.petItemStrength);
			});
		}};
		private static final JSpinner PET_ITEM_INTELLIGENCE = new JSpinner() {{
			addChangeListener(event -> element.petItemIntelligence = (int) getValue());
		}};
		private static final JButton RESET_PET_ITEM_INTELLIGENCE = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetPetItemIntelligence(element);
				PET_ITEM_INTELLIGENCE.setValue(element.petItemIntelligence);
			});
		}};
		private static final JSpinner PET_ITEM_CRIT_CHANCE = new JSpinner() {{
			addChangeListener(event -> element.petItemCritChance = (int) getValue());
		}};
		private static final JButton RESET_PET_ITEM_CRIT_CHANCE = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetPetItemCritChance(element);
				PET_ITEM_CRIT_CHANCE.setValue(element.petItemCritChance);
			});
		}};
		private static final JSpinner PET_ITEM_CRIT_DAMAGE = new JSpinner() {{
			addChangeListener(event -> element.petItemCritDamage = (int) getValue());
		}};
		private static final JButton RESET_PET_ITEM_CRIT_DAMAGE = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetPetItemCritDamage(element);
				PET_ITEM_CRIT_DAMAGE.setValue(element.petItemCritDamage);
			});
		}};
		private static final JTextField PET_ITEM_REFORGE = new JTextField() {{
			addActionListener(event -> element.petItemReforge = getText());
		}};
		private static final JComponent[] COMPONENTS = new JComponent[]{TYPE, NAME, IDENTIFIER, TEXTURE_LOCATION, TIMESTAMP, VALUE, RARITY, HEALTH, DEFENSE, STRENGTH, INTELLIGENCE, CRIT_CHANCE, CRIT_DAMAGE, REFORGE, PET_ITEM_NAME, PET_ITEM_IDENTIFIER, PET_ITEM_TEXTURE_LOCATION, PET_ITEM_TIMESTAMP, PET_ITEM_RARITY, PET_ITEM_HEALTH, PET_ITEM_DEFENSE, PET_ITEM_STRENGTH, PET_ITEM_INTELLIGENCE, PET_ITEM_CRIT_CHANCE, PET_ITEM_CRIT_DAMAGE, PET_ITEM_REFORGE};
		private static final JButton RESET_PET_ITEM_REFORGE = new JButton(RESET_TEXT) {{
			addActionListener(event -> {
				Element.resetPetItemReforge(element);
				PET_ITEM_REFORGE.setText(element.petItemReforge);
			});
		}};
		private static final JButton[] RESETS = new JButton[]{RESET_TYPE, RESET_NAME, RESET_IDENTIFIER, RESET_TEXTURE_LOCATION, RESET_TIMESTAMP, RESET_VALUE, RESET_RARITY, RESET_HEALTH, RESET_DEFENSE, RESET_STRENGTH, RESET_INTELLIGENCE, RESET_CRIT_CHANCE, RESET_CRIT_DAMAGE, RESET_REFORGE, RESET_PET_ITEM_NAME, RESET_PET_ITEM_IDENTIFIER, RESET_PET_ITEM_TEXTURE_LOCATION, RESET_PET_ITEM_TIMESTAMP, RESET_PET_ITEM_RARITY, RESET_PET_ITEM_HEALTH, RESET_PET_ITEM_DEFENSE, RESET_PET_ITEM_STRENGTH, RESET_PET_ITEM_INTELLIGENCE, RESET_PET_ITEM_CRIT_CHANCE, RESET_PET_ITEM_CRIT_DAMAGE, RESET_PET_ITEM_REFORGE};
		private static final JButton RESET_ALL = new JButton("Reset All") {{
			addActionListener(event -> {
				element = new Element();
				TYPE.setSelectedIndex(List.of(TYPES).indexOf(element.type));
				NAME.setText(element.name);
				IDENTIFIER.setText(element.identifier);
				TEXTURE_LOCATION.setText(element.textureLocation);
				TIMESTAMP.setValue(element.timestamp);
				VALUE.setValue(element.value);
				RARITY.setSelectedIndex(List.of(RARITIES).indexOf(element.rarity));
				HEALTH.setValue(element.health);
				DEFENSE.setValue(element.defense);
				STRENGTH.setValue(element.strength);
				INTELLIGENCE.setValue(element.intelligence);
				CRIT_CHANCE.setValue(element.critChance);
				CRIT_DAMAGE.setValue(element.critDamage);
				REFORGE.setText(element.reforge);
				PET_ITEM_NAME.setText(element.petItemName);
				PET_ITEM_IDENTIFIER.setText(element.petItemIdentifier);
				PET_ITEM_TEXTURE_LOCATION.setText(element.petItemTextureLocation);
				PET_ITEM_TIMESTAMP.setValue(element.petItemTimestamp);
				PET_ITEM_RARITY.setSelectedIndex(List.of(RARITIES).indexOf(element.petItemRarity));
				PET_ITEM_HEALTH.setValue(element.petItemHealth);
				PET_ITEM_DEFENSE.setValue(element.petItemDefense);
				PET_ITEM_STRENGTH.setValue(element.petItemStrength);
				PET_ITEM_INTELLIGENCE.setValue(element.petItemIntelligence);
				PET_ITEM_CRIT_CHANCE.setValue(element.petItemCritChance);
				PET_ITEM_CRIT_DAMAGE.setValue(element.petItemCritDamage);
				PET_ITEM_REFORGE.setText(element.petItemReforge);
			});
		}};
		private static final JButton CANCEL = new JButton("Cancel") {{
			addActionListener(event -> {
				isReady = false;
				element = null;
				((JDialog) getParent().getParent().getParent().getParent()).dispose();
			});
		}};
		private static final JButton[] TRAILING_BUTTONS = new JButton[]{CANCEL, OK, RESET_ALL};

		public ElementPanel(Element element) {
			super(new GridLayout(27, 3));
			ElementPanel.element = element != null ? element : new Element();
			List<String> types = List.of(TYPES);
			if (types.contains(ElementPanel.element.type)) {
				TYPE.setSelectedIndex(types.indexOf(ElementPanel.element.type));
			}
			NAME.setText(ElementPanel.element.name);
			IDENTIFIER.setText(ElementPanel.element.identifier);
			TEXTURE_LOCATION.setText(ElementPanel.element.textureLocation);
			TIMESTAMP.setValue(ElementPanel.element.timestamp);
			VALUE.setValue(ElementPanel.element.value);
			List<Rarity> rarities = List.of(RARITIES);
			if (ElementPanel.element.rarity != null && rarities.contains(ElementPanel.element.rarity)) {
				RARITY.setSelectedIndex(rarities.indexOf(ElementPanel.element.rarity));
			}
			HEALTH.setValue(ElementPanel.element.health);
			DEFENSE.setValue(ElementPanel.element.defense);
			STRENGTH.setValue(ElementPanel.element.strength);
			INTELLIGENCE.setValue(ElementPanel.element.intelligence);
			CRIT_CHANCE.setValue(ElementPanel.element.critChance);
			CRIT_DAMAGE.setValue(ElementPanel.element.critDamage);
			REFORGE.setText(ElementPanel.element.reforge);
			PET_ITEM_NAME.setText(ElementPanel.element.petItemName);
			PET_ITEM_IDENTIFIER.setText(ElementPanel.element.petItemIdentifier);
			PET_ITEM_TEXTURE_LOCATION.setText(ElementPanel.element.petItemTextureLocation);
			if (ElementPanel.element.petItemTimestamp != null) {
				PET_ITEM_TIMESTAMP.setValue(ElementPanel.element.petItemTimestamp);
			}
			if (ElementPanel.element.petItemRarity != null && rarities.contains(ElementPanel.element.petItemRarity)) {
				PET_ITEM_RARITY.setSelectedIndex(rarities.indexOf(ElementPanel.element.petItemRarity));
			}
			PET_ITEM_HEALTH.setValue(ElementPanel.element.petItemHealth);
			PET_ITEM_DEFENSE.setValue(ElementPanel.element.petItemDefense);
			PET_ITEM_STRENGTH.setValue(ElementPanel.element.petItemStrength);
			PET_ITEM_INTELLIGENCE.setValue(ElementPanel.element.petItemIntelligence);
			PET_ITEM_CRIT_CHANCE.setValue(ElementPanel.element.petItemCritChance);
			PET_ITEM_CRIT_DAMAGE.setValue(ElementPanel.element.petItemCritDamage);
			PET_ITEM_REFORGE.setText(ElementPanel.element.petItemReforge);
			IntStream.range(0, LABELS.length).forEach(i -> {
				add(LABELS[i]);
				add(COMPONENTS[i]);
				add(RESETS[i]);
			});
			Stream.of(TRAILING_BUTTONS).forEach(this::add);
		}
	}
}
