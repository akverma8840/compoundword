import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "Input_02.txt"; // Change as needed
        List<String> words = readWordsFromFile(fileName);

        long startTime = System.currentTimeMillis();
        Compoundwords solution = new Compoundwords(words);
        String[] result = solution.findLongestCompoundWords();
        long endTime = System.currentTimeMillis();

        System.out.println("1st Longest Compound Word: " + result[0]);
        System.out.println("2nd Longest Compound Word: " + result[1]);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    private static List<String> readWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return words;
    }
}
