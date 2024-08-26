package me.julienraptor01.ui;

import java.io.File;
import java.util.ArrayList;

import me.julienraptor01.control.Controller;
import me.julienraptor01.data.template.BasicElement;
import me.julienraptor01.ui.transfer.DetailTuple;
import me.julienraptor01.ui.transfer.Element;

public interface UIAccessLayer {
	int getSelectedInternalId();

	Element askForElement(Element oldElement);

	File askForFile();

	void update(ArrayList<BasicElement> elements);

	void detail(ArrayList<DetailTuple> element);

	void start();

	void setController(Controller controller);

}
