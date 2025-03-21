public class PalindromeCheck {
  public static boolean isPalindrome(String s) {
      int left = 0, right = s.length() - 1;

      while (left < right) {
          if (s.charAt(left) != s.charAt(right)) {
              return false;
          }
          left++;
          right--;
      }
      return true;
  }

  public static void main(String[] args) {
      System.out.println(isPalindrome("madam"));  // Output: true
      System.out.println(isPalindrome("hello"));  // Output: false
  }
}
