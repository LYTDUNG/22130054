package Lab8_map.Lab8_map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MyWordCountApp {
    public static final String fileName = "data/fit.txt";
    private Map<String, Integer> map = new TreeMap<>();

    public void loadData() throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNext()) {
            String word = input.next().toLowerCase();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        input.close();
        System.out.println(map);
    }

    public int countDistinct() {
        return this.map.size();
    }

    public void printWordCounts() throws FileNotFoundException {
        loadData(); // Load data before printing word counts
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void printWordCountsAlphabet() throws FileNotFoundException {
        TreeMap<String, Integer> sortedMap = new TreeMap<>(map); // Using existing map for alphabetical sorting
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
