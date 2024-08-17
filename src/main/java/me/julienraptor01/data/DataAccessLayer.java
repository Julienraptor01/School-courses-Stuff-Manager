package me.julienraptor01.data;

import java.util.ArrayList;

import me.julienraptor01.data.template.BasicElement;

public interface DataAccessLayer {
	void save();

	void load();

	ArrayList<BasicElement> getElements();

	void set(int id, BasicElement element);

	BasicElement get(int id);

	void add(BasicElement element);

	void remove(int id);

	int getInternalId();
}
