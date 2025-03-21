import java.util.*;

public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> charPositions = new HashMap<>();
        int ringLen = ring.length();

        // Store positions of each character in the ring
        for (int i = 0; i < ringLen; i++) {
            charPositions.computeIfAbsent(ring.charAt(i), k -> new ArrayList<>()).add(i);
        }

        // Memoization map
        Map<String, Integer> memo = new HashMap<>();
        return dfs(0, 0, ringLen, key, charPositions, memo);
    }

    private int dfs(int ringIndex, int keyIndex, int ringLen, String key,
                    Map<Character, List<Integer>> charPositions, Map<String, Integer> memo) {
        if (keyIndex == key.length()) return 0; // All characters matched

        String memoKey = ringIndex + "-" + keyIndex;
        if (memo.containsKey(memoKey)) return memo.get(memoKey);

        char targetChar = key.charAt(keyIndex);
        int minSteps = Integer.MAX_VALUE;

        for (int pos : charPositions.get(targetChar)) {
            int clockwise = Math.abs(ringIndex - pos);
            int counterclockwise = ringLen - clockwise;
            int steps = Math.min(clockwise, counterclockwise) + 1; // Rotation + button press

            int totalSteps = steps + dfs(pos, keyIndex + 1, ringLen, key, charPositions, memo);
            minSteps = Math.min(minSteps, totalSteps);
        }

        memo.put(memoKey, minSteps);
        return minSteps;
    }

    public static void main(String[] args) {
        FreedomTrail trail = new FreedomTrail();
        System.out.println(trail.findRotateSteps("godding", "gd")); // Output: 4
    }
}
