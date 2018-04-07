import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public Solution() {

    }


    public static void main(String[] args) {
        //String[] arr = new String[]{"state", "estat", "jaydeep", "attse", "eatts"};

        System.out.println("Welcome to the Anagram Finder");
        System.out.println("-----------------------------");

        long start_time = System.currentTimeMillis();
        String str = "stop";
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        //List<String> al = new ArrayList<String>();
        //List<String> stringList = new ArrayList<String>();

        System.out.println("FileName: " + args[0]);

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(args[0]);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        int value = 0;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println("Line: " + line.trim());
                //stringList.add(line.trim());
                char[] myString = line.trim().toCharArray();
                Arrays.sort(myString);
                String s2 = String.valueOf(myString);


                if(map.containsKey(s2)) {
                    map.get(s2).add(line.trim());
                } else {
                    map.put(s2, new ArrayList<String>());
                    map.get(s2).add(line.trim());
                }

                /*value++;
                if(value == 1000) {
                    break;
                }*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*char[] myString = str.toCharArray();
        Arrays.sort(myString);
        String s2 = String.valueOf(myString);*/
        /*for(int i = 0; i < stringList.size(); i++) {
            char[] tmp = stringList.get(i).toCharArray();
            Arrays.sort(tmp);
            String s1 = String.valueOf(tmp);
            if(s2.equals(s1)) {
                al.add(stringList.get(i));
            }
        }*/
        /*for(int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }*/
        long load_time = System.currentTimeMillis();
        System.out.println("Dictionary loaded in " + (load_time - start_time) + " ms");
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.print("AnagramFinder>");
        while(sc.hasNextLine()) {
            str = sc.nextLine();
            if(str.equals("exit")) {
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
        /*long end_time = System.currentTimeMillis();
        System.out.println("Map size: " + map.size());
        System.out.println("Time: " + (end_time - start_time) + " ms");*/
    }
}
