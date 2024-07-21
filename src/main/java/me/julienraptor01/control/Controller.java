package me.julienraptor01.control;

import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	private final DataAccessLayer dataAccessLayer;
	private final GuiAccessLayer guiAccessLayer;

	public Controller(DataAccessLayer dataAccessLayer, GuiAccessLayer guiAccessLayer) {
		this.dataAccessLayer = dataAccessLayer;
		this.guiAccessLayer = guiAccessLayer;
	}

	public void start() {
		guiAccessLayer.start();
	}

	@Override
	public void actionPerformed(@NotNull ActionEvent e) {
		switch (e.getActionCommand()) {
			case String event when event.equals(Actions.SAVE) -> dataAccessLayer.save();
			default -> throw new IllegalStateException("Unexpected value: " + e);
		}
	}
}
