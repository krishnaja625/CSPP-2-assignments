/**
 * To import BufferedInputStream
 */
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : krishnaja makineni
 */
/**
 * Class for set.
 */
class Set {
    //your code goes here...
    //Good luck :-)
    /**
     * A private variable of name set and of integer array type is created.
     */
    private int[] set;
    /**
     * A private variable size of integer type is created.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Set() {
        final int k = 30;
        set = new int[k];
        size = 0;
    }
    /**
     * function to say whether the item is present or not.
     *
     * @param      item  The item
     *
     * @return     return type is boolean.
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }
    /**
     * Function to return size os a set.
     *
     * @return     return type is integer.
     */
    public int size() {
        return size;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     return type is string.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + set[i] + ", ";
        }
        str = str + set[i] + "}";
        return str;
    }
    /**
     * function to add items if the item is not present.
     * @param      item  The item
     */
    public void add(final int item) {
/*      for(int i = 0; i < size; i++) {
            if (set[i] != item) {
                c++;
            }
        }*/
        if (!contains(item)) {
            if (size == set.length) {
                resize();
                add(item);
            } else {
                set[size++] = item;
            }
        }
    }
    /**
     * Function to resize the set if items exceed the existing size.
     */
    private void resize() {
        int[] newset = new int[2 * set.length];
        System.arraycopy(set, 0, newset, 0, set.length);
        set = newset;
    }
    /**
     * function to add an array of items to the set.
     *
     * @param      newArray  The new array of items to be passed.
     */
    public void add(final int[] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            if (!contains(newArray[i])) {
            add(newArray[i]);
            }
        }
    }
    /**
     * Function to give intersection of elements.
     * @param      newset1  newset1 is created
     *  of set datatype and is passed as argument.
     *
     * @return     return type is set.
     */
    public Set intersection(final Set newset1) {

        Set newset3 = new Set();
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < newset1.size(); j++) {
                if (this.set[i] == newset1.set[j]) {
                    newset3.add(this.set[i]);
                }
            }
        }
        return newset3;

    }
    /**
     * Function to retain all elements in given array.
     *
     * @param      newArray  The new array
     *
     * @return     return type is set.
     */
    public Set retainAll(final int[] newArray) {
        Set newset3 = new Set();
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < newArray.length; j++) {
                if (this.set[i] == newArray[j]) {
                    newset3.add(this.set[i]);
                }
            }
        }
        return newset3;
    }
    /**
     * Function to find the cartesian product.
     *
     * @param      newset2  A set is passed to find cartesian product.
     *
     * @return     return type is a 2-D array.
     */
    public int[][] cartesianProduct(final Set newset2) {
        int rows = this.size() * newset2.size();
        int[][] a = new int[rows][2];
        for (int i = 0; i < size(); i++) {
            int k = 0;
            for (int j = 0; j < rows; j++) {
                a[j][0] = this.set[i];
                a[j][1] = newset2.set[k];
                k++;
                if (k == newset2.size()) {
                    k = 0;
                    i++;
                }
            }
        }
        return a;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                if (intArray(tokens[1]).length == 0
                    && intArray(tokens[2]).length == 0) {
                    System.out.println("null");
                } else {
                    System.out.println(Arrays.deepToString(
                        s.cartesianProduct(t)));
                }
                break;
                default:
                break;
            }
        }
    }
}

