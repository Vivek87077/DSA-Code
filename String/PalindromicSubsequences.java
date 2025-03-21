import java.util.HashSet;
import java.util.Set;

public class PalindromicSubsequences {
    // Function to check if a string is palindrome
    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Recursive function to generate subsequences
    static void generateSubsequences(String s, int index, String current, Set<String> uniquePalindromes) {
        if (index == s.length()) {
            if (!current.isEmpty() && isPalindrome(current)) {
                uniquePalindromes.add(current); // Store unique palindromes
            }
            return;
        }

        // Include current character
        generateSubsequences(s, index + 1, current + s.charAt(index), uniquePalindromes);

        // Exclude current character
        generateSubsequences(s, index + 1, current, uniquePalindromes);
    }

    public static int countPalindromicSubsequences(String s) {
        Set<String> uniquePalindromes = new HashSet<>();
        generateSubsequences(s, 0, "", uniquePalindromes);
        return uniquePalindromes.size();
    }

    public static void main(String[] args) {
        String s = "abcb";
        System.out.println("Count of Palindromic Subsequences: " + countPalindromicSubsequences(s));
    }
}
