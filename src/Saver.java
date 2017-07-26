import java.util.Stack;

public class Saver {
	
    public static void writeNewConfig(){
    	Stack<String>Config_content = new Stack<>();
<<<<<<< HEAD
		Config_content.push(Utils.Config_filepath+"="+Utils.wordsfilepath);
		Config_content.push(Utils.Config_cell+"="+ Utils.CurrentCell);
		Config_content.push(Utils.Config_countloads+"="+Utils.countloads);
=======
		Config_content.push("fp="+Utils.wordsfilepath);
		Config_content.push("cell="+ Utils.CurrentCell);
>>>>>>> fefdac7007cca3a22bea6443e0f0ba06f6b22210
		Utils.writeStackTofile(Config_content, Utils.ConfigFileName);

		Utils.cleanwordsfile();
		
    }
}
