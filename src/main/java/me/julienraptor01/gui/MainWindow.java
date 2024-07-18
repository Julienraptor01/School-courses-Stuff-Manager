package me.julienraptor01.gui;

import me.julienraptor01.data.assets.Assets;
import me.julienraptor01.data.config.Settings;
import me.julienraptor01.gui.menuBar.Bar;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Dimension;

public class MainWindow extends JFrame {
	private static final Dimension minSize = new Dimension(720, 480);
	private static final Dimension size = new Dimension(1280, 720);
	private static final String title = "Main Window";
	private static final JMenuBar menuBar = new Bar();
	private static final Settings settings = Settings.getInstance();

	public MainWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(title);
		this.setIconImage(Assets.getAppImage());
		this.setMinimumSize(minSize);
		this.setSize(size);
		this.setLocationRelativeTo(null);
		this.setExtendedState(settings.isStartMaximized() ? JFrame.MAXIMIZED_BOTH : JFrame.NORMAL);
		this.setJMenuBar(menuBar);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		settings.setStartMaximized(false);
		new MainWindow();
		settings.setStartMaximized(null);
	}
}
