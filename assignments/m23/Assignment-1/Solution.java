import java.io.File; 
import java.util.Scanner; 
import java.util.Arrays;
import java.util.HashMap;
public class Solution 
{ 
    Solution() {

    }
    public static void main(String[] args) throws Exception { 
        Scanner scan = new Scanner(System.in);
        String folder = scan.next();
        File directory = new File(folder);
        String[] file = directory.list();
        String temp;
        for(int i=0; i<file.length-1;i++) {
            for(int j=0;j<file.length;j++) {
                if(file[i].compareTo(file[j])>0) {
                    temp = file[i];
                    file[i] = file[j];
                    file[j] = temp;
                }
            }
        }
        int[][] distance = new int[file.length][file.length];
        for(int i=0;i<file.length;i++) {
            for(int j=0;j<file.length;j++) {
                File file1 = new File(folder+"\\"+file[i]);
                File file2 = new File(folder+"\\"+file[j]);
                HashMap<String, Integer> dict1 = getfile(new Scanner(file1));
                HashMap<String, Integer> dict2 = getfile(new Scanner(file2));
                distance[i][j] = similarity(dict1,dict2);

        }
        }
/*    System.out.println(dict1);
    System.out.println(dict2);*/
    // similarity(dict1, dict2);
}
    static int similarity(HashMap<String, Integer> dict1, HashMap<String, Integer> dict2) {
        double numerator = 0.0;
        double denominator1 = 0.0;
        double denominator2 = 0.0;
        double result = 0.0;
        for(String key : dict1.keySet()) {
            if(dict2.containsKey(key)) {
                numerator += dict1.get(key) * dict2.get(key);
            }
            }
            for(String key : dict1.keySet()) {
                int dict1value = dict1.get(key);
                denominator1 += Math.pow(dict1value,2);
            }
            for(String key : dict2.keySet()) {
                int dict2value = dict2.get(key);
                denominator2 += Math.pow(dict2value,2);
            }
            result = numerator / (Math.sqrt(denominator1) * Math.sqrt(denominator2));
            // System.out.println((int) (result*100));
            return (int) result*100;
    }
    public static HashMap<String, Integer> getfile(Scanner sc) {
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        while(sc.hasNext()) {
            String line = sc.nextLine().toLowerCase();
            line = line.replaceAll("[0-9_]","");
            String[] wordlist =  line.split(" ");
            for(int i=0;i<wordlist.length;i++) {
                if(words.containsKey(wordlist[i])) {
                    words.put(wordlist[i],words.get(wordlist[i])+1);
                }
                else {
                    words.put(wordlist[i],1);
                }
            }
        }
        return words;
    }
}
    