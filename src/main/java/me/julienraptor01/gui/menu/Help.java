package me.julienraptor01.gui.menu;

import me.julienraptor01.gui.menuItem.About;
import me.julienraptor01.gui.menuItem.Update;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Help extends JMenu {
	private static final String NAME = "Help";
	private static final JMenuItem[] ITEMS = new JMenuItem[]{
			new Update(),
			new About()
	};

	public Help() {
		super(NAME);
		for (JMenuItem item : ITEMS) {
			this.add(item);
		}
	}
}
