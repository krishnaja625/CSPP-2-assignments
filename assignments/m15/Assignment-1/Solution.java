/**
 * To import BufferedInputStream
 */
import java.io.BufferedInputStream;
/**
 * To import Scanner
 */
import java.util.Scanner;
/**
 * To import Arrays
 */
import java.util.Arrays;
/**
 * Exception for signaling invalid position errors.
 */
class InvalidPositionException extends Exception {

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return "Invalid Position Exception";
    }
}
/**
 * Class named list is created.
 */
class List {
    /**
     * an array of integers named list.
     */
    private int[] list;
    /**
     * Private variable of integer.
     */
    private int size;
    /**
     * Constructs the object.
     */
    List() {
        final int k = 30;
        list = new int[k];
        size = 0;

    }

    /**
     * function to add the items.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (size == list.length) {
            resize();
            add(item);
        } else {
            list[size++] = item;
        }
    }
    /**
     * function to resize.
     */
    private void resize() {
        int[] newlist = new int[2 * list.length];
        System.arraycopy(list, 0, newlist, 0, list.length);
        list = newlist;
    }

    /**
     * function to return size.
     *
     * @return     return type is integer.
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }

    /**
     * remove element.
     *
     * @param      index                     The index
     *
     * @throws     InvalidPositionException  invalid index.
     */
    public void remove(final int index) throws InvalidPositionException {
        if (index >= 0 && index < size()) {

            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            list[size - 1] = 0;
            size--;
        } else {
            throw new InvalidPositionException();
        }
    }

    /**
     * function to get the item at index.
     *
     * @param      index  The index
     *
     * @return     return type is integer.
     */
    public int get(final int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            return list[index];
        }
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     return type is String
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }

    /**
     * Function tells whether item is present or not.
     * @param      item  The item
     * @return     return type is boolean.
     */
    public boolean contains(final int item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return true;
            }
        }
        return false;
    }

     /**
      * Searches for the first match.
      *
      * @param      item  The item
      *
      * @return     return type is integer.
      */
    public int indexOf(final int item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return i;
            }
        }
    return -1;
    }
    /**
     * Adds all the new array elements.
     * @param      newArray  The new array
     */
    public void addAll(final int[] newArray) {
        // write the logic
        for (int i = 0; i < newArray.length; i++) {
            add(newArray[i]);
        }
    }
     /**
      * Removes all the elements in.
      *
      * @param      newArray  The new array
      */
     public void removeAll(final int[] newArray) {
        // write the logic
        for (int j = 0; j < newArray.length; j++) {
            for (int i = 0; i < size; i++) {
                if (list[i] == newArray[j]) {
                    try {
                        remove(i);
                        i--;
                    } catch (Exception e) {

                    }
                }
            }
        }
     }
    /**
     *subList.
     *
     * @param      start                      The start
     * @param      end                        The end
     *
     * @return     subList.
     *
     * @throws     IndexOutOfBoundsException  exception for not ranged inputs
     */
    public List subList(final int start, final int end)
    throws IndexOutOfBoundsException {
        if (start <= size && end <= size
            && start != end && start >= 0 && end >= 0 && start < end) {
            List newlist = new List();
                for (int i = start; i < end; i++) {
                    newlist.add(list[i]);
            }
            return newlist;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * Function to check whether elements are equal or not.
     *
     * @param      newlist  The newlist of list type is created.
     *
     * @return     returns boolean type.
     */
    public boolean equals(final List newlist) {
        return Arrays.equals(newlist.list, list);
    }
    /**
     * Function to clear the elements.
     */
    public void clear() {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list[i];
        }
        removeAll(arr);
    }
    /**
     * function to count the number of times an element is present.
     *
     * @param      item  The item
     *
     * @return     return type is integer.
     */
    public int count(final int item) {
        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (list[i] == item) {
                count++;
            }
        }
        return count;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * Main function to do the process.
     *
     * @param      args  The arguments are of string.
     */

    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        List l = new List();

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
                case "add":
                    if (tokens.length == 2) {
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            l.add(Integer.parseInt(tokens[1]));
                        }
                    }
                break;
                case "count":
                    if (tokens.length == 2) {
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            System.out.println(l.count(
                                Integer.parseInt(tokens[1])));
                        }
                    }
                break;
                case "size":
                    System.out.println(l.size());
                break;
                case "print":
                    System.out.println(l);
                break;
                case "remove":
                if (tokens.length == 2) {
                    try {
                        l.remove(Integer.parseInt(tokens[1]));
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        int[] temp = new int[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Integer.parseInt(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                case "removeAll":
                    if (tokens.length == 2) {
                        String[] t2 = tokens[1].split(",");
                        int[] a = new int[t2.length];
                        for (int i = 0; i < t2.length; i++) {
                            a[i] = Integer.parseInt(t2[i]);
                        }
                        l.removeAll(a);
                    }
                break;
                case "subList":
                    try {
                        if (tokens.length != 2) {
                            break;
                        }
                        String[] arrstring3 = tokens[1].split(",");
                        List object = l.subList(Integer.parseInt(arrstring3[0]),
                                Integer.parseInt(arrstring3[1]));
                        if (object != null) {
                            System.out.println(object);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index Out of Bounds Exception");
                    }
                    break;
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        List l2 = new List();
                        for (int k = 0; k < lt.length; k++) {
                            l2.add(Integer.parseInt(lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                default:
                break;
            }
        }
    }
}

