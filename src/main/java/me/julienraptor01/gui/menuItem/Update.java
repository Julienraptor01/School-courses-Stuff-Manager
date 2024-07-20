package me.julienraptor01.gui.menuItem;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Update extends JMenuItem {
	private static final String NAME = "Update";
	private static final JLabel[] LABELS = {
			new JLabel("There is no updates planned for now."),
			new JLabel("Please check back later tho !")
	};

	public Update() {
		super(NAME);
		this.addActionListener(click -> onClick());
	}

	private void onClick() {
		JOptionPane.showMessageDialog(null, LABELS, NAME, JOptionPane.INFORMATION_MESSAGE);
	}
}
