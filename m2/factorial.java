import java.util.Scanner;
/**
 * Class for factorial.
 */
public class factorial {
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		System.out.println(factorial(number));
		
	} 
	/**
	 * { function_description }
	 *
	 * @param      number  The number
	 *
	 * @return     { description_of_the_return_value }
	 */
	static int factorial(int number){
		int a = number;
		if(number>1)
		a = a*factorial(number-1);
		return a;	
    }
}
