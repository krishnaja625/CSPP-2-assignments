
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int i = 0;
        int count = 0;
        int k = 0, in = 0;
    	for (i = 1; i <= n; i++) {
    		k = i;
    		while (k > 0) {
    			in = k % 10;
       		    if (in == 7) {
       		    	count++;
       			}
            	k = k / 10;
        	}
        }
        System.out.println(count);
    }
}