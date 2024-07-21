package me.julienraptor01.gui;

import me.julienraptor01.data.Container;
import me.julienraptor01.data.Settings;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import java.awt.Image;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.IntStream;

public class Table extends JScrollPane {
	public Table() {
		super(new ActualTable());
	}

	private static final class ActualTable extends JTable {
		private static final Map<Integer, String> COLUMN_NAMES = Map.of(0, "Icon", 1, "Name", 2, "Identifier", 3, "Timestamp");

		public ActualTable() {
			super(new AbstractTableModel() {
				private static final Container CONTAINER = Container.getInstance();

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
					return CONTAINER.size();
				}

				@Override
				public int getColumnCount() {
					return COLUMN_NAMES.size();
				}

				@Override
				public Object getValueAt(int rowIndex, int columnIndex) {
					return switch (COLUMN_NAMES.get(columnIndex)) {
						case "Name" -> CONTAINER.get(rowIndex).getName();
						case "Identifier" -> CONTAINER.get(rowIndex).getIdentifier();
						case "Texture Location" -> CONTAINER.get(rowIndex).getTextureLocation();
						case "Icon" -> CONTAINER.get(rowIndex).getIcon();
						case "Timestamp" -> CONTAINER.get(rowIndex).getTimestamp();
						default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
					};
				}
			}, new DefaultTableColumnModel() {
				private static final Settings SETTINGS = Settings.getInstance();

				{
					IntStream.range(0, COLUMN_NAMES.size()).forEach(i -> {
						TableColumn column = new TableColumn(i);
						column.setHeaderValue(COLUMN_NAMES.get(i));
						switch (COLUMN_NAMES.get(i)) {
							case "Icon" -> column.setCellRenderer(new DefaultTableCellRenderer() {
								@Override
								public void setValue(Object value) {
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
			});
			setRowHeight(64);
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			getTableHeader().setReorderingAllowed(false);
		}
	}
}
