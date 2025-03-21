import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, wordSet, memo);
    }

    private List<String> dfs(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> result = new ArrayList<>();
        
        // Base case: if empty string, return an empty list
        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix)) {
                List<String> suffixResults = dfs(s.substring(i), wordSet, memo);
                
                for (String suffix : suffixResults) {
                    if (suffix.isEmpty()) {
                        result.add(prefix);
                    } else {
                        result.add(prefix + " " + suffix);
                    }
                }
            }
        }

        memo.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        WordBreakII solution = new WordBreakII();
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        List<String> result = solution.wordBreak(s, wordDict);
        System.out.println(result);
    }
}
