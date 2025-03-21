public class DistinctSubsequences {
  public static int countSubsequences(String s, String t, int i, int j) {
      // If we found a match
      if (j == t.length()) return 1;
      // If we exhausted s but t is still left
      if (i == s.length()) return 0;

      int count = 0;

      // Include s[i] if it matches t[j]
      if (s.charAt(i) == t.charAt(j)) {
          count += countSubsequences(s, t, i + 1, j + 1);
      }
      // Exclude s[i]
      count += countSubsequences(s, t, i + 1, j);

      return count;
  }

  public static int numDistinct(String s, String t) {
      return countSubsequences(s, t, 0, 0);
  }

  public static void main(String[] args) {
      String s = "rabbbit";
      String t = "rabbit";
      System.out.println("Distinct Subsequences: " + numDistinct(s, t)); // Output: 3
  }
}
