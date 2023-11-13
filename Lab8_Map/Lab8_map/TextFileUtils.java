package Lab8_map.Lab8_map;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TextFileUtils {

    // Consider having the 'add' method here or in a relevant class (e.g., TextAnalyzer)
    public static void add(String word, int position) {
        // Add functionality of adding word with its position
        // Example: TextAnalyzer.add(word, position);
    }

    // read the content of a text file
    public static void readText(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        int index = 1;

        while ((line = reader.readLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(line, " ");

            while (tokens.hasMoreTokens()) {
                String word = tokens.nextToken();

                if (!tokens.hasMoreTokens())
                    add(word, -index);  // Negating index for the last word in a line
                else
                    add(word, index);

                index++;
            }
        }
        reader.close();
    }

    public static void main(String[] args) {
        try {
            readText("data/fit.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
