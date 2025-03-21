public class ScrambleString {
  public static boolean isScramble(String s1, String s2) {
      if (s1.equals(s2)) return true;
      if (s1.length() != s2.length()) return false;

      // Check if both strings have the same character frequency
      int[] freq = new int[26];
      for (int i = 0; i < s1.length(); i++) {
          freq[s1.charAt(i) - 'a']++;
          freq[s2.charAt(i) - 'a']--;
      }
      for (int count : freq) {
          if (count != 0) return false;
      }

      int n = s1.length();
      for (int i = 1; i < n; i++) {
          // Case 1: No swap
          if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
              isScramble(s1.substring(i), s2.substring(i))) {
              return true;
          }
          // Case 2: Swap
          if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
              isScramble(s1.substring(i), s2.substring(0, n - i))) {
              return true;
          }
      }
      return false;
  }

  public static void main(String[] args) {
      String s1 = "great";
      String s2 = "rgeat";
      System.out.println("Is Scramble? " + isScramble(s1, s2));  // Output: true
  }
}
