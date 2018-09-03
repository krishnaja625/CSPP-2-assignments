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
    private String data;
    private int length;
    /**
     * Constructor initializes the person's name.
     * @param      name  The name
     */
    InputValidator(final String name) {
    data = name;
    length = data.length();
    }
    /**
     * Function to validate the data.
     * @return     { returns boolean type }
     */
    boolean validateData() {
        final int n = 6;
        if (length >= n) {
            return true;
        }
        return false;
}
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main funtion to perform validation.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}

