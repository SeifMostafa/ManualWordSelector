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
			data = new String[(int)numberoflines/Utils.NumberOfCols][Utils.NumberOfCols];

			int numberoflines = Utils.countLines(Utils.wordsfilepath);
			System.out.println("numberoflines"+numberoflines+"\n"+Utils.readFileintoString(Utils.wordsfilepath));
			
			data = new String[numberoflines/Utils.NumberOfCols][Utils.NumberOfCols];

			try {
				FileReader reader = new FileReader(filepath);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line;		

				for(int i=0;i<(int)(numberoflines/Utils.NumberOfCols);i++){

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
			e1.printStackTrace();
		}
		return data;
	}
	public Painter init(){
		Integer[] columnNames = new Integer[Utils.NumberOfCols];
		for (int i = 0; i < Utils.NumberOfCols; i++) {
			columnNames[i] = new Integer(i);
		}
		String data[][] = readfileinto2d(Utils.wordsfilepath);
		return new Painter(data, columnNames);
	}
}
