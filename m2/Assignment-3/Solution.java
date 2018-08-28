import java.util.Scanner;
/**
 * Class for solution.
 */

public class Solution {
    /**
    new class.
     */
    protected Solution() { }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * { var_description }.
         */
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static long power(final int a, final int b) {
        if (b == 0) {
            return 1;
        }
        return a * power(a, b - 1);
    }
}

