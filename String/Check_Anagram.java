public class Check_Anagram {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[256]; // Frequency array for all ASCII characters

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;  // Increment for s1
            freq[s2.charAt(i)]--;  // Decrement for s2
        }

        // If all values in freq[] are zero, they are anagrams
        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));  // Output: true
        System.out.println(isAnagram("rat", "car"));  // Output: false
        System.out.println(isAnagram("anagram", "nagaram"));  // Output: true
    }
}
