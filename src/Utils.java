import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Stack;

import javax.swing.JButton;

public class Utils {
	   public static  String getTodaysDate() {

	        final Calendar c = Calendar.getInstance();
	        int todaysDate = (c.get(Calendar.YEAR) * 10000) +
	                ((c.get(Calendar.MONTH) + 1) * 100) +
	                (c.get(Calendar.DAY_OF_MONTH));
	        System.out.println("DATE:"+String.valueOf(todaysDate));
	        return (String.valueOf(todaysDate));

	    }

	    public static void writeStringToFile(String data,String filepath) {
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
	            	ret+=line;
	            }
	            reader.close();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return ret;
	    }

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

	    public static Stack<String>  readfileintoStack(String filepath){
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
}
