public class Longest_Palindromic_Substring {
  public static String longestPalindrome(String s) {
      if (s == null || s.length() < 1) return "";
      
      int start = 0, end = 0;
      
      for (int i = 0; i < s.length(); i++) {
          int len1 = expandFromCenter(s, i, i);     // Odd length palindrome
          int len2 = expandFromCenter(s, i, i + 1); // Even length palindrome
          int maxLen = Math.max(len1, len2);
          
          if (maxLen > (end - start)) {
              start = i - (maxLen - 1) / 2;
              end = i + maxLen / 2;
          }
      }
      
      return s.substring(start, end + 1);
  }

  private static int expandFromCenter(String s, int left, int right) {
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
          left--;
          right++;
      }
      return right - left - 1; // Length of the palindrome
  }

  public static void main(String[] args) {
      String s = "babad";
      System.out.println("Longest Palindromic Substring: " + longestPalindrome(s)); // Output: "bab" or "aba"
  }
}
