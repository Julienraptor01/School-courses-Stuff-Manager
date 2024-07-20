package me.julienraptor01.gui.menuItem;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class About extends JMenuItem {
	private static final String NAME = "About";
	private static final JLabel[] LABELS = new JLabel[]{
			new JLabel("Program Name"),
			new JLabel("0.0.0-DEV"),
			new JLabel("Julienraptor01")
	};

	public About() {
		super(NAME);
		this.addActionListener(click -> onClick());
	}

	private void onClick() {
		JOptionPane.showMessageDialog(null, LABELS, NAME, JOptionPane.INFORMATION_MESSAGE);
	}
}
