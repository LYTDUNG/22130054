package Lab8_map.Lab8_map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer {
    private Map<String, ArrayList<Integer>> map = new HashMap<>();

    public void load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int position = 0;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words
                for (String word : words) {
                    add(word, position);
                    position += word.length() + 1; // Increment position by word length + space
                }
                position++; // Increment position for the end of the line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(String word, int position) {
        if (map.containsKey(word)) {
            ArrayList<Integer> positions = map.get(word);
            positions.add(position);
        } else {
            ArrayList<Integer> positions = new ArrayList<>();
            positions.add(position);
            map.put(word, positions);
        }
    }

    public void displayWords() {
        map.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                System.out.print(entry.getKey() + ": ");
                entry.getValue().forEach(position -> System.out.print(position + " "));
                System.out.println();
            });
    }

    public void displayText() {
        map.forEach((word, positions) -> {
            System.out.print(word + ": ");
            positions.forEach(position -> System.out.print(position + " "));
            System.out.println();
        });
    }

    public String mostFrequentWord() {
        int maxFrequency = 0;
        String mostFrequent = null;
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            int frequency = entry.getValue().size();
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequent = entry.getKey();
            }
        }
        return mostFrequent;
    }
}
