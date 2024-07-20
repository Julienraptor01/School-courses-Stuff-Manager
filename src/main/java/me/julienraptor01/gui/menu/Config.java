package me.julienraptor01.gui.menu;

import me.julienraptor01.gui.menuItem.Settings;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Config extends JMenu {
	private static final String NAME = "Config";
	private static final JMenuItem[] ITEMS = new JMenuItem[]{
			new Settings()
	};

	public Config() {
		super(NAME);
		for (JMenuItem item : ITEMS) {
			this.add(item);
		}
	}
}
