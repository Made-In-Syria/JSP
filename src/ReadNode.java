import java.util.HashMap;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;


public class ReadNode extends TreeNode{

	public String content;
	public String image;
	@Override
    public CallBack execute(HashMap<String, Value> vars) {
		Scanner keyboard = new Scanner(System.in);
		content = keyboard.next();
		save(vars);
		return new CallBack(Stop.normal, null);
    }
	public void save(HashMap<String, Value> vars){

        if(content.charAt(0) == '\"')
        	vars.put(image,new Value(1,content));
        else
        {
        try {
        	double parseDouble = Double.parseDouble(content);
            vars.put(image,new Value(0,parseDouble));
        } catch (Exception e) {

        }
        }
	}
}
