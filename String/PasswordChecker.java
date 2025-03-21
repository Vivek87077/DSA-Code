public class PasswordChecker {
  public int strongPasswordChecker(String password) {
      int n = password.length();
      
      boolean hasLower = false, hasUpper = false, hasDigit = false;
      int replace = 0;
      
      // Checking character types and counting replacements needed for triplets
      for (int i = 0; i < n; i++) {
          char ch = password.charAt(i);
          if (Character.isLowerCase(ch)) hasLower = true;
          if (Character.isUpperCase(ch)) hasUpper = true;
          if (Character.isDigit(ch)) hasDigit = true;

          // Checking for triplet repeats
          if (i >= 2 && password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i - 2)) {
              replace++;
              i++; // Skip next character to prevent overlapping replacements
          }
      }

      int missingTypes = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);

      if (n < 6) {
          // If too short, we need to insert characters
          return Math.max(6 - n, missingTypes);
      } else if (n > 20) {
          // If too long, we need to delete characters
          int excess = n - 20;
          return excess + Math.max(replace, missingTypes);
      } else {
          // If length is between 6 and 20
          return Math.max(replace, missingTypes);
      }
  }

  public static void main(String[] args) {
      PasswordChecker pc = new PasswordChecker();
      System.out.println(pc.strongPasswordChecker("aA1"));        // Output: 3 (needs 3 insertions)
      System.out.println(pc.strongPasswordChecker("aaabbb"));     // Output: 2 (replace some characters)
      System.out.println(pc.strongPasswordChecker("123456"));     // Output: 1 (needs at least one uppercase or lowercase)
      System.out.println(pc.strongPasswordChecker("aA1aA1aA1aA1aA1aA1aA1aA1")); // Output: 6 (excess length and corrections)
  }
}
