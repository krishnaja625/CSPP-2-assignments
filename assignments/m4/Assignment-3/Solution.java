/**
 * Given an String,
 * Write a java method that returns
 * the decimal value for the given binary string.
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
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
     * { convertion of binary to decimal }
     *
     * @param      s     { s is of string type }
     *
     * @return     { the return type is string }
     */
    static String binaryToDecimal(String s) {
        int sum = 0;
        int x = 1;
        int j = s.length() - 1;
        for(int i = 0; i < s.length(); i++) {
            x = (int) Math.pow(2, j);
            sum = sum + (x * Character.getNumericValue(s.charAt(i)));
            j--;
        }
        return Integer.toString(sum);
    }

}
