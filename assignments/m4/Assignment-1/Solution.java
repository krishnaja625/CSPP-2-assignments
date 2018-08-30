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
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
            if (n >= 1) {
            int i = 0;
            int[] a;
            a = new int[n];
            for (i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                }
            System.out.println(largest(a));
        }
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static int largest(final int[] a) {
        /**
         * { var_description }
         */
        int large;
        large = a[0];
        for (int i = 0; i < a.length; i++) {
            if (large < a[i]) {
                large = a[i];
            }
        }
        return large;
    }
}



