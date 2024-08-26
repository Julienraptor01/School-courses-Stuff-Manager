package me.julienraptor01.ui.windowcontent;

import java.awt.Image;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.IntStream;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import me.julienraptor01.data.Settings;
import me.julienraptor01.data.template.Rarity;
import me.julienraptor01.ui.transfer.DetailTuple;

public class DetailTable extends JScrollPane {
	private static final ActualTable actualTable = new ActualTable();

	public DetailTable() {
		super();
		setViewportView(actualTable);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new DetailTable());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	public void update(ArrayList<DetailTuple> details) {
		actualTable.update(details);
	}

	private static final class ActualTable extends JTable {
		private static final Map<Integer, String> COLUMN_NAMES = Map.of(
				0, "Name",
				1, "Data"
		);

		public ActualTable() {
			super(new MyAbstractTableModel(), new MyDefaultTableColumnModel());
			setRowHeight(64);
			getTableHeader().setReorderingAllowed(false);
		}

		public void update(ArrayList<DetailTuple> details) {
			((MyAbstractTableModel) getModel()).update(details);
		}

		public static class MyAbstractTableModel extends AbstractTableModel {
			private ArrayList<DetailTuple> details = new ArrayList<>();

			public void update(ArrayList<DetailTuple> details) {
				this.details = details;
				fireTableDataChanged();
			}

			@Override
			public int getRowCount() {
				return details.size();
			}

			@Override
			public int getColumnCount() {
				return COLUMN_NAMES.size();
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return switch (COLUMN_NAMES.get(columnIndex)) {
					case "Name" -> details.get(rowIndex).name();
					case "Data" -> details.get(rowIndex).data();
					default -> throw new IllegalArgumentException("Unexpected value: " + columnIndex);
				};
			}
		}

		private static class MyDefaultTableColumnModel extends DefaultTableColumnModel {
			private static final Settings SETTINGS = Settings.getInstance();

			{
				IntStream.range(0, COLUMN_NAMES.size()).forEach(index -> {
					TableColumn column = new TableColumn(index);
					column.setHeaderValue(COLUMN_NAMES.get(index));
					switch (COLUMN_NAMES.get(index)) {
						case "Name" -> column.setCellRenderer(new DefaultTableCellRenderer() {
							@Override
							public void setValue(Object value) {
								setText((String) value);
							}
						});
						case "Data" -> column.setCellRenderer(new DefaultTableCellRenderer() {
							@Override
							public void setValue(Object value) {
								switch (value) {
									case String string -> setText(string);
									case Integer integer -> setText(String.valueOf(integer));
									case Long longValue -> setText(ZonedDateTime.ofInstant(Instant.ofEpochSecond(longValue), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(SETTINGS.getDatetimeFormat())));
									case Double doubleValue -> setText(String.valueOf(doubleValue));
									case Rarity rarity -> setText(rarity.toString());
									case Image ignoredimage -> {} //setIcon(new ImageIcon((image).getScaledInstance(64, 64, Image.SCALE_DEFAULT))); //FIXME: fix the icon not rendering or rendering too much
									case null -> setText("");
									default -> throw new IllegalArgumentException("Unexpected value: " + value);
								}
							}
						});
						default -> throw new IllegalArgumentException("Unexpected value: " + COLUMN_NAMES.get(index));
					}
					addColumn(column);
				});
			}
		}
	}
}
