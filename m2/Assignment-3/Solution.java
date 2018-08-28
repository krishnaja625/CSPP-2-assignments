import java.util.Scanner;
/**
 * Class for solution.
 */

public class Solution {
	/**
	 * { item_description }
	 */
	public static void main(String[] args) {
		/**
		 * { var_description }
		 */
		Scanner s=new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base,exponent);
        System.out.println(result);
	}
	/*
	Need to write the power function and print the output.
	*/
	static long power(final int a, final int b) {
        if (b == 0)
        {
        	return 1;
        }
        return a * power(a, b - 1);
}
}
