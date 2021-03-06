import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : krishnaja.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a,
     final int rows, final int columns) {
    // write ypur code here.
        int[][] c = new int[rows][columns];
        int k = 0;
        int x = 0;
        final int p = 10;
        final int q = 100;
        final int r = 49;
        int[] multiples = new int[p];
        for (int i = 0; i < p; i++) {
            multiples[i] = i * q;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int z = 0; z < multiples.length; z++) {
                    if (multiples[z] - a[i][j] > 0) {
                        k = multiples[z];
                        x = z;
                        break;
                    }
                }
                if (k - a[i][j] <= r && k - a[i][j] >= 0) {
                    c[i][j] = k;
                } else {
                    c[i][j] = k;
                    c[i][j] = multiples[x - 1];
                }
            }
    }
    return c;
}
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
