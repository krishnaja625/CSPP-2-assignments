
// Given an String, Write a java method that returns the decimal value for the given binary string.
import java.util.Scanner;
import java.lang.Math;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		// sc.nextLine();
		for(int i=0;i<n;i++) {
			String s=sc.nextLine();
			String res=binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
    /**
     * { function_description }
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static String binaryToDecimal(final String s) {
        /**
         * { var_description }
         */
        int decimalvalue = 0;
        int k = Integer.parseInt(String.valueOf(s));
        String a = "";
        for (int i = 0; i < s.length(); i++) {
        	decimalvalue = decimalvalue + (int)Math.pow(2,i) * (k % 10);
        	k = k/10;
        }
        a = Integer.toString(decimalvalue);
        return a;

    }

}
