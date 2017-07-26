import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
<<<<<<< HEAD
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Stack;
import java.util.stream.Stream;
=======
import java.io.LineNumberReader;
import java.util.Calendar;
import java.util.Stack;
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210

import javax.swing.JButton;

public class Utils {
	public static String wordsfilepath = "";
<<<<<<< HEAD
	public static String OutputWordsfilepath = "";
	public static String openingcheckfilepath = "";
	public static String OSNAME = "";
	public static String CurrentCell = "";
	public static long numberoflinesInFile = 0;
	public static int countloads = 0;
	public static final String ConfigFileName = ".Config"; // '.' to make file
															// hidden
	public static final String Config_filepath = "fp";
	public static final String Config_cell = "cell";
	public static final String Config_countloads = "cl";
	public static int width;
	public static int height;
	public static final int NumberOfCols = 10;
	public static final int MaxNumofWordsEachLoad = 10000;
	public static boolean IsParagraph = false;
	public static boolean firsttime = false;
	public static boolean biggerThan10K = false;
=======
	public static String OutputWordsfilepath= "";
	public static String openingcheckfilepath = "";
	public static String OSNAME = "";
	public static String CurrentCell = "";
	public static final String ConfigFileName = ".Config"; // '.' to make file hidden
	public static final String Config_filepath = "fp";
	public static final String Config_cell = "c";
	public static int width;
	public static int height;
	public static final int NumberOfCols = 10;
	public static boolean IsParagraph = false;
	public static boolean firsttime = false;
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210

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

<<<<<<< HEAD
			bufferedWriter.write(data + "\n");
=======
			bufferedWriter.write(data+"\n");
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
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
<<<<<<< HEAD

	public static int countLines(String filename, int afterlines) throws IOException {

		InputStream is = new BufferedInputStream(new FileInputStream(filename));

		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			if (!firsttime) {
				try (Stream<String> lines = Files.lines(Paths.get(filename))) {
					Iterator<String> iterator = lines.skip(afterlines).iterator();
					while(iterator.hasNext()){
						count++;
						if (count >= MaxNumofWordsEachLoad) {
							biggerThan10K = true;
							break;
						}
					}
				}
				return (count == 0 && !empty) ? 1 : count;

			} else {
				while ((readChars = is.read(c)) != -1) {
					empty = false;
					for (int i = 0; i < readChars; ++i) {
						if (c[i] == '\n') {
							++count;
						}
					}
					if (count >= MaxNumofWordsEachLoad) {
						biggerThan10K = true;
						break;
					}
				}
				return (count == 0 && !empty) ? 1 : count;
			}

		} finally {
			is.close();
		}
		/*
		 * LineNumberReader lnr = new LineNumberReader(new FileReader(new
		 * File(filename))); lnr.skip(Long.MAX_VALUE); int result=
		 * lnr.getLineNumber() + 1;//Add 1 because line index starts at 0
		 * lnr.close(); return result;
		 */

	}
=======
	
	public static int countLines(String filename) throws IOException {

	    InputStream is = new BufferedInputStream(new FileInputStream(filename));

	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }

                if(count>10000)break;

	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();

	    }
		/*LineNumberReader  lnr = new LineNumberReader(new FileReader(new File(filename)));
		lnr.skip(Long.MAX_VALUE);
		int result= lnr.getLineNumber() + 1;//Add 1 because line index starts at 0
		lnr.close();
		return result; */

	    
	}


>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210

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
<<<<<<< HEAD
			openingcheckfilepath = file.getAbsolutePath();
			// System.out.println("openingcheckfilepath"+openingcheckfilepath);
			if (file.createNewFile()) {
				return 1;
			} else {
				return 0;
=======
			openingcheckfilepath=file.getAbsolutePath();
			//System.out.println("openingcheckfilepath"+openingcheckfilepath);
			if(file.createNewFile()) {
				return 1;
			} else {
				return 0;	
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
<<<<<<< HEAD

	public static int RemoveHiddenConfigFile() {
		try {
			String dir = getCurrentPath();
			File file;
			if (OSNAME.equals("Linux") || OSNAME.equals("Mac")) {
				file = new File(dir + "/" + Utils.ConfigFileName);

			} else {
				file = new File(dir + "\\" + Utils.ConfigFileName);
			}
			openingcheckfilepath = file.getAbsolutePath();
			// System.out.println("openingcheckfilepath"+openingcheckfilepath);
			if (file.delete()) {
				return 1;
			} else {
				return 0;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static boolean checkopening() {

		if (createHiddenConfigFile() == 0) {
			/// FILE IS EXIST

			// read from config file
			readconfigfile(readFileintoString(openingcheckfilepath));
			firsttime = false;
		} else {
			/// CREATE FILE
			// ask to select filepath
			Painter.ConfigPathAction();
=======
	

	public static boolean checkopening(){

		if(createHiddenConfigFile()==0){
			///FILE IS EXIST
			
			// read from config file
			readconfigfile(readFileintoString(openingcheckfilepath));
			firsttime= false;
		}else{
			/// CREATE FILE
			// ask to select filepath
			Painter.ConfigPathAction(new Painter.FileChooser(),width/2,height/2);
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
			// after pressing ok from there will save the content of config file
			firsttime = true;
		}

		return firsttime;
	}
<<<<<<< HEAD

	public static void readconfigfile(String filecontent) {
		String[] fp_cell = filecontent.split("cell");
		wordsfilepath = fp_cell[0].substring(3);
		OutputWordsfilepath = wordsfilepath + "_output";
		String[] cell_countloads = fp_cell[1].split("cl");
		CurrentCell = cell_countloads[0].substring(1);
		countloads = Integer.parseInt(cell_countloads[1].substring(1));
		// System.out.println(CurrentCell);
		// System.out.println(countloads);

	}

	public static void SetScreenWidthHeight() {

=======
	
	public static void readconfigfile(String filecontent){
		String[]fp_cell = filecontent.split("cell");
		wordsfilepath = fp_cell[0].substring(3);
		OutputWordsfilepath = wordsfilepath+"_output";
		CurrentCell = fp_cell[1].substring(1);
	}
	
	public static void SetScreenWidthHeight(){
		
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		DisplayMode dm = gs[0].getDisplayMode();
		width = dm.getWidth();
		height = dm.getHeight();
	}
<<<<<<< HEAD

	public static void createoutputfile() {
		new File(Utils.OutputWordsfilepath);
	}

	public static void cleanwordsfile() {
		Stack<String> ret = new Stack<>();
=======
	

	
	public static void createoutputfile(){
		new File(Utils.OutputWordsfilepath);
	}
	public static void cleanwordsfile(){
		Stack<String> ret=new Stack<>();
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
		try {
			FileReader reader = new FileReader(wordsfilepath);
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
<<<<<<< HEAD
				if (IsParagraph) {
					line = line.replaceAll("[!-~]", "");
					String words[] = line.split(" ");
					for (String word : words) {
						if (!line.equals(""))
							ret.push(word + "\n");
					}

				} else {
					line = line.replaceAll("[ -~]", "");
					if (!line.equals(""))
						ret.push(line + "\n");
=======
				if(IsParagraph){
					line = line.replaceAll("[!-~]", "");
					String words[] = line.split(" ");
					for(String word:words){
						if(!line.equals(""))ret.push(word+"\n");
					}
					
				}else{
					line = line.replaceAll("[ -~]", "");
					if(!line.equals(""))ret.push(line+"\n");
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writeStackTofile(ret, wordsfilepath);
	}
<<<<<<< HEAD

	public static void cleanwordsfile(String fp) {
		Stack<String> ret = new Stack<>();
=======
	public static void cleanwordsfile(String fp){
		Stack<String> ret=new Stack<>();
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
		try {
			FileReader reader = new FileReader(fp);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
<<<<<<< HEAD
				if (IsParagraph) {
					line = line.replaceAll("[!-~]", "");
					String words[] = line.split(" ");
					for (String word : words) {
						word = word.replaceAll("\t", "");
						word = word.replaceAll(" ", "");

						if (!line.equals(""))
							ret.push(word);
					}

				} else {
					line = line.replaceAll("[ -~]", "");
					line = line.replaceAll("\t", "");

					if (!line.equals(""))
						ret.push(line);
=======
				if(IsParagraph){
					line = line.replaceAll("[!-~]", "");
					String words[] = line.split(" ");
					for(String word:words){
							word = word.replaceAll("\t", "");
							word = word.replaceAll(" ", "");

							if(!line.equals(""))ret.push(word);
					}
					
				}else{
					line = line.replaceAll("[ -~]", "");
					line = line.replaceAll("\t", "");

					if(!line.equals(""))ret.push(line);
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writeStackTofile(ret, wordsfilepath);
	}
<<<<<<< HEAD

	public static void init() {
		setOSName();
		SetScreenWidthHeight();
		if (!checkopening()) {
			loadwindow(false);
		}

	}

	public static void loadwindow(boolean fromNext) {
=======
	
	public static void init(){
		setOSName();
		SetScreenWidthHeight();
		if(!checkopening()) {
			loadwindow();
		}

	}
	public static void loadwindow(){
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loader loader = new Loader();
<<<<<<< HEAD
					Painter window = loader.init(fromNext);

					// Next visibility
					if (!firsttime) {
						if (!biggerThan10K) {
							window.next.setVisible(false);
						}
					}

					window.frame.setVisible(true);
					String rc[] = Utils.CurrentCell.split(",");
					int r = Integer.parseInt(rc[0]), c = Integer.parseInt(rc[1]);
					if(fromNext){
						window.table.setRowSelectionInterval(0, 0);
						window.table.setColumnSelectionInterval(0, 0);
					}else{
						window.table.setRowSelectionInterval(r, r);
						window.table.setColumnSelectionInterval(c, c);
						window.jScrollPane.getVerticalScrollBar().setValue(r * NumberOfCols);

					}
=======
					Painter window = loader.init();
					window.frame.setVisible(true);
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
