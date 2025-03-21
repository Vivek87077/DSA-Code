public class Count_All_Substrings {
  public static int countSubstrings(String s) {
      int n = s.length();
      return (n * (n + 1)) / 2;
  }

  public static void main(String[] args) {
      String s = "abc";
      System.out.println("Total substrings: " + countSubstrings(s));  // Output: 6
  }
}
