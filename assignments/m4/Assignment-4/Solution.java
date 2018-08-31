 /**
 * Given an String,
 Write a java method that
 returns the decimal value
 for the given binary string.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    /**
    *Do not modify this main function.
    */
    protected Solution() { }
    /**
     * { It is the main function }.
     *
     * @param      args  It is an array of strings
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    //
    /**
     * { Write reverseString function }.
     *
     * @param      s     { s is of string type }
     *
     * @return     { the return type is string }
     */
    static String reverseString(final String s) {
        /**
         * { To reverse the given string }.
         */
        String[] a = s.split("");
        String[] b = new String[s.length()];
        String c = "";
        int j = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            b[j] = a[i];
            j--;
        }
        for (int i = 0; i < a.length; i++) {
        c += b[i];
        }
        return c;
    }
}
