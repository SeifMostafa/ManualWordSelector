import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
	public static String OutputWordsfilepath= "";
	public static String openingcheckfilepath = "";
	public static String OSNAME = "";
	public static String CurrentCell = "";
	public static final String ConfigFileName = ".Config"; // '.' to make file hidden
	public static final String Config_filepath = "fp";
	public static final String Config_cell = "c";
	public static int width;
	public static int height;

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

			bufferedWriter.write(data+"\n");
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
			FileWriter writer = new FileWriter(filepath, false);
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
				file = new File(dir + "/" + Utils.ConfigFileName);

			} else {
				file = new File(dir + "\\" + Utils.ConfigFileName);
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
			///FILE IS EXIST
			
			// read from config file
			readconfigfile(readFileintoString(openingcheckfilepath));
		}else{
			/// CREATE FILE
			// ask to select filepath
			Painter.ConfigPathAction(new Painter.FileChooser(),width/2,height/2);
			// after pressing ok from there will save the content of config file
		}
	}
	public static void readconfigfile(String filecontent){
		String[]fp_cell = filecontent.split("cell");
		wordsfilepath = fp_cell[0].substring(3);
		OutputWordsfilepath = wordsfilepath+"_output";
		CurrentCell = fp_cell[1].substring(1);
	}
	public static void SetScreenWidthHeight(){
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		DisplayMode dm = gs[0].getDisplayMode();
		width = dm.getWidth();
		height = dm.getHeight();
	}
	
	public static void init(){
		setOSName();
		SetScreenWidthHeight();
		checkopening();
	}
	public static void createoutputfile(){
		File file = new File(Utils.OutputWordsfilepath);
	}

}
