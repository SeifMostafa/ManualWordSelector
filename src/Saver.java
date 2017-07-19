import java.util.Stack;

public class Saver {
	
    public static void writeNewConfig(){
    	Stack<String>Config_content = new Stack<>();
		Config_content.push("fp="+Utils.wordsfilepath);
		Config_content.push("cell="+ Utils.CurrentCell);
		Utils.writeStackTofile(Config_content, Utils.ConfigFileName);
    }
}
