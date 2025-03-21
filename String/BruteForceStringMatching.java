public class BruteForceStringMatching {
  // Function to check if pattern exists in the text
  static void search(String text, String pattern) {
      int n = text.length();
      int m = pattern.length();
      
      for (int i = 0; i <= n - m; i++) {
          int j;
          for (j = 0; j < m; j++) {
              if (text.charAt(i + j) != pattern.charAt(j)) {
                  break; // Mismatch found, move to the next position
              }
          }
          if (j == m) {
              System.out.println("Pattern found at index " + i);
          }
      }
  }

  public static void main(String[] args) {
      String text = "ababcababcababc";
      String pattern = "ababc";
      search(text, pattern);
  }
}
