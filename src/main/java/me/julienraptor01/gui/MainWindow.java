package me.julienraptor01.gui;

import me.julienraptor01.control.GuiAccessLayer;
import me.julienraptor01.data.Settings;
import me.julienraptor01.data.storage.Assets;
import me.julienraptor01.gui.menuBar.Bar;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.logging.Logger;

public class MainWindow extends JFrame implements GuiAccessLayer {
	public static final Logger LOGGER = Logger.getLogger(MainWindow.class.getName());

	private static final Dimension MIN_SIZE = new Dimension(720, 480);
	private static final Dimension SIZE = new Dimension(1280, 720);
	private static final String TITLE = "Main Window";

	private static final JMenuBar MENU_BAR = new Bar();
	private static final JPanel PANEL = new MainPanel();

	private static final Settings SETTINGS = Settings.getInstance();

	private static MainWindow instance = null;

	private MainWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(TITLE);
		this.setIconImage(Assets.getAppImage());
		this.setMinimumSize(MIN_SIZE);
		this.setSize(SIZE);
		this.setLocationRelativeTo(null);
		this.setExtendedState(SETTINGS.isStartMaximized() ? JFrame.MAXIMIZED_BOTH : JFrame.NORMAL);
		this.setJMenuBar(MENU_BAR);
		this.add(PANEL);
	}

	public static MainWindow getInstance() {
		return instance == null ? instance = new MainWindow() : instance;
	}

	public static void main(String[] args) {
		SETTINGS.setStartMaximized(false);
		MainWindow mainWindow = MainWindow.getInstance();
		mainWindow.start();
		SETTINGS.setStartMaximized(null);
	}

	@Override
	public void start() {
		//TODO: remove the 2 lines below
		this.setSize(MIN_SIZE);
		this.setLocation(1920 - 720, 1080 - 480);
		this.setVisible(true);
	}
}
