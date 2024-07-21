package me.julienraptor01.control;

import me.julienraptor01.data.BasicElement;

public interface DataAccessLayer {
	void save();

	void load();

	int size();

	void set(int index, BasicElement element);

	BasicElement get(int index);

	void add(BasicElement element);

	void remove(int index);

	void clear();
}
