import java.util.Scanner;
/**
 * Class for bigger equal smaller.
 */
public class biggerEqualSmaller {
    /**
     * Constructs the object.
     */
    protected biggerEqualSmaller() { }
    /**
     * { function_description }.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int varA = scan.nextInt();
        int varB = scan.nextInt();
        if (varA > varB) {
            System.out.println("Bigger");
        }
        else if (varA == varB) {
            System.out.println("Equal");
        }
        else {
            System.out.println("Smaller");
        }      
    }
}
