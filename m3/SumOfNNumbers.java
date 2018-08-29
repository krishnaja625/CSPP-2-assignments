/**
    * Do not modify this main function.
*/
import java.util.Scanner;
/**
    * Do not modify this main function.
*/
final class SumOfNNumbers {
/**
*Do not modify this main function.
*/
    protected SumOfNNumbers() { }
/**
*Do not modify this main function.
*@param args are command line arguments.
*/
    public static void main(final String[] args) {
/**
*Do not modify this main function.
*/
    int i = 1;
    int sum = 0;
    System.out.println("Enter a number");
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    while (i <= n) {
        sum = sum + i;
        i = i + 1;
    }
    System.out.println(sum);
    }
}

