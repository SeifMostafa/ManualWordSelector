import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.awt.*;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Painter {
	public JFrame frame;
	private JTextField textField;
	
	public Painter() {
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		DisplayMode dm = gs[0].getDisplayMode();
	    int screenWidth = dm.getWidth();
	    int screenHeight = dm.getHeight();
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(dim.width, dim.height);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/**generate layout for words*/
		
		/**generate buttons */
		//frame.addKeyListener(new MyKeyListener());

		JButton next = new JButton("next");
		Action buttonActionNext = new AbstractAction("next") {
			 
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		        System.out.println("next...");
		    }
		};
		next.addActionListener(buttonActionNext);
		next.setFont(new Font("Tahoma", Font.PLAIN, 20));
		next.setBounds(50,frame.getHeight()-150,100,100);

		JButton save = new JButton("save");
		Action buttonActionSave = new AbstractAction("save") {
			 
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		        System.out.println("saving...");
		    }
		};
		save.addActionListener(buttonActionSave);
		save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		save.setBounds(frame.getWidth()-150,frame.getHeight()-150,100,100);
		
		frame.getContentPane().add(next);
		frame.getContentPane().add(save);


}
}
    class MyKeyListener extends KeyAdapter {

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
