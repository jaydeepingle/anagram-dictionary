import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author jaydeep
 */
public class Solution {
    /**
     * Main method - It does all the operations
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Anagram Finder");
        System.out.println("-----------------------------");
        long start_time = System.currentTimeMillis();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(args[0]);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                char[] myString = line.trim().toCharArray();
                Arrays.sort(myString);
                String s2 = String.valueOf(myString);
                if (map.containsKey(s2)) {
                    map.get(s2).add(line.trim());
                } else {
                    map.put(s2, new ArrayList<String>());
                    map.get(s2).add(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long load_time = System.currentTimeMillis();
        System.out.println("Dictionary loaded in " + (load_time - start_time) + " ms");
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.print("AnagramFinder>");
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.equals("exit")) {
                System.exit(0);
            } else {
                long t1 = System.currentTimeMillis();
                char[] myString = str.toCharArray();
                Arrays.sort(myString);
                String s2 = String.valueOf(myString);
                if (map.containsKey(s2) && map.get(s2).size() >= 2) {
                    long t2 = System.currentTimeMillis();
                    System.out.println(map.get(s2).size() + " Anagrams found for " + str + " in " + (t2 - t1) + " ms");
                    for (int i = 0; i < map.get(s2).size() - 1; i++) {
                        System.out.print(map.get(s2).get(i) + ",");
                    }
                    System.out.print(map.get(s2).get(map.get(s2).size() - 1) + " ");
                } else {
                    long t2 = System.currentTimeMillis();
                    System.out.println("No anagrams found for accept in " + (t2 - t1) + " ms");
                }
            }
            System.out.println("");
            System.out.println("");
            System.out.print("AnagramFinder>");
        }
    }
}
