import java.util.Scanner;
/*
	area of circle
	*/
public class area_of_Circle {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int radius = scan.nextInt();
		System.out.println(area(radius));
		
	}

	static double pi()
	{
	return 3.14;	
	} 
	/*
	Need to fill the area Of circle function
	*/
	static double area(int radius){
		double a = pi()*radius*radius;
		return a;	
}
}
