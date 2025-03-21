public class ClosestPalindrome {
  public static boolean isPalindrome(long num) {
      String s = String.valueOf(num);
      int left = 0, right = s.length() - 1;
      while (left < right) {
          if (s.charAt(left++) != s.charAt(right--)) {
              return false;
          }
      }
      return true;
  }

  public static String nearestPalindrome(String n) {
      long num = Long.parseLong(n);
      if (isPalindrome(num)) return n;  // If already a palindrome, return it

      long lower = num - 1;
      long higher = num + 1;

      // Find the closest palindrome
      while (true) {
          if (isPalindrome(lower)) return String.valueOf(lower);
          if (isPalindrome(higher)) return String.valueOf(higher);
          lower--;
          higher++;
      }
  }

  public static void main(String[] args) {
      String n = "123";
      System.out.println("Closest Palindrome: " + nearestPalindrome(n));  // Output: 121
  }
}
