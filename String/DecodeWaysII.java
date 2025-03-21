public class DecodeWaysII {
  static final int MOD = 1000000007;

  public static int numDecodings(String s) {
      return (int) helper(s, 0);
  }

  private static long helper(String s, int index) {
      if (index == s.length()) return 1;  // Valid decoding found
      if (s.charAt(index) == '0') return 0;  // Leading zero is invalid
      
      long count = 0;
      
      // Single character decoding
      if (s.charAt(index) == '*') {
          count = 9 * helper(s, index + 1);  // '*' can be 1-9
      } else {
          count = helper(s, index + 1);  // Normal single-digit decoding
      }

      // Two-character decoding
      if (index + 1 < s.length()) {
          if (s.charAt(index) == '*' && s.charAt(index + 1) == '*') {
              count += 15 * helper(s, index + 2);  // "**" can be 11-19, 21-26 (15 possibilities)
          } else if (s.charAt(index) == '*') {
              if (s.charAt(index + 1) >= '0' && s.charAt(index + 1) <= '6') {
                  count += 2 * helper(s, index + 2);  // *1-*6 → 11-16, 21-26 (2 cases)
              } else {
                  count += helper(s, index + 2);  // *7-*9 → 17-19 (1 case)
              }
          } else if (s.charAt(index + 1) == '*') {
              if (s.charAt(index) == '1') {
                  count += 9 * helper(s, index + 2);  // "1*" → 11-19
              } else if (s.charAt(index) == '2') {
                  count += 6 * helper(s, index + 2);  // "2*" → 21-26
              }
          } else {  // Normal case for "12", "23", etc.
              int num = Integer.parseInt(s.substring(index, index + 2));
              if (num >= 10 && num <= 26) {
                  count += helper(s, index + 2);
              }
          }
      }

      return count % MOD;
  }

  public static void main(String[] args) {
      String s = "*1";
      System.out.println("Number of ways: " + numDecodings(s));  // Example test case
  }
}
