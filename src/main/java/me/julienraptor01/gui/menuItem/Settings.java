package me.julienraptor01.gui.menuItem;

import javax.swing.*;
import java.awt.GridLayout;

public class Settings extends JMenuItem {
	private static final String NAME = "Settings";

	public Settings() {
		super(NAME);
		this.addActionListener(click -> onClick());
	}

	private void onClick() {
		JOptionPane.showOptionDialog(null, new JPanel() {
			{
				this.setLayout(new GridLayout(2, 3));
				this.add(new JLabel("Start Maximized:"));
				this.add(new JComboBox<>(new String[]{"Default", "True", "False"}));
				this.add(new JButton("Reset"));
				this.add(new JLabel("Date Time Format:"));
				this.add(new JTextField(""));
				this.add(new JButton("Reset"));
			}
		}, NAME, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
	}
}
