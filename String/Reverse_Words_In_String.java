public class Reverse_Words_In_String {
  public static String reverseWords(String s) {
      String[] words = s.trim().split("\\s+"); // Split by spaces
      StringBuilder result = new StringBuilder();

      for (int i = words.length - 1; i >= 0; i--) {
          result.append(words[i]).append(" ");
      }

      return result.toString().trim();
  }

  public static void main(String[] args) {
      String s = "I love coding";
      System.out.println(reverseWords(s));  // Output: "coding love I"
  }
}
