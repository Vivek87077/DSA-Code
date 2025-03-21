public class ShortestPalindromeKMP {
  // Function to compute LPS array
  static int[] computeLPS(String s) {
      int n = s.length();
      int[] lps = new int[n];
      int len = 0, i = 1;

      while (i < n) {
          if (s.charAt(i) == s.charAt(len)) {
              len++;
              lps[i] = len;
              i++;
          } else {
              if (len != 0) {
                  len = lps[len - 1];
              } else {
                  lps[i] = 0;
                  i++;
              }
          }
      }
      return lps;
  }

  // Function to find the shortest palindrome
  public static String shortestPalindrome(String s) {
      if (s.isEmpty()) return s;

      // Create new string "s#reverse(s)"
      String rev = new StringBuilder(s).reverse().toString();
      String combined = s + "#" + rev;

      // Compute LPS array for the combined string
      int[] lps = computeLPS(combined);

      // Find the longest palindromic prefix length
      int palinLen = lps[combined.length() - 1];

      // Add the remaining characters from reverse(s) at the front
      String prefix = rev.substring(0, rev.length() - palinLen);
      return prefix + s;
  }

  public static void main(String[] args) {
      String s = "abcd";
      System.out.println("Shortest Palindrome: " + shortestPalindrome(s));
  }
}
