package me.julienraptor01.ui.windowcontent;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.IntStream;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import me.julienraptor01.control.Actions;
import me.julienraptor01.data.Settings;
import me.julienraptor01.data.template.BasicElement;
import me.julienraptor01.ui.MainWindow;

public class MainTable extends JScrollPane {
	private static final ActualTable actualTable = new ActualTable();

	public MainTable() {
		super();
		setViewportView(actualTable);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new MainTable());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	public void update(ArrayList<BasicElement> elements) {
		actualTable.update(elements);
	}

	public int getSelectedInternalId() {
		return actualTable.getSelectedInternalId();
	}

	private static final class ActualTable extends JTable {
		private static final Map<Integer, String> COLUMN_NAMES = Map.of(0, "Icon", 1, "Name", 2, "Identifier", 3, "Timestamp");

		public ActualTable() {
			super(new MyAbstractTableModel(), new MyDefaultTableColumnModel());
			setRowHeight(64);
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			getSelectionModel().addListSelectionListener(event -> MainWindow.controllerInstance.actionPerformed(new ActionEvent(this, 0, Actions.DETAILS)));
			getTableHeader().setReorderingAllowed(false);
		}

		public void update(ArrayList<BasicElement> elements) {
			((MyAbstractTableModel) getModel()).update(elements);
		}

		public int getSelectedInternalId() {
			return ((MyAbstractTableModel) getModel()).getInternalId(getSelectedRow());
		}

		private static class MyAbstractTableModel extends AbstractTableModel {
			private ArrayList<BasicElement> elements = new ArrayList<>();

			public void update(ArrayList<BasicElement> elements) {
				this.elements = elements;
				fireTableDataChanged();
			}

			public int getInternalId(int rowIndex) {
				if (rowIndex < 0 || rowIndex >= elements.size()) {
					return -1;
				}
				return elements.get(rowIndex).getInternalId();
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return switch (COLUMN_NAMES.get(columnIndex)) {
					case "Name", "Identifier", "Texture Location" -> String.class;
					case "Icon" -> Image.class;
					case "Timestamp" -> Long.class;
					default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
				};
			}

			@Override
			public int getRowCount() {
				return elements.size();
			}

			@Override
			public int getColumnCount() {
				return COLUMN_NAMES.size();
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return switch (COLUMN_NAMES.get(columnIndex)) {
					case "Name" -> elements.get(rowIndex).getName();
					case "Identifier" -> elements.get(rowIndex).getIdentifier();
					case "Texture Location" -> elements.get(rowIndex).getTextureLocation();
					case "Icon" -> elements.get(rowIndex).getIcon();
					case "Timestamp" -> elements.get(rowIndex).getTimestamp();
					default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
				};
			}
		}

		private static class MyDefaultTableColumnModel extends DefaultTableColumnModel {
			private static final Settings SETTINGS = Settings.getInstance();

			{
				IntStream.range(0, COLUMN_NAMES.size()).forEach(i -> {
					TableColumn column = new TableColumn(i);
					column.setHeaderValue(COLUMN_NAMES.get(i));
					switch (COLUMN_NAMES.get(i)) {
						case "Icon" -> column.setCellRenderer(new DefaultTableCellRenderer() {
							@Override
							public void setValue(Object value) {
								if (value == null) {
									setIcon(null);
									return;
								}
								setIcon(new ImageIcon(((Image) value).getScaledInstance(64, 64, Image.SCALE_DEFAULT)));
							}
						});
						case "Timestamp" -> column.setCellRenderer(new DefaultTableCellRenderer() {
							@Override
							public void setValue(Object value) {
								setText(ZonedDateTime.ofInstant(Instant.ofEpochSecond((Long) value), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(SETTINGS.getDatetimeFormat())));
							}
						});
					}
					addColumn(column);
				});
			}
		}
	}
}
