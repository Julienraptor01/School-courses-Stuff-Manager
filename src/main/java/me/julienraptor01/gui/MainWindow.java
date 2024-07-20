package me.julienraptor01.gui;

import me.julienraptor01.data.config.Settings;
import me.julienraptor01.data.storage.Assets;
import me.julienraptor01.gui.menuBar.Bar;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.Dimension;

public class MainWindow extends JFrame {
	private static final Dimension MIN_SIZE = new Dimension(720, 480);
	private static final Dimension SIZE = new Dimension(1280, 720);
	private static final String TITLE = "Main Window";

	private static final JMenuBar MENU_BAR = new Bar();
	private static final JPanel PANEL = new MainPanel();

	private static final Settings SETTINGS = Settings.getInstance();

	public MainWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(TITLE);
		this.setIconImage(Assets.getAppImage());
		this.setMinimumSize(MIN_SIZE);
		/* TODO: remove that shit
		this.setSize(SIZE);
		this.setLocationRelativeTo(null);
		for now put it at min size in bottom right corner
		*/
		this.setSize(MIN_SIZE);
		this.setLocation(1920 - 720, 1080 - 480);
		this.setExtendedState(SETTINGS.isStartMaximized() ? JFrame.MAXIMIZED_BOTH : JFrame.NORMAL);
		this.setJMenuBar(MENU_BAR);
		this.add(PANEL);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		SETTINGS.setStartMaximized(false);
		new MainWindow();
		SETTINGS.setStartMaximized(null);
	}
}
