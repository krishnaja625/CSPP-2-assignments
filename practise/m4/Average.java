import java.util.Scanner;
/**
 * { item_description }.
 */
final class Average {
/**
*Fill the main function to print the number of 7's between 1 to n.
*/
    protected Average() { }
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
            System.out.println(average(a));
        }
    }
    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static float average(final int[] a) {
        /**
         * { var_description }
         */
        float sum = 0.0f;
        for (int i = 0; i < a.length; i++) {
        sum = sum + a[i];
        }
        return sum/(a.length);
    }
}

