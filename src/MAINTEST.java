import java.awt.EventQueue;

public class MAINTEST {

	public static void main(String[] args) {
		Utils.init();
		Utils.cleanwordsfile();
		System.out.println("HelloS	");
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Integer[] columnNames = new Integer[Utils.NumberOfCols];
					for (int i = 0; i < Utils.NumberOfCols; i++) {
						columnNames[i] = new Integer(i);
					}
					
					Loader loader = new Loader();
					Saver.writeNewConfig();
					String data[][] = loader.readfileinto2d(Utils.wordsfilepath);
					Painter window = new Painter(data, columnNames);
					window.initialize();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/

	}

}
