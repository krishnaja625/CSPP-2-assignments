import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	static void rootsOfQuadraticEquation(int a, int b, int c) {
		int k = 4;
		int t = 2;
		double x = (-b+Math.sqrt(b * b - k * a * c)) / (t * a);
		double y = (-b-Math.sqrt((b * b) - (k * a * c))) / (t * a);
		System.out.println(x + " " + y);	
	}
}
