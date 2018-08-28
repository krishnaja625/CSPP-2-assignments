import java.util.Scanner;
/**
 * Class for bigger equal smaller.
 */
public class bigger_equal_smaller {
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int varA = scan.nextInt();
		int varB = scan.nextInt();
		if(varA > varB) {
			System.out.println("Bigger");
		}
		else if(varA == varB) {
			System.out.println("Equal");
		}
		else {
			System.out.println("Smaller");
		}
		
	}

}
