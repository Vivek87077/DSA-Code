import java.util.*;

public class Sort_Characters_By_Frequency_BruteForce {
    public static String frequencySort(String s) {
        // Step 1: Count frequency of each character
        int[] freq = new int[128];  // Assuming ASCII characters
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        // Step 2: Store characters in a list
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                chars.add((char) i);
            }
        }

        // Step 3: Sort the list based on frequency (Bubble Sort for brute force)
        for (int i = 0; i < chars.size(); i++) {
            for (int j = i + 1; j < chars.size(); j++) {
                if (freq[chars.get(i)] < freq[chars.get(j)]) {
                    // Swap characters based on frequency
                    Collections.swap(chars, i, j);
                }
            }
        }

        // Step 4: Construct the output string
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            result.append(String.valueOf(c).repeat(freq[c])); // Append char 'freq[c]' times
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));  // Output: "eert" or "eetr"
    }
}
