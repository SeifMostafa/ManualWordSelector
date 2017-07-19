import java.awt.EventQueue;

public class ManualSelectorMain {

	public static void main(String[] args) {
		//System.out.println("Hello,World!\n This is [Manual word selector] app");
		Utils.init();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//dummy data
					final String[] columnNames = { "First Name", "Last Name", "Sport",
					        "# of Years", "Vegetarian" };

					    final Object[][] data = {
					        { "Mary", "Campione", "Snowboarding", new Integer(5),
					            new Boolean(false) },
					        { "Alison", "Huml", "Rowing", new Integer(3), new Boolean(true) },
					        { "Kathy", "Walrath", "Knitting", new Integer(2), new Boolean(false) },
					        { "Sharon", "Zakhour", "Speed reading", new Integer(20),
					            new Boolean(true) },
					        { "Philip", "Milne", "Pool", new Integer(10), new Boolean(false) } };
					    // check 1st time or not
					  //  String checkopening = Utils.readFileintoString(Utils.openingcheckfilepath);
					    
					Painter window = new Painter(data, columnNames);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
