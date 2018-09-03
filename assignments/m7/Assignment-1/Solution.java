import java.util.*;
class InputValidator
{
	/*Write the atributes and methods for InputValidator*/    
	private String name;   
/**
 * Constructor initializes the person's name, roll number, and marks.
 */
	public InputValidator(String name) {
    this.name = name;
	}
	boolean validateData() {
		final int n = 6;
		int k = name.length();
		if (k >= n) {
			return true;
		}
		return false;
}
}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData());
    }

}
