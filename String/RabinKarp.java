public class RabinKarp {
  // Function to find occurrences of pattern in text
  public static void search(String text, String pattern, int d, int q) {
      int m = pattern.length();
      int n = text.length();
      int h = 1; // Value of d^(m-1)
      int pHash = 0, tHash = 0; // Hash values for pattern and text window

      // Compute h = d^(m-1) % q
      for (int i = 0; i < m - 1; i++)
          h = (h * d) % q;

      // Compute hash value for pattern and first window of text
      for (int i = 0; i < m; i++) {
          pHash = (d * pHash + pattern.charAt(i)) % q;
          tHash = (d * tHash + text.charAt(i)) % q;
      }

      // Slide the pattern over text one by one
      for (int i = 0; i <= n - m; i++) {
          // If hash values match, check character-by-character
          if (pHash == tHash) {
              boolean match = true;
              for (int j = 0; j < m; j++) {
                  if (text.charAt(i + j) != pattern.charAt(j)) {
                      match = false;
                      break;
                  }
              }
              if (match)
                  System.out.println("Pattern found at index " + i);
          }

          // Compute hash for next window of text
          if (i < n - m) {
              tHash = (d * (tHash - text.charAt(i) * h) + text.charAt(i + m)) % q;
              
              // If we get a negative hash, convert it to positive
              if (tHash < 0)
                  tHash += q;
          }
      }
  }

  public static void main(String[] args) {
      String text = "ABABDABACDABABCABAB";
      String pattern = "ABABCABAB";
      int d = 256; // Number of possible characters
      int q = 101; // A prime number for hashing
      
      search(text, pattern, d, q);
  }
}
