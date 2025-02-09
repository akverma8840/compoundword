import java.util.*;

public class Compoundwords{
    private Set<String> wordSet;
    private Map<String, Boolean> hm;

    public Compoundwords(List<String> words) {
        this.wordSet = new HashSet<>(words);
        this.hm = new HashMap<>();
    }

    public boolean isCompoundWord(String word, boolean isOriginal) {
        if (hm.containsKey(word)) return hm.get(word);

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordSet.contains(prefix) && (wordSet.contains(suffix) || isCompoundWord(suffix, false))) {
                if (isOriginal) {
                    hm.put(word, true);
                }
                return true;
            }
        }

        if (isOriginal) {
            hm.put(word, false);
        }
        return false;
    }

    public String[] findLongestCompoundWords() {
        List<String> sortedWords = new ArrayList<>(wordSet);
        Collections.sort(sortedWords, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return Integer.compare(word2.length(), word1.length()); // Sorting in descending order
            }
        });


        String longest = "", secondLongest = "";
        for (String word : sortedWords) {
            if (isCompoundWord(word, true)) {
                if (longest.isEmpty()) {
                    longest = word;
                } else {
                    secondLongest = word;
                    break;
                }
            }
        }
        return new String[]{longest, secondLongest};
    }
}

