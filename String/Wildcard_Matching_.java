public class Wildcard_Matching_ {
  public static boolean isMatch(String s, String p) {
      return helper(s, p, 0, 0);
  }

  private static boolean helper(String s, String p, int i, int j) {
      // Both strings are fully matched
      if (i == s.length() && j == p.length()) return true;

      // Pattern is exhausted but input remains
      if (j == p.length()) return false;

      // If input is exhausted, check if pattern is all '*'
      if (i == s.length()) {
          while (j < p.length() && p.charAt(j) == '*') {
              j++;
          }
          return j == p.length();
      }

      // Case 1: Characters match or pattern has '?'
      if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
          return helper(s, p, i + 1, j + 1);
      }

      // Case 2: Pattern has '*', it can match:
      //   - 0 characters (skip '*')
      //   - 1 or more characters (match `s[i]` and keep `*`)
      if (p.charAt(j) == '*') {
          return helper(s, p, i, j + 1) || helper(s, p, i + 1, j);
      }

      // Characters do not match
      return false;
  }

  public static void main(String[] args) {
      String s = "abcd";
      String p = "a*d";  // Should return true

      System.out.println("Does the pattern match? " + isMatch(s, p));
  }
}
