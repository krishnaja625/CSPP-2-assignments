/**
 * { item_description }.
 */
import java.util.Scanner;
/**
 * { item_description }.
 */
final class FirstLast6 {
/**
*Fill the main function to print the number of 7's between 1 to n.
*/
    protected FirstLast6() { }
/**
 * { function_description }.
 * @param      args  The arguments
 */
    public static void main(final String[] args) {
        /**
         * { var_description }.
         */
        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        if (n >= 1) {
            int i = 0;
            int[] a;
            a = new int[n];
            Scanner scan = new Scanner(System.in);
            for (i = 0; i < n; i++) {
                a[i] = scan.nextInt();
                }
            System.out.println(firstLast6(a));
        }
    }
    /**
     * { function_description }
     *
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static boolean firstLast6(final int[] a) {
        /**
         * { var_description }
         */
        if ( a[0] == 6 || a[a.length - 1] == 6) {
            return true;
        }
        return false;
    }
}

