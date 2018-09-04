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
    protected Solution() { }
    /**
     * main function from where execution starts.
     *
     * @param      args  String array named args is created.
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
     * To find the largest number in an array of numbers.
     *
     * @param      a     A parameter a of int type created.
     *
     * @return     { return type is int }
     */
    static int largest(final int[] a) {
        /**
         * statements to find largest number.
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
