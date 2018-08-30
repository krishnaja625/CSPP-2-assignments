import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {
    }
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
        int mb = sc.nextInt();
        int nb = sc.nextInt();
        int[][] b;
        b = new int[mb][nb];
        for (i = 0; i < mb; i++) {
            for (j = 0; j < nb; j++) {
                b[i][j] = sc.nextInt();
            }
            }
        if (mb == m && nb == n) {
            int[][] c;
            c = new int[m][n];
            c = summation(a, b, m, n);
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++) {
                    System.out.print(c[i][j]);
                    if (j != n - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
        else {
            System.out.println("not possible");
        }
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     * @param      m     { parameter_description }
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */

    static int[][] summation(final int[][] a,
     final int[][] b, final int m, final int n) {
        /**
         * { var_description }
         */
        int[][] c;
        c = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }
}


