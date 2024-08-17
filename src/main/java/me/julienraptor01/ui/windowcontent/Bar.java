package me.julienraptor01.ui.windowcontent;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

import me.julienraptor01.control.Actions;
import me.julienraptor01.data.Settings;
import me.julienraptor01.ui.MainWindow;

public class Bar extends JMenuBar {
	private static final JMenu[] MENUS = new JMenu[]{new File(), new Edit(), new Help(), new Manage()};

	public Bar() {
		super();
		for (JMenu menu : MENUS) {
			this.add(menu);
		}
	}

	public static class File extends JMenu {
		private static final String NAME = "File";
		private static final JMenuItem[] ITEMS = new JMenuItem[]{new Load(), new Save()};

		public File() {
			super(NAME);
			for (JMenuItem item : ITEMS) {
				this.add(item);
			}
		}

		public static class Load extends JMenuItem {
			private static final String NAME = "Load";

			public Load() {
				super(NAME);
				this.addActionListener(click -> onClick());
			}

			private void onClick() {
				MainWindow.controllerInstance.actionPerformed(new ActionEvent(this, 0, Actions.LOAD));
			}
		}

		public static class Save extends JMenuItem {
			private static final String NAME = "Save";

			public Save() {
				super(NAME);
				this.addActionListener(click -> onClick());
			}

			private void onClick() {
				MainWindow.controllerInstance.actionPerformed(new ActionEvent(this, 0, Actions.SAVE));
			}
		}
	}

	public static class Edit extends JMenu {
		private static final String NAME = "Edit";
		private static final JMenuItem[] ITEMS = new JMenuItem[]{new Config()};

		public Edit() {
			super(NAME);
			for (JMenuItem item : ITEMS) {
				this.add(item);
			}
		}

		public static class Config extends JMenuItem {
			private static final String NAME = "Config";
			private static final JFrame FRAME = new JFrame(NAME);
			private static final JPanel PANEL = new SettingsPanel();

			public Config() {
				super(NAME);
				this.addActionListener(click -> onClick());
			}

			private void onClick() {
				FRAME.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				FRAME.setContentPane(PANEL);
				FRAME.pack();
				FRAME.setLocationRelativeTo(null);
				FRAME.setVisible(true);
			}

			private static class SettingsPanel extends JPanel {
				private static final String[] START_MAXIMIZED_OPTIONS = new String[]{"Default", "True", "False"};

				private static final JLabel START_MAXIMIZED_LABEL = new JLabel("Start Maximized:");
				private static final JLabel DATE_TIME_FORMAT_LABEL = new JLabel("Date Time Format:");
				private static final JButton LOAD_BUTTON = new JButton("Load");
				private static final JButton EXIT_BUTTON = new JButton("Exit") {{
					addActionListener(click -> FRAME.dispose());
				}};
				private static final Settings SETTINGS = Settings.getInstance();
				private static final JButton SAVE_BUTTON = new JButton("Save") {{
					addActionListener(click -> SETTINGS.save());
				}};
				private static final JComboBox<String> START_MAXIMIZED_COMBO_BOX = new JComboBox<>(START_MAXIMIZED_OPTIONS) {{
					this.addItemListener(event -> {
						if (event.getStateChange() != ItemEvent.SELECTED) {
							return;
						}
						switch (event.getItem()) {
							case String value when value.equals(START_MAXIMIZED_OPTIONS[0]) -> SETTINGS.setStartMaximized(null);
							case String value when value.equals(START_MAXIMIZED_OPTIONS[1]) -> SETTINGS.setStartMaximized(true);
							case String value when value.equals(START_MAXIMIZED_OPTIONS[2]) -> SETTINGS.setStartMaximized(false);
							default -> throw new IllegalStateException("Unexpected value: " + event.getItem());
						}
					});
				}};
				private static final JButton START_MAXIMIZED_RESET_BUTTON = new JButton("Reset") {{
					addActionListener(click -> {
						SETTINGS.setStartMaximized(null);
						START_MAXIMIZED_COMBO_BOX.setSelectedIndex(0);
					});
				}};
				private static final JTextField DATE_TIME_FORMAT_TEXT_FIELD = new JTextField() {{
					this.addActionListener(event -> {
						try {
							String value = event.getActionCommand();
							DateTimeFormatter.ofPattern(value);
							SETTINGS.setDatetimeFormat(value);
						} catch (IllegalArgumentException illegalArgumentException) {
							SETTINGS.setDatetimeFormat(null);
							JOptionPane.showMessageDialog(null, illegalArgumentException.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					});
				}};
				private static final JButton DATE_TIME_FORMAT_RESET_BUTTON = new JButton("Reset") {{
					addActionListener(click -> {
						SETTINGS.setDatetimeFormat(null);
						DATE_TIME_FORMAT_TEXT_FIELD.setText("");
					});
				}};


				public SettingsPanel() {
					super(new GridLayout(3, 3));
					this.add(START_MAXIMIZED_LABEL);
					this.add(START_MAXIMIZED_COMBO_BOX);
					this.add(START_MAXIMIZED_RESET_BUTTON);
					this.add(DATE_TIME_FORMAT_LABEL);
					this.add(DATE_TIME_FORMAT_TEXT_FIELD);
					this.add(DATE_TIME_FORMAT_RESET_BUTTON);
					this.add(LOAD_BUTTON);
					this.add(EXIT_BUTTON);
					this.add(SAVE_BUTTON);
					setStartMaximizedValueFromSettings();
					setStartDateTimeFormatValueFromSettings();
					LOAD_BUTTON.addActionListener(click -> {
						SETTINGS.load();
						setStartMaximizedValueFromSettings();
						setStartDateTimeFormatValueFromSettings();
					});
				}

				private void setStartDateTimeFormatValueFromSettings() {
					DATE_TIME_FORMAT_TEXT_FIELD.setText(SETTINGS.getDatetimeFormatValue());
				}

				private void setStartMaximizedValueFromSettings() {
					START_MAXIMIZED_COMBO_BOX.setSelectedIndex(switch (SETTINGS.getStartMaximizedValue()) {
						case null -> 0;
						case Boolean value when value -> 1;
						case Boolean value when !value -> 2;
						default -> throw new IllegalStateException("Unexpected value: " + SETTINGS.getStartMaximizedValue());
					});
				}
			}
		}
	}

	public static class Help extends JMenu {
		private static final String NAME = "Help";
		private static final JMenuItem[] ITEMS = new JMenuItem[]{new Update(), new About()};

		public Help() {
			super(NAME);
			for (JMenuItem item : ITEMS) {
				this.add(item);
			}
		}

		public static class About extends JMenuItem {
			private static final String NAME = "About";
			private static final JLabel[] LABELS = new JLabel[]{new JLabel("Program Name"), new JLabel("0.0.0-DEV"), new JLabel("Julienraptor01")};

			public About() {
				super(NAME);
				this.addActionListener(click -> onClick());
			}

			private void onClick() {
				JOptionPane.showMessageDialog(null, LABELS, NAME, JOptionPane.INFORMATION_MESSAGE);
			}
		}

		public static class Update extends JMenuItem {
			private static final String NAME = "Update";
			private static final JLabel[] LABELS = {new JLabel("There is no updates planned for now."), new JLabel("Please check back later tho !")};

			public Update() {
				super(NAME);
				this.addActionListener(click -> onClick());
			}

			private void onClick() {
				JOptionPane.showMessageDialog(null, LABELS, NAME, JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static class Manage extends JMenu {
		private static final String NAME = "Manage";
		private static final JMenuItem[] ITEMS = new JMenuItem[]{new Add(), new Update(), new Remove()};

		public Manage() {
			super(NAME);
			for (JMenuItem item : ITEMS) {
				this.add(item);
			}
		}

		public static class Add extends JMenuItem {
			private static final String NAME = "Add";

			public Add() {
				super(NAME);
				this.addActionListener(click -> onClick());
			}

			private void onClick() {
				MainWindow.controllerInstance.actionPerformed(new ActionEvent(this, 0, Actions.ADD));
			}
		}

		public static class Update extends JMenuItem {
			private static final String NAME = "Update";

			public Update() {
				super(NAME);
				this.addActionListener(click -> onClick());
			}

			private void onClick() {
				MainWindow.controllerInstance.actionPerformed(new ActionEvent(this, 0, Actions.UPDATE));
			}
		}

		public static class Remove extends JMenuItem {
			private static final String NAME = "Remove";

			public Remove() {
				super(NAME);
				this.addActionListener(click -> onClick());
			}

			private void onClick() {
				MainWindow.controllerInstance.actionPerformed(new ActionEvent(this, 0, Actions.DELETE));
			}
		}
	}
}
