package me.julienraptor01.gui.menuBar;

import me.julienraptor01.gui.menu.Help;
import me.julienraptor01.gui.menu.Config;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Bar extends JMenuBar {
	private static final JMenu[] menus = new JMenu[]{
			new Config(),
			new Help()
	};

	public Bar() {
		for (JMenu menu : menus) {
			this.add(menu);
		}
	}
}
