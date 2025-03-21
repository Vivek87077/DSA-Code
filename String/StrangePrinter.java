public class StrangePrinter {
  public int strangePrinter(String s) {
      return helper(s, 0, s.length() - 1);
  }

  private int helper(String s, int left, int right) {
      if (left > right) return 0;  // Base case: no characters to print
      if (left == right) return 1; // Single character needs 1 turn

      int minTurns = 1 + helper(s, left + 1, right); // Print s[left] separately

      for (int k = left + 1; k <= right; k++) {
          if (s.charAt(k) == s.charAt(left)) {
              minTurns = Math.min(minTurns, helper(s, left, k - 1) + helper(s, k + 1, right));
          }
      }

      return minTurns;
  }

  public static void main(String[] args) {
      StrangePrinter printer = new StrangePrinter();
      System.out.println(printer.strangePrinter("aaabbb")); // Expected output: 2
  }
}
