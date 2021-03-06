import java.util.Scanner;
/*
 * In the previous module you have created List ADT.
 * ADTs are developed as reusable libraries
 * i.e., anyone who needs the ADT can use it in their program
 * A program that uses the ADT is called a "client" of the ADT
 * The client typically instantiates an object of the ADT
 * and invokes the public methods on the ADT object.
 *
 * This assignment is to practice the idea of client to the ADT.
 * Client class is Fibonacci and the client needs to use the List ADT
 * to store fibonacci numbers in the List ADT.
 * So, Fibonacci is going to instantiate an object of List ADT
 * generate fibonacci numbers and add them to the list
 * by invoking the add method provided in the List ADT.
 *
 */
/**
 * Class for fibonacci.
 */
public class Fibonacci {
    /**
     * Constructs the object.
     */
    protected Fibonacci() {
    }
    /**
     * fib is a static method takes a argument n
     * n is the count of the fibonacci numbers to be generated.
     * The method returns a List with the n fibonacci numbers.
     *
     * Look for the hint.txt if some of the testcases fail.
     */
    /**
     * function to make a list of fibonacci numbers.
     *
     * @param      n     n is the number of fibonacci numbers in list
     *
     * @return     return type is List.
     */
    public static List fib(final int n) {
        List l = new List(n);
        int t1 = 0, t2 = 1;
        l.add(t1);
        l.add(t2);
        for (int i = 1; i < n - 1; ++i) {
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
            l.add(t2);
        }
        return l;
    }
    /**
     * Main function to print fibonacci numbers.
     *
     * @param      args  A string array named args is created.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fib(n));
    }
}

