/**
 * to import scanner class.
 */
import java.util.Scanner;
/**
 * to import BufferedInputStream.
 */
import java.io.BufferedInputStream;
/**
 * to import Arrays.
 */
import java.util.Arrays;
/**
 * Exception for signaling invalid subset selection errors.
 */
class InvalidSubsetSelectionException extends Exception {
    /**
     * Constructs the object.
     * @param      s     { parameter_description }
     */
    InvalidSubsetSelectionException(final String s) {
        super(s);
    }
}
/**
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
    /**
     * Constructs the object.
     * @param      s     { parameter_description }
     */
    SetEmptyException(final String s) {
        super(s);
    }
}
/**
 * Class for sorted set.
 */
class SortedSet extends Set {
    /**
     * Constructs the object.
     */
    SortedSet() {
    }
    /**
     * subSet method.
     * @param      fromElement                      The from element
     * @param      toElement                        To element
     * @return     { description_of_the_return_value }
     * @throws     InvalidSubsetSelectionException  { exception_description }
     */
    public int[] subSet(final int fromElement, final int toElement)
    throws InvalidSubsetSelectionException {
        if (fromElement > toElement) {
            throw new InvalidSubsetSelectionException(
                "Invalid Arguments to Subset Exception");
        }
        int[] subset = new int[size()];
        int count = 0;
        for (int i = 0, j = 0; i < size; i++) {
            if (set[i] >= fromElement && set[i] < toElement) {
                subset[j++] = set[i];
                count++;
            }
        }
        return Arrays.copyOf(subset, count);
    }
    /**
     * function to give the headset.
     * @param      toElement          To element
     * @return     { description_of_the_return_value }
     * @throws     SetEmptyException  { exception_description }
     */
    public int[] headSet(final int toElement) throws SetEmptyException {
        int[] array = new int[size()];
        int count = 0;
        for (int i = 0, j = 0; i < size; i++) {
            if (set[i] < toElement) {
                array[j++] = set[i];
                count++;
            }
        }
        int[] array1 = Arrays.copyOf(array, count);
        if (array1.length == 0) {
            throw new SetEmptyException("Set Empty Exception");
        }
        return array1;
    }
    /**
     * last method.
     * @return     { description_of_the_return_value }
     * @throws     SetEmptyException  { exception_description }
     */
    public int last() throws SetEmptyException {
        if (size == 0) {
            throw new SetEmptyException("Set Empty Exception");
        }
        return set[size - 1];
    }
    /**
     * function to add all the elements in an array.
     *
     * @param      array    The archive
     */
    public void addAll(final int[] array) {
        for (int i : array) {
            add(i);
        }
    }
    @Override
    /**
     * function to add the elements.
     *
     * @param      element  The element
     */
    public void add(final int element) {
        if (size == set.length) {
            resize();
        }
        if (!(contains(element))) {
            insert(element);
            size++;
        }
    }
    /**
     * function to insert an element.
     *
     * @param      element  The element
     */
    public void insert(final int element) {
            int index = 0;
            int i;
            for (i = 0; i < size; i++) {
                if (set[i] > element) {
                    index = i;
                    break;
                }
            }
            if (i == size) {
                index = i;
            }
            for (int j = size; j > index; j--) {
                set[j] = set[j - 1];
            }
            set[index] = element;
    }
}
/**
 * Class named solution to created.
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
        SortedSet s = new SortedSet();
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
            case "addAll":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new SortedSet();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new SortedSet();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new SortedSet();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                case "subSet":
                try {
                    if (tokens.length != 2) {
                        break;
                    }
                    String[] arrstring3 = tokens[1].split(",");
                    int[] object = s.subSet(Integer.parseInt(arrstring3[0]),
                                            Integer.parseInt(arrstring3[1]));
                    if (object != null) {
                        System.out.println(Arrays.toString(object).replace("[",
                                           "{").replace("]", "}"));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "headSet":
                try {
                    if (tokens.length != 2) {
                        break;
                    }
                    int[] obj = s.headSet(Integer.parseInt(tokens[1]));
                    if (obj != null) {
                        System.out.println(Arrays.toString(obj).replace("[",
                                           "{").replace("]", "}"));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "last":
                try {
                    if (tokens.length != 1) {
                        break;
                    }
                    int temp = s.last();
                    System.out.println(temp);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "add":
                    String[] t1 = tokens[1].split(",");
                    s.add(Integer.parseInt(tokens[1]));
                break;
                default:
                break;
            }
        }
    }
}
