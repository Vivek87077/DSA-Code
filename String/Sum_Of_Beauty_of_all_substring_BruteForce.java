public class Sum_Of_Beauty_of_all_substring_BruteForce {
    public static int beautySum(String s) {
        int totalBeauty = 0;
        int n = s.length();

        // Generate all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                totalBeauty += calculateBeauty(s.substring(i, j + 1));
            }
        }

        return totalBeauty;
    }

    private static int calculateBeauty(String sub) {
        int[] freq = new int[26];
        for (char c : sub.toCharArray()) {
            freq[c - 'a']++;
        }

        int minFreq = Integer.MAX_VALUE, maxFreq = 0;
        for (int count : freq) {
            if (count > 0) {
                minFreq = Math.min(minFreq, count);
                maxFreq = Math.max(maxFreq, count);
            }
        }
        return maxFreq - minFreq;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println("Total Sum of Beauty: " + beautySum(s));  // Output: 5
    }
}
