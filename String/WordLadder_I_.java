import java.util.HashSet;
import java.util.List;

public class WordLadder_I_ {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        return findLadder(beginWord, endWord, words, 1);
    }

    public static int findLadder(String current, String endWord, HashSet<String> words, int steps) {
        if (current.equals(endWord)) return steps;

        int minSteps = Integer.MAX_VALUE;
        char[] wordArr = current.toCharArray();

        for (int i = 0; i < wordArr.length; i++) {
            char originalChar = wordArr[i];
            
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;

                wordArr[i] = c;
                String newWord = new String(wordArr);

                if (words.contains(newWord)) {
                    words.remove(newWord);
                    int result = findLadder(newWord, endWord, words, steps + 1);
                    if (result > 0) minSteps = Math.min(minSteps, result);
                    words.add(newWord);
                }
            }
            wordArr[i] = originalChar; // Restore original character
        }

        return (minSteps == Integer.MAX_VALUE) ? 0 : minSteps;
    }

    public static void main(String[] args) {
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println("Shortest Transformation Sequence: " + ladderLength(beginWord, endWord, wordList));
    }
}
