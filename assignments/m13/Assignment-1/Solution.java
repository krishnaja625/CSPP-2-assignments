import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : krishnaja makineni
 */
class Set {
    //your code goes here...
    //Good luck :-)
    private int[] set;
    private int size;
    public Set() {
        final int k = 30;
        set = new int[k];
        size = 0;
    }
    public boolean contains(int item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }
    public int size() {
        return size;
    }
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
    public void add(int item) {
/*    	for(int i = 0; i < size; i++) {
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

    private void resize() {
        int[] newset = new int[2 * set.length];
        System.arraycopy(set, 0, newset, 0, set.length);
        set = newset;
    }
    public void add(int[] newArray) {

    	for (int i = 0; i < newArray.length; i++) {
    		if (!contains(newArray[i])) {
            add(newArray[i]);
	        }
	    }
    }
    public Set intersection(Set newset1) {

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
    public Set retainAll(int[] newArray) {
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
    public void remove(final int index) {
        if (index >= 0 && index < size()) {

            for (int i = index; i < size - 1; i++) {
                set[i] = set[i + 1];
            }
            set[size - 1] = 0;
            size--;
        }
    }
    public int[][] cartesianProduct(Set newset2) {
    	int rows = this.size()*newset2.size();
    	int[][] a = new int[rows][2];
    	for (int i = 0; i < size(); i++) {
    		for (int j = 0; j < rows; j++) {
    			for (int k = 0; k < newset2.size(); k++) {
    			a[j][0] = this.set[i];
    			a[j][1] = newset2.set[k];
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
                if (s.cartesianProduct(t).length == 0) {
                	System.out.println("null");
                } else {
                	System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                }
                break;
                default:
                break;
            }
        }
    }
}
