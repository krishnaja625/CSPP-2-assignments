import java.util.Scanner;
/*
print "Bigger", If varA is larger than varB.
"Equal", If varA is equal to varB.
"Smaller", If varA is smaller than varB.
	*/
public class bigger_equal_smaller {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int varA = scan.nextInt();
		int varB = scan.nextInt();
		if(varA > varB)
		{
			System.out.println("Bigger");
		}
		else if(varA == varB)
		{
			System.out.println("Equal");
		}
		else
		{
			System.out.println("Smaller");
		}
		
	}

}
