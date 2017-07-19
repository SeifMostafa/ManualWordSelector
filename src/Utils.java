import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Stack;

import javax.swing.JButton;

public class Utils {
	public static String wordsfilepath = "";
	public static String openingcheckfilepath = "";
	public static String OSNAME = "";
	public static final String ConfigpathName = "Config";
	public static final String Config_filepath = "fp";
	public static final String Config_cell = "c";

	public static String getTodaysDate() {

		final Calendar c = Calendar.getInstance();
		int todaysDate = (c.get(Calendar.YEAR) * 10000) + ((c.get(Calendar.MONTH) + 1) * 100)
				+ (c.get(Calendar.DAY_OF_MONTH));
		System.out.println("DATE:" + String.valueOf(todaysDate));
		return (String.valueOf(todaysDate));

	}

	public static void writeStringToFile(String data, String filepath) {
		try {
			FileWriter writer = new FileWriter(filepath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			bufferedWriter.write(data);
			bufferedWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readFileintoString(String filepath) {

		String ret = "";

		try {
			FileReader reader = new FileReader(filepath);
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				ret += line;
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void writeStackTofile(Stack<String> result_words, String filepath) {
		try {
			FileWriter writer = new FileWriter(filepath, true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			for (String s : result_words) {
				bufferedWriter.write(s);
			}
			bufferedWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Stack<String> readfileintoStack(String filepath) {
		Stack<String> words = new Stack<>();
		try {
			FileReader reader = new FileReader(filepath);
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				words.push(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}

	public static KeyListener enter = new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				((JButton) e.getComponent()).doClick();
				System.out.println("Hello enter");
			}
		}
	};

	public static void setOSName() {
		Utils.OSNAME = System.getProperty("os.name");
	}

	public static String getCurrentPath() throws IOException {
		String path = new File(".").getCanonicalPath();
		return path;
	}

	public static int createHiddenConfigFile() {
		try {
			String dir = getCurrentPath();
			File file;
			if (OSNAME.equals("Linux") || OSNAME.equals("Mac")) {
				file = new File(dir + "/." + Utils.ConfigpathName);

			} else {
				file = new File(dir + "\\." + Utils.ConfigpathName);
			}
			openingcheckfilepath=file.getAbsolutePath();
			if (file.createNewFile()) {
				return 1;
			} else {
				return 0;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public static void checkopening(){
		if(createHiddenConfigFile()==0){
			// read from config file
			System.out.println(readFileintoString(openingcheckfilepath));
		}else{
			// ask to select filepath
			
			// save config
		}
	}

}
