package me.julienraptor01.gui.menuItem;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Update extends JMenuItem {
	private static final String name = "Update";
	private static final JLabel[] labels = {
			new JLabel("There is no updates planned for now."),
			new JLabel("Please check back later tho !")
	};

	public Update() {
		super(name);
		this.addActionListener(click -> onClick());
	}

	private void onClick() {
		JOptionPane.showMessageDialog(null, labels, name, JOptionPane.INFORMATION_MESSAGE);
	}
}
