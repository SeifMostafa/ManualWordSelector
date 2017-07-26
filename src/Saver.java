import java.util.Stack;

public class Saver {
	
    public static void writeNewConfig(){
    	Stack<String>Config_content = new Stack<>();
		Config_content.push(Utils.Config_filepath+"="+Utils.wordsfilepath);
		Config_content.push(Utils.Config_cell+"="+ Utils.CurrentCell);
		Config_content.push(Utils.Config_countloads+"="+Utils.countloads);
		Utils.writeStackTofile(Config_content, Utils.ConfigFileName);

		Utils.cleanwordsfile();
		
    }
}
