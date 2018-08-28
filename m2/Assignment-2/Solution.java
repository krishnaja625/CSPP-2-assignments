/**
    * Do not modify this main function.
*/
import java.util.Scanner;
/**
    * Do not modify this main function.
*/
final class Solution {
/**
*Do not modify this main function.
*/
    protected Solution() { }
/**
*Do not modify this main function.
*@param args are command line arguments.
*/
    public static void main(final String[] args) {
/**
*Do not modify this main function.
*/
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
    /**
     * { function_description }
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     * @param      c     { parameter_description }
     */
    static void rootsOfQuadraticEquation(final int a,
     final int b, final int c) {
        int k = 2 + 2;
        int t = 2;
        double x = (-b + Math.sqrt(b * b - k * a * c)) / (t * a);
        double y = (-b - Math.sqrt((b * b) - (k * a * c))) / (t * a);
        System.out.println(x + " " + y);
    }
}

