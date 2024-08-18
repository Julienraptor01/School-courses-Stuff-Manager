package me.julienraptor01.ui;

import java.util.ArrayList;

import me.julienraptor01.control.Controller;
import me.julienraptor01.data.template.BasicElement;
import me.julienraptor01.ui.idk.DetailTuple;
import me.julienraptor01.ui.idk.Element;

public interface UIAccessLayer {
	int getSelectedInternalId();

	Element askForElement(Element oldElement);

	void update(ArrayList<BasicElement> elements);

	void detail(ArrayList<DetailTuple> element);

	void start();

	void setController(Controller controller);

}
