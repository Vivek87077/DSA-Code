public class Largest_Odd_Number {
  public static String largestOddNumber(String s) {
      for (int i = s.length() - 1; i >= 0; i--) {
          if ((s.charAt(i) - '0') % 2 == 1) {  // Check if digit is odd
              return s.substring(0, i + 1);
          }
      }
      return ""; // No odd number found
  }

  public static void main(String[] args) {
      System.out.println(largestOddNumber("35427"));  // Output: "35427"
      System.out.println(largestOddNumber("4206"));   // Output: ""
      System.out.println(largestOddNumber("4203"));   // Output: "4203"
  }
}
