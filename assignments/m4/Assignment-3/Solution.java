
// Given an String, Write a java method that returns the decimal value for the given binary string.
import java.util.Scanner;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		sc.nextLine();
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
        double decimalvalue = 0;
        long k = Long.parseLong(s);
        for (int i = 0; i < s.length(); i++) {
        	decimalvalue = decimalvalue + (int)Math.pow(2,i) * (k % 10);
        	k = k/10;
        }
        int a = (int) decimalvalue;
        return String.valueOf(a);

    }

}
