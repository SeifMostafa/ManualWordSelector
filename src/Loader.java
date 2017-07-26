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
			e1.printStackTrace();
		}
		return data;
	}
	public Painter init(boolean fromNext) {
		Integer[] columnNames = new Integer[Utils.NumberOfCols];
		for (int i = 0; i < Utils.NumberOfCols; i++) {
			columnNames[i] = new Integer(i);
		}
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