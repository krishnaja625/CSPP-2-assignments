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
    /**
     * {reverse of the string}.
     *
     * @param      s     s is a string.
     *
     * @return     returns reverse of a string s.
     */
    static String reverseString(final String s) {
        String str1 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            str1 += s.charAt(i);
        }
        return str1;
    }
    }
