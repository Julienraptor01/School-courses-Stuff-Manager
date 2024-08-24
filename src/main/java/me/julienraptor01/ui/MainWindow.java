package me.julienraptor01.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import me.julienraptor01.control.Controller;
import me.julienraptor01.data.Settings;
import me.julienraptor01.data.storage.Assets;
import me.julienraptor01.data.template.BasicElement;
import me.julienraptor01.ui.idk.DetailTuple;
import me.julienraptor01.ui.idk.Element;
import me.julienraptor01.ui.windowcontent.Bar;
import me.julienraptor01.ui.windowcontent.DetailTable;
import me.julienraptor01.ui.windowcontent.MainTable;

public class MainWindow extends JFrame implements UIAccessLayer {
	private static final Dimension MIN_SIZE = new Dimension(720, 480);
	private static final Dimension SIZE = new Dimension(1280, 720);
	private static final String TITLE = "Stuff Manager";

	private static final JMenuBar MENU_BAR = new Bar();
	private static final JPanel PANEL = new MainPanel();

	private static final Settings SETTINGS = Settings.getInstance();

	public static Controller controllerInstance = null;

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
	public int getSelectedInternalId() {
		return ((MainPanel) PANEL).mainTable.getSelectedInternalId();
	}

	@Override
	public Element askForElement(Element oldElement) {
		ElementDialog dialog = new ElementDialog(this, oldElement);
		return dialog.askForElement();
	}

	@Override
	public void update(ArrayList<BasicElement> elements) {
		((MainPanel) PANEL).update(elements);
	}

	@Override
	public void detail(ArrayList<DetailTuple> element) {
		((MainPanel) PANEL).detail(element);
	}

	@Override
	public void start() {
		this.setVisible(true);
	}

	@Override
	public void setController(Controller controller) {
		controllerInstance = controller;
	}

	public static class MainPanel extends JPanel {
		private final MainTable mainTable = new MainTable();
		private final DetailTable detailTable = new DetailTable();

		public MainPanel() {
			super(new GridLayout(1, 2));
			this.add(mainTable);
			this.add(detailTable);
		}

		void update(ArrayList<BasicElement> elements) {
			mainTable.update(elements);
		}

		void detail(ArrayList<DetailTuple> element) {
			detailTable.update(element);
		}
	}
}
