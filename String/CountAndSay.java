public class CountAndSay {
  public static String countAndSay(int n) {
      if (n == 1) return "1"; // Base case

      String result = "1"; // Starting point
      
      for (int i = 2; i <= n; i++) {
          StringBuilder nextTerm = new StringBuilder();
          char[] prevTerm = result.toCharArray();
          int count = 1;
          
          for (int j = 1; j < prevTerm.length; j++) {
              if (prevTerm[j] == prevTerm[j - 1]) {
                  count++; // Count consecutive digits
              } else {
                  nextTerm.append(count).append(prevTerm[j - 1]);
                  count = 1; // Reset count
              }
          }
          nextTerm.append(count).append(prevTerm[prevTerm.length - 1]); // Append last counted group
          result = nextTerm.toString(); // Update result for the next iteration
      }
      
      return result;
  }

  public static void main(String[] args) {
      int n = 5; // Example input
      System.out.println("Count and Say sequence at n = " + n + ": " + countAndSay(n));
  }
}
