package me.julienraptor01;

import me.julienraptor01.control.Controller;
import me.julienraptor01.data.Container;
import me.julienraptor01.data.DataAccessLayer;
import me.julienraptor01.ui.MainWindow;
import me.julienraptor01.ui.UIAccessLayer;

public class Main {
	private static final DataAccessLayer MODEL = Container.getInstance();
	private static final UIAccessLayer VIEW = MainWindow.getInstance();

	public static void main(String[] args) {
		Controller controller = new Controller(MODEL, VIEW);
		controller.start();
	}
}
