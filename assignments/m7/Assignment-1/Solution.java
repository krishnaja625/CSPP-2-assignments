/**
 * { Imports the scanner class }.
 * Author: krishnaja
 * Date: 03 september 2018
 */
import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * The atributes and methods for InputValidator.
     */
    private String name;
    /**
     * Constructor initializes the person's name.
     * @param      name  The name
     */
    public InputValidator(final String name) {
    this.name = name;
    }
    /**
     * Function to validate the data.
     * @return     { returns boolean type }
     */
    boolean validateData() {
        final int n = 6;
        int k = name.length();
        if (k >= n) {
            return true;
        }
        return false;
}
}
/**
 * Class for solution.
 */
public class Solution {
    /** { main funtion to perform matrix addition }.
     * @param      args  The arguments
     */
    public static void main (final String args[]) {
        Scanner s = new Scanner (System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);       
        System.out.println (i.validateData());
    }
}
