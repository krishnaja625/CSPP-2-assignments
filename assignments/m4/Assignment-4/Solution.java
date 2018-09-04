/**
 * author: @krishnaja
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() { }
    /**
     * main function that gives reverse of a string.
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
     * {function to reverse the string}.
     *
     * @param      s     s is a string.
     *
     * @return     returns reverse of a string s.
     */
    static String reverseString(final String s) {
        String str1 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            str1 = str1 + s.charAt(i);
        }
        return str1;
    }
    }
