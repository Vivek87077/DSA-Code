public class ZFunctionBruteForce {
  public static int[] computeZ(String s) {
      int n = s.length();
      int[] Z = new int[n];

      for (int i = 1; i < n; i++) {
          while (i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i])) {
              Z[i]++;
          }
      }
      return Z;
  }

  public static void main(String[] args) {
      String s = "aaabaab";
      int[] Z = computeZ(s);
      
      // Print Z-array
      for (int val : Z) {
          System.out.print(val + " ");
      }
  }
}
