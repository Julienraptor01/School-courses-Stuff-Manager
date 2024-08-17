package me.julienraptor01.ui;

import java.util.ArrayList;

import me.julienraptor01.control.Controller;
import me.julienraptor01.data.template.BasicElement;

public interface UIAccessLayer {
	int getSelectedInternalId();

	BasicElement askForElement();

	void update(ArrayList<BasicElement> elements);

	void detail(ArrayList<detailTuple> element);

	void start();

	void setController(Controller controller);

	record detailTuple(String name, Object data) {
	}
}
