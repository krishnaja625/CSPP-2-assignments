/**
 * { item_description }.
 */
import java.util.Scanner;
/**
 * { item_description }.
 */
final class Solution {
/**
*Fill the main function to print the number of 7's between 1 to n.
*/
    protected Solution() { }
/**
 * { function_description }.
 * @param      args  The arguments
 */
    public static void main(final String[] args) {
        /**
         * { var_description }.
         */
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /**
     * Need to write the gcd function and print the output.
     *
     * @param      n1    The n 1
     * @param      n2    The n 2
     *
     * @return     { description_of_the_return_value }
     */
    static int gcd(final int n1, final int n2) {
        /**
         * { var_description }
         */
        int i = 1, j = 0;
        int num = n2;
        int g = 0;
        if (n1 > n2) {
            num = n2;
        }
        int[] a;
        a = new int[num];
        for (i = 1; i <= num; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                a[j] = i;
                j = j + 1;
            }
        }
        if (j == 1) {
            return 1;
        }
        return a[j - 1];
    }
}

