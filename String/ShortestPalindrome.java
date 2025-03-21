public class ShortestPalindrome {
  public static String shortestPalindrome(String s) {
      int n = s.length();
      int longestPalPrefix = 0;

      // Find the longest palindromic prefix
      for (int i = n; i >= 0; i--) {
          if (isPalindrome(s.substring(0, i))) {
              longestPalPrefix = i;
              break;
          }
      }

      // Remaining suffix that is not a palindrome
      String suffix = s.substring(longestPalPrefix);
      String reversedSuffix = new StringBuilder(suffix).reverse().toString();

      // Prepend reversed suffix to make the shortest palindrome
      return reversedSuffix + s;
  }

  // Function to check if a string is a palindrome
  private static boolean isPalindrome(String s) {
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

  public static void main(String[] args) {
      String s = "abcd";
      System.out.println(shortestPalindrome(s)); // Output: "dcbabcd"

      String s2 = "aacecaaa";
      System.out.println(shortestPalindrome(s2)); // Output: "aaacecaaa"
  }
}
