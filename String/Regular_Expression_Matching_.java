public class Regular_Expression_Matching_ {
    public static boolean isMatch(String text, String pattern) {
        // Base cases
        if (pattern.length() == 0) {
            // If the pattern is empty, check if the text is also empty
            return text.length() == 0; // True if both are empty
        }

        boolean firstCharMatched = (text.length() > 0) &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');

        // Handling the '*' wildcard
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // The '*' wildcard can match zero or more characters
            return isMatch(text, pattern.substring(2)) ||
                    (firstCharMatched && isMatch(text.substring(1), pattern));
        } else {
            return firstCharMatched && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isMatch("aa", "a")); // false
        System.out.println(isMatch("aa", "a*")); // true
        System.out.println(isMatch("ab", ".*")); // true
        System.out.println(isMatch("aab", "c*a*b")); // true
        System.out.println(isMatch("mississippi", "mis*is*p*.")); // false
    }
}
