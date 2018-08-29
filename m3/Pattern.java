/**
 * { item_description }.
 */
final class Pattern {
/**
*Do not modify this main function.
*/
    protected Pattern() { }
/**
*Do not modify this main function.
*@param args are command line arguments.
*/
    public static void main(final String[] args) {
/**
*Do not modify this main function.
*/
    int i = 0;
    int j = 0;
    for (i = 1; i <= 5; i++) {
        for (j = 1; j <= i; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    }
}

