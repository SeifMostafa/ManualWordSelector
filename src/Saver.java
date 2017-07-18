import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Saver {
	
    public static void writeStackTofile(Stack<String> result_words,String filepath) {
  	  try {
	            FileWriter writer = new FileWriter(filepath, true);
	            BufferedWriter bufferedWriter = new BufferedWriter(writer);
	 
	            for(String s:result_words){
	            	bufferedWriter.write(s);
	            }		           
	            bufferedWriter.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	      }
     
  }

}
