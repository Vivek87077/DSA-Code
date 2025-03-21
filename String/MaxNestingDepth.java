public class MaxNestingDepth {
  public static int maxDepth(String s) {
      int maxDepth = 0, currentDepth = 0;
      
      for (char c : s.toCharArray()) {
          if (c == '(') {
              currentDepth++;
              maxDepth = Math.max(maxDepth, currentDepth);
          } else if (c == ')') {
              currentDepth--;
          }
      }
      
      return maxDepth;
  }

  public static void main(String[] args) {
      String s = "(1)+((2))+(((3)))";
      System.out.println("Maximum Depth: " + maxDepth(s)); // Output: 3
  }
}
