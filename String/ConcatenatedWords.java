import java.util.*;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWords(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        
        for (String word : words) {
            if (isConcatenated(word, wordSet, new HashMap<>())) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean isConcatenated(String word, Set<String> wordSet, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) return memo.get(word);
        
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            
            if (wordSet.contains(prefix) && (wordSet.contains(suffix) || isConcatenated(suffix, wordSet, memo))) {
                memo.put(word, true);
                return true;
            }
        }
        
        memo.put(word, false);
        return false;
    }

    public static void main(String[] args) {
        ConcatenatedWords solution = new ConcatenatedWords();
        String[] words = {"cat","cats","dog","catsdogcats","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(solution.findAllConcatenatedWords(words)); 
    }
}
