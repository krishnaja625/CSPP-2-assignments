import java.util.Scanner;
/**
 * { item_description }.
 */
final class Concatinate {
/**
*Fill the main function to print the number of 7's between 1 to n.
*/
    protected Concatinate() { }
/**
 * { function_description }.
 * @param      args  The arguments
 */
    public static void main(final String[] args) {
        /**
         * { var_description }.
         */
        Scanner s = new Scanner(System.in);
        String str = s.next();
        String a = helloName(str);
        System.out.println(a);
        }
    /**
     * { function_description }
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static String helloName(final String s) {
        /**
         * { var_description }
         */
        String st = new String();
        st = "Hello " + s + "!";
        return st;

    }

}