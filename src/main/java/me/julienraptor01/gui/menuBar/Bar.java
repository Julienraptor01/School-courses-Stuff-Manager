package me.julienraptor01.gui.menuBar;

import me.julienraptor01.gui.menu.Config;
import me.julienraptor01.gui.menu.Help;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Bar extends JMenuBar {
	private static final JMenu[] MENUS = new JMenu[]{
			new Config(),
			new Help()
	};

	public Bar() {
		super();
		for (JMenu menu : MENUS) {
			this.add(menu);
		}
	}
}
