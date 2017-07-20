import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.awt.*;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Painter {
	public JFrame frame;
	public JTable table = null;
	private boolean ALLOW_COLUMN_SELECTION = true;
	private boolean ALLOW_ROW_SELECTION = true;
//	public static Painter instance;
	private int width, height;

	public Painter(Object rowData[][], Object columnNames[]) {
		loadtabledata(rowData, columnNames);
		initialize();
	//	instance = this;
	}

	public void loadtabledata(Object rowData[][], Object columnNames[]) {
		System.out.println("loading data...");
		table = new JTable(rowData, columnNames);
	}

	public void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(dim.width, dim.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/** generate layout for words */
		table.setBounds(10, 10, frame.getWidth() - 20, frame.getHeight() - 160);
		table.setVisible(true);
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
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// delete row method (when "delete" is pressed)
					SaveAction();
					System.out.println("ENTER");
					System.out.println("SR/SC:" + table.getSelectedRow() + "/" + table.getSelectedColumn());

				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

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
		// frame.addKeyListener(new MyKeyListener());

		JButton next = new JButton("next");
		Action buttonActionNext = new AbstractAction("next") {
			
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("next...");
				NextAction();
			}
		};
		next.addActionListener(buttonActionNext);
		next.setFont(new Font("Tahoma", Font.PLAIN, 20));
		next.setBounds(50, frame.getHeight() - 150, 100, 100);

		JButton save = new JButton("save");
		Action buttonActionSave = new AbstractAction("save") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("saving...");
				SaveAction();
			}
		};
		buttonActionSave.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_ENTER);
		 
		save.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "save");
		 
		save.getActionMap().put("save", buttonActionSave);
		save.addActionListener(buttonActionSave);
		save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		save.setBounds(frame.getWidth() - 150, frame.getHeight() - 150, 100, 100);

		JButton Configpath = new JButton("Config Path");
		Action buttonActionconfigpath = new AbstractAction("configpath") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("config...");
				ConfigPathAction(new FileChooser(), width / 2, height / 2);
			}
		};
		Configpath.addActionListener(buttonActionconfigpath);
		Configpath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Configpath.setBounds(250, frame.getHeight() - 100, frame.getWidth() - 500, 50);

		frame.getContentPane().add(next);
		frame.getContentPane().add(save);
		frame.getContentPane().add(table);
		frame.getContentPane().add(Configpath);

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

	public void SaveAction() {
		Utils.CurrentCell = "" + table.getSelectedRow() + "," + table.getSelectedColumn();
		Saver.writeNewConfig();
		// System.out.println("Cell
		// VALUE"+(String)String.valueOf(table.getValueAt(table.getSelectedRow(),table.getSelectedColumn())));
		Utils.writeStringToFile(
				(String) String.valueOf(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn())),
				Utils.OutputWordsfilepath);
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
				System.out.println("ENTER");
				
			}
		}
		public static void SaveAction(Painter p) {
			Utils.CurrentCell = "" + p.table.getSelectedRow() + "," + p.table.getSelectedColumn();
			Saver.writeNewConfig();
			// System.out.println("Cell
			// VALUE"+(String)String.valueOf(table.getValueAt(table.getSelectedRow(),table.getSelectedColumn())));
			Utils.writeStringToFile(
					(String) String.valueOf(p.table.getValueAt(p.table.getSelectedRow(), p.table.getSelectedColumn())),
					Utils.OutputWordsfilepath);
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			choose.addActionListener(new ChooseL());
			p.add(choose);
			ok.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Utils.CurrentCell = "0,0";
					// save config
					Saver.writeNewConfig();
					close();
				}
			});
			chkparagrapgh.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == 1 ) Utils.IsParagraph=true;
					else Utils.IsParagraph= false;
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
				}
			}
		}

	}
}