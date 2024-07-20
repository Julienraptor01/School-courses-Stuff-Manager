package me.julienraptor01.gui.menuItem;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Settings extends JMenuItem {
	private static final String NAME = "Settings";

	public Settings() {
		super(NAME);
		this.addActionListener(click -> onClick());
	}

	private void onClick() {
		JOptionPane.showOptionDialog(null, new JLabel[]{
				new JLabel("Settings are not available for now."),
				new JLabel("Please check back later.")
		}, NAME, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
	}
}
