
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
		for(int i=0;i<=n;i++){
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
        String a = "";
        for (int i = s.length() - 1; i >= 0; i--) {
        	int k = Integer.parseInt(String.valueOf(s.charAt(i)));
        	decimalvalue += (2^i)*k;
        }
        a = Integer.toString(decimalvalue);
        return a;

    }

}
