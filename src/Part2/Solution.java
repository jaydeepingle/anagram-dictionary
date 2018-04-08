import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public Solution () {

    }
    public static void searchAnagrams(HashMap<String, ArrayList<String>> map) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nAnagramFinder>");
        long t1, t2;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.equals("exit")) {
                System.exit(0);
            } else {
                t1 = System.currentTimeMillis();
                char[] myString = str.toCharArray();
                Arrays.sort(myString);
                String s2 = String.valueOf(myString);
                if (map.containsKey(s2) && map.get(s2).size() >= 2) {
                    t2 = System.currentTimeMillis();
                    System.out.println(map.get(s2).size() + " Anagrams found for " + str + " in " + (t2 - t1) + " ms");
                    for (int i = 0; i < map.get(s2).size() - 1; i++) {
                        System.out.print(map.get(s2).get(i) + ",");
                    }
                    System.out.print(map.get(s2).get(map.get(s2).size() - 1) + " ");
                } else {
                    t2 = System.currentTimeMillis();
                    System.out.println("No anagrams found for " + str + " in " + (t2 - t1) + " ms");
                }
            }
            System.out.print("\n\nAnagramFinder>");
        }
    }

    public static void loadDictionary(BufferedReader bufferedReader, HashMap<String, ArrayList<String>> map) {
        String line;
        long start_time = System.currentTimeMillis();
        try {
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();

                char[] myString = line.toCharArray();
                Arrays.sort(myString);
                String s2 = String.valueOf(myString);

                if (map.containsKey(s2)) {
                    map.get(s2).add(line);
                } else {
                    map.put(s2, new ArrayList<String>());
                    map.get(s2).add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long load_time = System.currentTimeMillis();
        System.out.println("Dictionary loaded in " + (load_time - start_time) + " ms");
    }

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

    public static void main(String[] args) {
        System.out.println("Welcome to the Anagram Finder");
        System.out.println("-----------------------------");
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        loadDictionary(getFileReaders(args[0]), map);
        searchAnagrams(map);
    }
}