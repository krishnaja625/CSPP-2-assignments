/**
 * author: @krishnaja
 */
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
     * main to add two matrices.
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
        } else {
            System.out.println("not possible");
        }
    }
    /**
     * function to add two matices.
     *
     * @param      a     { matrix a }
     * @param      b     { matrix b }
     * @param      m     { number of rows }
     * @param      n     { number of columns }
     *
     * @return     returns an integer matrix
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


