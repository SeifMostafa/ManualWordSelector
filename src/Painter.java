
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

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

<<<<<<< HEAD
=======

>>>>>>> 035b15375f58744b6e510cbb567c6ecc02acf13d
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;

import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
<<<<<<< HEAD
import javax.swing.border.LineBorder;
=======
>>>>>>> 035b15375f58744b6e510cbb567c6ecc02acf13d

public class Painter {
	public JFrame frame;
	public JTable table = null;
	private boolean ALLOW_COLUMN_SELECTION = true;
	private boolean ALLOW_ROW_SELECTION = true;
<<<<<<< HEAD
	public static final int btnsizeHeight = 100;
	public static final int btnsizeWidth = 100;
	public static final int marginWidth = 10;
	public static final int marginHeight = 10;
=======

>>>>>>> 035b15375f58744b6e510cbb567c6ecc02acf13d
	private int width, height;

	public Painter(Object rowData[][], Object columnNames[]) {
		loadtabledata(rowData, columnNames);
		initialize();
	}

	public void loadtabledata(Object rowData[][], Object columnNames[]) {
		table = new JTable(rowData, columnNames);
	}

	public void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(dim.width, dim.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< HEAD
		frame.getContentPane().setLayout(new BorderLayout());

		/** generate layout for words */

		table.setBounds(marginWidth, marginHeight, (frame.getWidth() - marginHeight - marginWidth), (frame.getHeight() - btnsizeHeight-(3*marginWidth)));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		table.setVisible(true);
		table.setDragEnabled(true);
=======

		frame.getContentPane().setLayout(new BorderLayout());

		/** generate layout for words */
		
		table.setBounds(10, 10, frame.getWidth() - 20, frame.getHeight() - 160);
		table.setVisible(true);
		table.setDragEnabled(true);
		

		frame.getContentPane().setLayout(null);

		/** generate layout for words */
		table.setBounds(10, 10, frame.getWidth() - 20, frame.getHeight() - 160);
		table.setVisible(true);

>>>>>>> 035b15375f58744b6e510cbb567c6ecc02acf13d
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
<<<<<<< HEAD
		Action buttonActionNext = new AbstractAction("next") {

=======
		// frame.addKeyListener(new MyKeyListener());

		JButton next = new JButton("next");
		Action buttonActionNext = new AbstractAction("next") {

			/**
			 * 
			 */
>>>>>>> 035b15375f58744b6e510cbb567c6ecc02acf13d
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("next...");
				NextAction();
			}
		};
<<<<<<< HEAD
=======
		next.addActionListener(buttonActionNext);
		next.setFont(new Font("Tahoma", Font.PLAIN, 20));
		next.setBounds(50, frame.getHeight() - 150, 100, 100);

		JButton save = new JButton("save");
>>>>>>> 035b15375f58744b6e510cbb567c6ecc02acf13d
		Action buttonActionSave = new AbstractAction("save") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("saving...");
				SaveAction();
			}
		};
		buttonActionSave.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_ENTER);
<<<<<<< HEAD
		Action buttonActionconfigpath = new AbstractAction("configpath") {

=======
		save.addActionListener(buttonActionSave);
		save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		save.setBounds(frame.getWidth() - 150, frame.getHeight() - 150, 100, 100);

		JButton Configpath = new JButton("Config Path");
		Action buttonActionconfigpath = new AbstractAction("configpath") {

			/**
			 * 
			 */
>>>>>>> 035b15375f58744b6e510cbb567c6ecc02acf13d
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("config...");
				ConfigPathAction(new FileChooser(), width / 2, height / 2);
			}
		};
<<<<<<< HEAD
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBounds(marginWidth, marginHeight, frame.getWidth()-2*marginWidth, frame.getHeight()-btnsizeHeight-2*marginHeight);
		jScrollPane.setViewportView(table);

		JPanel panel_btns = new JPanel();
		panel_btns.setBackground(Color.ORANGE);
		panel_btns.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_btns.setBounds(marginWidth,(frame.getHeight() - btnsizeHeight-(2*marginHeight)), frame.getWidth()-(2*marginWidth), btnsizeHeight+(2*marginHeight));

		JButton Configpath = new JButton("Config Path");
		panel_btns.add(Configpath);

		Configpath.addActionListener(buttonActionconfigpath);
		Configpath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Configpath.setBounds(marginWidth+btnsizeWidth+marginWidth, frame.getHeight() - btnsizeHeight - 2*marginHeight, frame.getWidth() - 2*btnsizeWidth - 2*marginWidth, btnsizeHeight);
		// frame.addKeyListener(new MyKeyListener());

		JButton next = new JButton("next");
		panel_btns.add(next);
		next.addActionListener(buttonActionNext);
		next.setFont(new Font("Tahoma", Font.PLAIN, 20));
		next.setBounds(marginWidth, frame.getHeight() - 2*marginHeight-btnsizeWidth, btnsizeWidth, btnsizeHeight);

		JButton save = new JButton("save");
		panel_btns.add(save);
		save.addActionListener(buttonActionSave);
		save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		save.setBounds(frame.getWidth() - btnsizeWidth-marginWidth, frame.getHeight() - 2*marginHeight-btnsizeWidth, btnsizeWidth, btnsizeHeight);
		
		frame.getContentPane().add(jScrollPane);
		frame.getContentPane().add(panel_btns, BorderLayout.SOUTH);
=======

		
		Configpath.addActionListener(buttonActionconfigpath);
		Configpath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Configpath.setBounds(250, frame.getHeight() - 100, frame.getWidth() - 500, 50);
       
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, frame.getWidth() - 20, frame.getHeight() - 160);
		//scrollPane.add(table);
		//table.add(scrollPane);
		
		
	/*	Configpath.setOpaque(false);
		Configpath.setLayout(new BorderLayout());
		.setOpaque(false);
		next.setLayout(new BorderLayout());
		.setOpaque(false);
		save.setLayout(new BorderLayout());*/


		
		

		Configpath.addActionListener(buttonActionconfigpath);
		Configpath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Configpath.setBounds(250, frame.getHeight() - 100, frame.getWidth() - 500, 50);

		frame.getContentPane().add(next);
		frame.getContentPane().add(save);
		frame.getContentPane().add(table);
		frame.getContentPane().add(Configpath);

>>>>>>> 035b15375f58744b6e510cbb567c6ecc02acf13d

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
<<<<<<< HEAD

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == 1)
						Utils.IsParagraph = true;
					else
						Utils.IsParagraph = false;
=======
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == 1 ) Utils.IsParagraph=true;
					else Utils.IsParagraph= false;
>>>>>>> 035b15375f58744b6e510cbb567c6ecc02acf13d
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
