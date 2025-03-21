public class Count_no_of_Unique_BST_ {

  // Recursive function to count unique BSTs
  public static int countBST_Recursive(int n) {
      if (n == 0 || n == 1) return 1; // Base cases
      
      int count = 0;
      for (int i = 1; i <= n; i++) {
          count += countBST_Recursive(i - 1) * countBST_Recursive(n - i);
      }
      return count;
  }

  public static void main(String[] args) {
      int n = 5; // Example input
      System.out.println("Using Recursion: " + countBST_Recursive(n));
  }
}
