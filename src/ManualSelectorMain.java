import java.awt.EventQueue;

public class ManualSelectorMain {
	public static void ManualSelectorMainGO() {

	}

	public static void main(String[] args) {
		// System.out.println("Hello,World!\n This is [Manual word selector]
		// app");
		Utils.init();
		if (!Utils.firsttime) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
				try {
						Loader loader = new Loader();
						Painter window = loader.init();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}	
	}
}
