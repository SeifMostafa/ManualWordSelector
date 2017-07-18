import java.awt.EventQueue;

public class ManualSelectorMain {

	public static void main(String[] args) {
		//System.out.println("Hello,World!\n This is [Manual word selector] app");
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Painter window = new Painter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
