package Lab7_Set.set_student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// In this method, we do not consider the order of tokens.
	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	public List<WordCount> getWordCounts() {
		// TODO
		// You can use a HashMap to store the frequency of each word
		// Then you can use a for-each loop to iterate over the words list and update
		// the map
		// Finally, you can create a list of WordCount objects from the map entries
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		List<WordCount> result = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			result.add(new WordCount(entry.getKey(), entry.getValue()));
		}
		return result;
	}

	// Returns the words that their appearances are 1, do not consider
	// duplidated words
	public Set<String> getUniqueWords() {
		// TODO
		// You can use a HashSet to store the unique words
		// Then you can use a for-each loop to iterate over the words list and add the
		// words to the set
		// If a word is already in the set, remove it
		HashSet<String> result = new HashSet<>();
		for (String word : words) {
			if (result.contains(word)) {
				result.remove(word);
			} else {
				result.add(word);
			}
		}
		return result;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		// TODO
		// You can use a HashSet to store the distinct words
		// Then you can use a for-each loop to iterate over the words list and add the
		// words to the set
		// The set will automatically ignore the duplicates
		HashSet<String> result = new HashSet<>();
		for (String word : words) {
			result.add(word);
		}
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of
	// tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> exportWordCounts() {
		// TODO
		// You can use the getWordCounts method to get a list of WordCount objects
		// Then you can use a lambda expression to sort the list by the word in
		// ascending order
		// Finally, you can print out the word and the count for each WordCount object
		List<WordCount> list = getWordCounts();
		list.sort((w1, w2) -> w1.getWord().compareTo(w2.getWord()));
		for (WordCount wc : list) {
			System.out.println(wc.getWord() + " - " + wc.getCount());
		}
		return new HashSet<>(list);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsOrderByOccurence() {
		// TODO
		// You can use the getWordCounts method to get a list of WordCount objects
		// Then you can use a lambda expression to sort the list by the count in
		// descending order
		// Finally, you can print out the word and the count for each WordCount object
		List<WordCount> list = getWordCounts();
		list.sort((w1, w2) -> w2.getCount() - w1.getCount());
		for (WordCount wc : list) {
			System.out.println(wc.getWord() + " - " + wc.getCount());
		}
		return new HashSet<>(list);
	}

	// delete words beginning with the given pattern (i.e., delete words begin
	// with 'A' letter
	public Set<WordCount> filterWords(String pattern) {
		// TODO
		// You can use a for-each loop to iterate over the words list
		// Then you can use the startsWith method of the String class to check if a word
		// matches the pattern
		// If it does, remove it from the list
		for (Iterator<String> iter = words.iterator(); iter.hasNext();) {
			String word = iter.next();
			if (word.startsWith(pattern)) {
				iter.remove();
			}
		}
		// You can return the updated list of WordCount objects by calling the
		// getWordCounts method
		return new HashSet<>(getWordCounts());
	}
}