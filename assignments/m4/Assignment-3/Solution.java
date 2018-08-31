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
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static String binaryToDecimal(final String s) {
        /**
         * { var_description }.
         */
        double decimalvalue = 0;
        long k = Long.parseLong(s);
        final int x = 10;
        for (int i = 0; i < s.length(); i++) {
            decimalvalue = decimalvalue
            + (int) Math.pow(2, i) * (k % x);
            k = k / x;
        }
        int a = (int) decimalvalue;
        return String.valueOf(a);

    }

}
