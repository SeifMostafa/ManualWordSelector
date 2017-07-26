<<<<<<< HEAD
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class Loader {

	public static String[][] readfileinto2d(String filepath, int afterlines) {
		String[][] data = null;
		try {
			long numberoflines = Utils.countLines(Utils.wordsfilepath, afterlines);
			Utils.numberoflinesInFile = numberoflines;
			System.out.println("numberoflines" + numberoflines + "\n");
			if (numberoflines > Utils.MaxNumofWordsEachLoad) {
				numberoflines = Utils.MaxNumofWordsEachLoad;
			}

			data = new String[(int) (numberoflines / Utils.NumberOfCols)][Utils.NumberOfCols];
			try (Stream<String> lines = Files.lines(Paths.get(filepath))) {
				Iterator<String> iterator = lines.skip(afterlines).iterator();
				for (int i = 0; i < (numberoflines / Utils.NumberOfCols); i++) {

					for (int j = 0; j < Utils.NumberOfCols; j++) {
						if (iterator.hasNext()) {
							data[i][j] = iterator.next();
						}

					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
=======
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Stack;


public class Loader {

	public static String[][] readfileinto2d(String filepath) {
		String[][] data = null;
		try {

			long  numberoflines = Utils.countLines(Utils.wordsfilepath);	
			System.out.println("numberoflines"+numberoflines+"\n");
			if(numberoflines>1000){
				numberoflines=1000;
			}
			
			data = new String[(int) (numberoflines/Utils.NumberOfCols)][Utils.NumberOfCols];

			try {
				FileReader reader = new FileReader(filepath);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line;		

				for(int i=0;i<(numberoflines/Utils.NumberOfCols);i++){

					for(int j=0;j<Utils.NumberOfCols;j++){
						if((line = bufferedReader.readLine()) != null)
							data[i][j]=line;
						}
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return data;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
			e1.printStackTrace();
		}
		return data;
	}
<<<<<<< HEAD
	public Painter init(boolean fromNext) {
=======
	public Painter init(){
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
		Integer[] columnNames = new Integer[Utils.NumberOfCols];
		for (int i = 0; i < Utils.NumberOfCols; i++) {
			columnNames[i] = new Integer(i);
		}
<<<<<<< HEAD
		String data[][] = null;
		data = readfileinto2d(Utils.wordsfilepath, (Utils.countloads) * Utils.MaxNumofWordsEachLoad);

	/*	if (fromNext) {
			data = readfileinto2d(Utils.wordsfilepath, (Utils.countloads) * Utils.MaxNumofWordsEachLoad);
		}else{
			if (Utils.firsttime) {
				data = readfileinto2d(Utils.wordsfilepath, 0);
			} else {
				data = readfileinto2d(Utils.wordsfilepath, (Utils.countloads ) * Utils.MaxNumofWordsEachLoad);
			}
		}*/
		return new Painter(data, columnNames);
	}
}
=======
		String data[][] = readfileinto2d(Utils.wordsfilepath);
		return new Painter(data, columnNames);
	}
}
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
