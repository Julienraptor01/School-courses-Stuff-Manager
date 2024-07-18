package me.julienraptor01.gui.menuItem;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Settings extends JMenuItem {
	private static final String name = "Settings";

	public Settings() {
		super(name);
		this.addActionListener(click -> onClick());
	}

	private void onClick() {
		JOptionPane.showOptionDialog(null, new JLabel[]{
				new JLabel("Settings are not available for now."),
				new JLabel("Please check back later.")
		}, name, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
	}
}
