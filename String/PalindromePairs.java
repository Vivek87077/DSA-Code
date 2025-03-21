import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    String combined = words[i] + words[j];
                    if (isPalindrome(combined)) {
                        result.add(Arrays.asList(i, j));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs obj = new PalindromePairs();
        String[] words = {"bat", "tab", "cat"};
        System.out.println(obj.palindromePairs(words)); // Output: [[0, 1], [1, 0]]
    }
}
