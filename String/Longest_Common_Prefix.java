public class Longest_Common_Prefix {
  public static String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) return "";

      for (int i = 0; i < strs[0].length(); i++) {
          char c = strs[0].charAt(i); // Pick character from the first string

          for (int j = 1; j < strs.length; j++) {
              // If out of bounds or mismatch occurs, return prefix so far
              if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                  return strs[0].substring(0, i);
              }
          }
      }
      return strs[0]; // All characters matched
  }

  public static void main(String[] args) {
      String[] strs1 = {"flower", "flow", "flight"};
      System.out.println(longestCommonPrefix(strs1)); // Output: "fl"

      String[] strs2 = {"dog", "racecar", "car"};
      System.out.println(longestCommonPrefix(strs2)); // Output: ""
  }
}
