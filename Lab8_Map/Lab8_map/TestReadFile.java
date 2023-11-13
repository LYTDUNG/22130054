package Lab8_map.Lab8_map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class TestReadFile {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("data/fit.txt"));

            while (input.hasNext()) {
                String word = input.next();
                System.out.println(word);
            }

            input.close(); // Đóng Scanner sau khi sử dụng xong
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
