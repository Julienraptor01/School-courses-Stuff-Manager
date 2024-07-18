package me.julienraptor01.gui.menu;

import me.julienraptor01.gui.menuItem.Settings;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Config extends JMenu {
	private static final JMenuItem[] items = new JMenuItem[]{
			new Settings()
	};

	public Config() {
		super("Config");
		for (JMenuItem item : items) {
			this.add(item);
		}
	}
}
