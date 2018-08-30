
import java.util.*;
public class Solution
{/*
	Fill this main function to print maximum of given array
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
	        if (n >= 1) {
            int i = 0;
            int[] a;
            a = new int[n];
            Scanner scan = new Scanner(System.in);
            for (i = 0; i < n; i++) {
                a[i] = scan.nextInt();
                }
            System.out.println(largest(a));
        }
    }
    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static int largest(final int[] a) {
        /**
         * { var_description }
         */
        int large = 0;
        for (int i = 0; i < a.length; i++) {
        	if (large < a[i]) {
        		large = a[i];
        	}
        }
        return large;
    }
}

