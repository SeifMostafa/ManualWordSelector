import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;

public class Draw extends JFrame {
	public static final int btnsizeHeight= 100;
	public static final int btnsizeWidth= 100;
	public static final int marginWidth = 10;
	public static final int marginHeight = 10;
	

	public Draw() {
		getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(dim.width, dim.height);
		
		JPanel panel_table = new JPanel();
		panel_table.setBounds(marginWidth, marginHeight, dim.width-(2*marginWidth), dim.height-(2*marginHeight));
		getContentPane().add(panel_table);
		
		JPanel panel_btns = new JPanel();
		panel_btns.setBounds(22, 251, 416, 37);
		getContentPane().add(panel_btns);
		
		JButton button = new JButton("Next");
		panel_btns.add(button);
	}
}
