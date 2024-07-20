package me.julienraptor01.gui;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class MainPanel extends JPanel {
	public MainPanel() {
		super(new GridLayout(1, 2));
		this.add(new Table());
		this.add(new SubPanel());
	}
}
