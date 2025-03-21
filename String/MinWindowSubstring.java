public class MinWindowSubstring {
  public static String minWindow(String s, String t) {
      int minLen = Integer.MAX_VALUE;
      String result = "";

      for (int i = 0; i < s.length(); i++) {
          for (int j = i; j < s.length(); j++) {
              String sub = s.substring(i, j + 1);
              if (containsAll(sub, t)) {
                  if (sub.length() < minLen) {
                      minLen = sub.length();
                      result = sub;
                  }
              }
          }
      }
      return result;
  }

  // Helper function to check if substring contains all characters of t
  private static boolean containsAll(String sub, String t) {
      int[] subFreq = new int[128]; // ASCII
      int[] tFreq = new int[128];

      for (char c : t.toCharArray()) {
          tFreq[c]++;
      }

      for (char c : sub.toCharArray()) {
          subFreq[c]++;
      }

      for (char c : t.toCharArray()) {
          if (subFreq[c] < tFreq[c]) return false;
      }
      return true;
  }

  public static void main(String[] args) {
      String s = "ADOBECODEBANC";
      String t = "ABC";
      System.out.println("Minimum window substring: " + minWindow(s, t));
  }
}
