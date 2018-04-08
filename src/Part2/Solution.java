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
     * Constructor Function
     */
    public Solution() {

    }

    /**
     * This functions helps user in searching the anagrams within the dictionary
     *
     * @param map
     */
    public static void searchAnagrams(HashMap<String, ArrayList<String>> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\nAnagramFinder>");
        long start, end;
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.equals("exit")) {
                System.exit(0);
            } else {
                start = System.currentTimeMillis();
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String sortedString = String.valueOf(charArray);
                if (map.containsKey(sortedString) && map.get(sortedString).size() >= 2) {
                    end = System.currentTimeMillis();
                    System.out.println(map.get(sortedString).size() + " Anagrams found for " + str + " in " + (end - start) + " ms");
                    for (int i = 0; i < map.get(sortedString).size() - 1; i++) {
                        System.out.print(map.get(sortedString).get(i) + ",");
                    }
                    System.out.print(map.get(sortedString).get(map.get(sortedString).size() - 1) + " ");
                } else {
                    end = System.currentTimeMillis();
                    System.out.println("No anagrams found for " + str + " in " + (end - start) + " ms");
                }
            }
            System.out.print("\n\nAnagramFinder>");
        }
    }

    /**
     * This method loads the entire Dictionary
     *
     * @param bufferedReader
     * @param map
     */
    public static void loadDictionary(BufferedReader bufferedReader, HashMap<String, ArrayList<String>> map) {
        String line;
        long start_time = System.currentTimeMillis();
        try {
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                char[] charArray = line.toCharArray();
                Arrays.sort(charArray);
                String sortedString = String.valueOf(charArray);
                if (map.containsKey(sortedString)) {
                    map.get(sortedString).add(line);
                } else {
                    map.put(sortedString, new ArrayList<String>());
                    map.get(sortedString).add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long load_time = System.currentTimeMillis();
        System.out.println("Dictionary loaded in " + (load_time - start_time) + " ms");
    }

    /**
     * This method accepts the fileName and returns the BufferedReader object
     *
     * @param fileName
     * @return bufferedReader
     */
    public static BufferedReader getFileReaders(String fileName) {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    /**
     * Main method - It accepts the fileName
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Anagram Finder");
        System.out.println("-----------------------------");
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        loadDictionary(getFileReaders(args[0]), map);
        searchAnagrams(map);
    }
}