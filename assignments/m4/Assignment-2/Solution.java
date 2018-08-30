import java.util.*;
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
        int m = sc.nextInt();
        int n = sc.nextInt();
        int i = 0;
        int j = 0;
        int[][] a;
        a = new int[m][n];
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
            }
        int[][] b;
        b = new int[m][n];
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                b[i][j] = sc.nextInt();
            }
            }
        int[][] c;
        c = new int[m][n];
        c = summation(a, b, m, n);
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(c[i][j]+ " ");
            }
            System.out.println();
            }
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */

    static int[][] summation(final int[][] a, final int[][] b, final int m, final int n) {
        /**
         * { var_description }
         */
        int c[][];
        c = new int[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
        	}
        }
        return c;
    }
}


