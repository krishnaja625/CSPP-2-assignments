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
 *
 * @param      args  The arguments
 */
    public static void main(final String[] args) {
        /**
         * { var_description }.
         */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 0;
        int count = 0;
        final int x = 10;
        final int y = 7;
        int k = 0, in = 0;
        for (i = 1; i <= n; i++) {
            k = i;
            while (k > 0) {
                in = k % x;
                if (in == y) {
                    count++;
                }
                k = k / x;
            }
        }
        System.out.println(count);
    }
}


