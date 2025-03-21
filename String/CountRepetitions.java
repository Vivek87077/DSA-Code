import java.util.HashMap;
import java.util.Map;

public class CountRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;
        
        @SuppressWarnings("unused")
        int s1_length = s1.length(), s2_length = s2.length();
        int s1_count = 0, s2_count = 0, index = 0;
        
        Map<Integer, int[]> map = new HashMap<>(); // Stores (s2_index → [s1_count, s2_count])
        
        while (s1_count < n1) {
            s1_count++;
            for (char c : s1.toCharArray()) {
                if (c == s2.charAt(index)) {
                    index++;
                    if (index == s2_length) { 
                        s2_count++;
                        index = 0;
                    }
                }
            }
            
            // Detect cycle
            if (map.containsKey(index)) {
                int[] prev = map.get(index);
                int cycle_s1_count = s1_count - prev[0];
                int cycle_s2_count = s2_count - prev[1];

                int remaining_cycles = (n1 - s1_count) / cycle_s1_count;
                s1_count += remaining_cycles * cycle_s1_count;
                s2_count += remaining_cycles * cycle_s2_count;
            } else {
                map.put(index, new int[]{s1_count, s2_count});
            }
        }
        
        return s2_count / n2;
    }

    public static void main(String[] args) {
        CountRepetitions solution = new CountRepetitions();
        System.out.println(solution.getMaxRepetitions("acb", 4, "ab", 2)); // Output: 2
    }
}
