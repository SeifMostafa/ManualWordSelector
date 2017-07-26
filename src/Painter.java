import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.awt.*;

import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.border.LineBorder;

public class Painter {
	public JFrame frame;
	public JTable table = null;
	public JScrollPane jScrollPane;
	private boolean ALLOW_COLUMN_SELECTION = true;
	private boolean ALLOW_ROW_SELECTION = true;
	public static final int btnsizeHeight = 100;
	public static final int btnsizeWidth = 100;
	public static final int marginWidth = 10;
	public static final int marginHeight = 10;
	public static final String FontName = "Arial";
	public static final int FontStyle = Font.PLAIN;
	public static final int FontSize = 14;

	private int width, height;

	public Painter(Object rowData[][], Object columnNames[]) {
		loadtabledata(rowData, columnNames);
		initialize();
	}

	public void loadtabledata(Object rowData[][], Object columnNames[]) {
		table = new JTable(rowData, columnNames);
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.RIGHT );
		
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
			//col.setCellEditor(new MyTableCellEditor());
		}
		table.setFont(new Font(FontName, FontStyle, FontSize));
	}

	public void initialize() {
		frame = new JFrame();
		jScrollPane = new JScrollPane();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(dim.width, dim.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		/** generate layout for words */

		table.setBounds(marginWidth, marginHeight, (frame.getWidth() - marginHeight - marginWidth),
				(frame.getHeight() - btnsizeHeight - (3 * marginWidth)));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		table.setVisible(true);
	//	table.setDragEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// table.setCellSelectionEnabled(true);
		// table.setRowSelectionAllowed(true);
		// table.setColumnSelectionAllowed(true);
		if (ALLOW_ROW_SELECTION) { // true by default
			ListSelectionModel rowSM = table.getSelectionModel();
			rowSM.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					// Ignore extra messages.
					if (e.getValueIsAdjusting())
						return;

					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if (lsm.isSelectionEmpty()) {
						System.out.println("No rows are selected.");
					} else {
						int selectedRow = lsm.getMinSelectionIndex();

						System.out.println("Row " + selectedRow + " is now selected.");
					}
				}
			});
		} else {
			table.setRowSelectionAllowed(false);
		}
		table.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// delete row method (when "delete" is pressed)
					System.out.println("ENTER");
					System.out.println("SR/SC:" + table.getSelectedRow() + "/" + table.getSelectedColumn());
					int x = table.getSelectedRow(), y = table.getSelectedColumn();
					// pre save action
					if (x == 0 && y == 0) {
						x = table.getRowCount() - 1;
						y = table.getColumnCount() - 1;
					} else if (x > 0) {
						x--;
					} else {
						y--;
						x = table.getRowCount() - 1;
					}
					SaveAction(x, y);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		if (ALLOW_COLUMN_SELECTION) { // false by default
			if (ALLOW_ROW_SELECTION) {
				// We allow both row and column selection, which
				// implies that we *really* want to allow individual
				// cell selection.
				table.setCellSelectionEnabled(true);
			}
			table.setColumnSelectionAllowed(true);
			ListSelectionModel colSM = table.getColumnModel().getSelectionModel();
			colSM.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					// Ignore extra messages.
					if (e.getValueIsAdjusting())
						return;

					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if (lsm.isSelectionEmpty()) {
						System.out.println("No columns are selected.");
					} else {
						int selectedCol = lsm.getMinSelectionIndex();
						System.out.println("Column " + selectedCol + " is now selected.");
					}
				}
			});
		}

		/** generate buttons */
		Action buttonActionNext = new AbstractAction("next") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("next...");
				NextAction();
			}
		};
		Action buttonActionSave = new AbstractAction("save") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("saving...");
				SaveAction(table.getSelectedRow(), table.getSelectedColumn());
			}
		};
		buttonActionSave.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_ENTER);
		Action buttonActionconfigpath = new AbstractAction("configpath") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("config...");
				ConfigPathAction(new FileChooser(), width / 2, height / 2);
			}
		};

		jScrollPane.setBounds(marginWidth, marginHeight, frame.getWidth() - 2 * marginWidth,
				frame.getHeight() - btnsizeHeight - 2 * marginHeight);
		jScrollPane.setViewportView(table);

		JPanel panel_btns = new JPanel();
		panel_btns.setBackground(Color.ORANGE);
		panel_btns.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_btns.setBounds(marginWidth, (frame.getHeight() - btnsizeHeight - (2 * marginHeight)),
				frame.getWidth() - (2 * marginWidth), btnsizeHeight + (2 * marginHeight));

		JButton Configpath = new JButton("Config Path");

		Configpath.addActionListener(buttonActionconfigpath);
		Configpath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Configpath.setBounds(marginWidth + btnsizeWidth + marginWidth,
				frame.getHeight() - btnsizeHeight - 2 * marginHeight,
				frame.getWidth() - 2 * btnsizeWidth - 2 * marginWidth, btnsizeHeight);
		// frame.addKeyListener(new MyKeyListener());

		JButton next = new JButton("next");
		next.addActionListener(buttonActionNext);
		next.setFont(new Font("Tahoma", Font.PLAIN, 20));
		next.setBounds(marginWidth, frame.getHeight() - 2 * marginHeight - btnsizeWidth, btnsizeWidth, btnsizeHeight);

		JButton save = new JButton("save");
		save.addActionListener(buttonActionSave);
		save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		save.setBounds(frame.getWidth() - btnsizeWidth - marginWidth,
				frame.getHeight() - 2 * marginHeight - btnsizeWidth, btnsizeWidth, btnsizeHeight);

		panel_btns.add(next);
		panel_btns.add(Configpath);
		panel_btns.add(save);

		frame.getContentPane().add(jScrollPane);
		frame.getContentPane().add(panel_btns, BorderLayout.SOUTH);

	}

	public void setTableData(Object rowData[][], Object columnNames[]) {
		/*
		 * JTable newTable = new JTable(rowData, columnNames);
		 * 
		 * this.frame.getContentPane().remove(table);
		 * this.frame.getContentPane().add(newTable);
		 */
	}

	public void NextAction() {

	}

	public void SaveAction(int x, int y) {

		Utils.CurrentCell = "" + x + "," + y;
		Saver.writeNewConfig();
		// System.out.println("Cell
		// VALUE"+(String)String.valueOf(table.getValueAt(table.getSelectedRow(),table.getSelectedColumn())));
		Utils.writeStringToFile((String) String.valueOf(table.getValueAt(x, y)), Utils.OutputWordsfilepath);
	}

	public static void ConfigPathAction(JFrame frame, int w, int h) {
		frame.setTitle("Please, Choose the file contains the words");
		frame.setSize(w, h);
		frame.setLocation(100, 100);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
	}

	static class MyKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				// delete row method (when "delete" is pressed)
				System.out.println("ENTER	");
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				// delete row method (when "delete" is released)
				System.out.println("SPACE");
			}
		}
	}

	public static class FileChooser extends JFrame {
		/**
		 * to choose the file which contains the words
		 */
		private static final long serialVersionUID = 1L;

		private JTextField filename = new JTextField(), dir = new JTextField();
		private JCheckBox chkparagrapgh = new JCheckBox("Paragraph");
		private JButton choose = new JButton("Choose"), ok = new JButton("OK");

		public FileChooser() {
			JPanel p = new JPanel();
			try {
				String path = new File(".").getAbsolutePath();
				filename.setText(path);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			choose.addActionListener(new ChooseL());
			p.add(choose);
			ok.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// remove .config file if firsttime
					if (Utils.firsttime && dir.getText().equals("")) {
						Utils.RemoveHiddenConfigFile();

					} else {
						Utils.CurrentCell = "0,0";
						// save config
						Saver.writeNewConfig();
						Utils.loadwindow();
					}

					close();
				}
			});
			chkparagrapgh.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == 1)
						Utils.IsParagraph = true;
					else
						Utils.IsParagraph = false;
				}
			});
			p.add(ok);
			Container cp = getContentPane();
			cp.add(p, BorderLayout.SOUTH);
			dir.setEditable(false);
			filename.setEditable(false);
			p = new JPanel();
			p.setLayout(new GridLayout(2, 1));
			p.add(filename);
			p.add(dir);
			p.add(chkparagrapgh);
			cp.add(p, BorderLayout.NORTH);
		}

		private void close() {
			this.dispose();
		}

		class ChooseL implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				JFileChooser c = new JFileChooser();
				// Demonstrate "Open" dialog:
				int rVal = c.showOpenDialog(FileChooser.this);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					filename.setText(c.getSelectedFile().getName());
					Utils.wordsfilepath = c.getSelectedFile().getAbsolutePath();
					Utils.OutputWordsfilepath = c.getSelectedFile().getAbsolutePath() + "_output";
					Utils.createoutputfile();
					dir.setText(c.getCurrentDirectory().toString());
				}
				if (rVal == JFileChooser.CANCEL_OPTION) {
					filename.setText("You pressed cancel");
					dir.setText("");
					// remove .config file if firsttime
					if (Utils.firsttime) {
						Utils.RemoveHiddenConfigFile();
					}
				}
			}
		}

	}
	 public static class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor {
		    JComponent component = new JTextField();
		    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int vColIndex) {
		        ((JTextField)component).setText((String)value);
		        ((JTextField)component).setFont(new java.awt.Font("Arial Unicode MS", 0, 25));
		        return component;
		    }
			@Override
			public Object getCellEditorValue() {
		        ((JTextField)component).setFont(new java.awt.Font("Arial Unicode MS", 0, 25));
				return component;
			}
		}

}

