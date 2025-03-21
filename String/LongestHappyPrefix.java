public class LongestHappyPrefix {
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

  // Function to find the longest happy prefix
  public static String longestPrefix(String s) {
      int[] lps = computeLPS(s);
      int prefixLength = lps[s.length() - 1]; // Longest happy prefix length

      return s.substring(0, prefixLength);
  }

  public static void main(String[] args) {
      String s = "ababab";
      System.out.println("Longest Happy Prefix: " + longestPrefix(s));
  }
}
