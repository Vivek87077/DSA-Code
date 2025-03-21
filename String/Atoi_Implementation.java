public class Atoi_Implementation {
  public static int myAtoi(String s) {
      // Step 1: Handle empty string
      if (s == null || s.length() == 0) return 0;

      int i = 0, n = s.length(), sign = 1, result = 0;
      
      // Step 2: Ignore leading spaces
      while (i < n && s.charAt(i) == ' ') {
          i++;
      }
      
      // Step 3: Handle sign (+ or -)
      if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
          sign = (s.charAt(i) == '-') ? -1 : 1;
          i++;
      }

      // Step 4: Process numeric characters
      while (i < n && Character.isDigit(s.charAt(i))) {
          int digit = s.charAt(i) - '0';
          
          // Step 5: Handle integer overflow
          if (result > (Integer.MAX_VALUE - digit) / 10) {
              return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
          }
          
          result = result * 10 + digit;
          i++;
      }

      return result * sign;
  }

  public static void main(String[] args) {
      System.out.println(myAtoi("42"));          // Output: 42
      System.out.println(myAtoi("   -42"));      // Output: -42
      System.out.println(myAtoi("4193 with words")); // Output: 4193
      System.out.println(myAtoi("words and 987"));   // Output: 0
      System.out.println(myAtoi("-91283472332"));    // Output: -2147483648 (Integer.MIN_VALUE)
  }
}
