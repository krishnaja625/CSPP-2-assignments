import java.util.*;
import java.lang.Math.*;
import java.io.*;
class Document {
    String text1;
    String text2;
    Document() {
        text1 = "";
        text2 = "";
    }
    public static String DocumentToString(File doc) {
        String fileToString = "";
        try {
            Scanner in = new Scanner(new FileReader(doc));
            StringBuilder sb = new StringBuilder();
            while (in.hasNext()) {
                sb.append(in.next());
                sb.append(" ");
            }
            in.close();
            fileToString = sb.toString();
        } catch(FileNotFoundException e) {
            System.out.println("no file");
        }
        return fileToString;
    }
    public static Map removewords(String text) {
        text = text.toLowerCase();
        String[] words = text.replaceAll("[^a-zA-Z\\s ]", "").split(" ");
        Map <String, Integer> map = new HashMap<>();
        for (int i = 0; i  < words.length; i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                map.put(words[i],map.get(words[i]) + 1);
            }
        }
        // for (Map.Entry m:map.entrySet()) {
        //  System.out.println(m.getKey() + " " + m.getValue());
        // }
        return map;
    }
    public static int compare(String textOne, String textTwo) {
        float numerator = 0;
        double denominator = 0;
        float firstSum = 0;
        float secondSum = 0;
        Map <String,Integer> mapOne = removewords(textOne);
        Map <String,Integer> mapTwo = removewords(textTwo);
        for (String inmapOne : mapOne.keySet()) {
            for (String inmapTwo : mapTwo.keySet()) {
                if (inmapOne.equals(inmapTwo)) {
                    numerator += mapOne.get(inmapOne) * mapTwo.get(inmapTwo);
                }
            }
        }
        for (String inmapOne : mapOne.keySet()) {
            firstSum += Math.pow(mapOne.get(inmapOne),2) ;
        }
        for (String inmapTwo : mapTwo.keySet()) {
            secondSum += Math.pow(mapTwo.get(inmapTwo),2);
        }
        denominator = Math.sqrt(firstSum) * Math.sqrt(secondSum);
        double output = (numerator / denominator) * 100;
        return  (int) ((output * 100D) / 100D) ;
    }
    
}
class Solution {
    Solution() {

    }
    public static void main(String[] args) {
        Document d = new Document();
        String path;
        Scanner scan = new Scanner(System.in);
        path = scan.nextLine();
        File folder = new File(path);
        File[] list = folder.listFiles();
        for(File t : list) {
            // System.out.println(t);
        }
        int length = list.length;
        int[][] matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = Document.compare(Document.DocumentToString(list[i]),Document.DocumentToString(list[j]));
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    
    }
}
