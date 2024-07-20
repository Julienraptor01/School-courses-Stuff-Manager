package me.julienraptor01.gui;

import me.julienraptor01.data.Container;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import java.util.Map;
import java.util.stream.IntStream;

public class Table extends JScrollPane {
	public Table() {
		super(new ActualTable());
	}

	private static final class ActualTable extends JTable {
		private static final Map<Integer, String> COLUMN_NAMES = Map.of(
				0, "Icon",
				1, "Name",
				2, "Identifier",
				3, "Timestamp"
		);

		public ActualTable() {
			super(new AbstractTableModel() {
				private static final Container CONTAINER = Container.getInstance();

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
			}, new DefaultTableColumnModel() {{
				IntStream.range(0, COLUMN_NAMES.size()).forEach(i -> {
					TableColumn column = new TableColumn(i);
					column.setHeaderValue(COLUMN_NAMES.get(i));
					addColumn(column);
				});
			}});
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			getTableHeader().setReorderingAllowed(false);
		}
	}
}
