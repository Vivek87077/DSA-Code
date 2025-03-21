public class ReverseWordsInPlace {
  public static String reverseWords(String s) {
      char[] chars = s.toCharArray();
      int start = 0, end;

      for (int i = 0; i <= chars.length; i++) {
          if (i == chars.length || chars[i] == ' ') {
              end = i - 1;
              reverse(chars, start, end);
              start = i + 1;
          }
      }

      return new String(chars);
  }

  private static void reverse(char[] chars, int left, int right) {
      while (left < right) {
          char temp = chars[left];
          chars[left++] = chars[right];
          chars[right--] = temp;
      }
  }

  public static void main(String[] args) {
      String s = "Hello World";
      System.out.println(reverseWords(s));  // Output: "olleH dlroW"
  }
}
