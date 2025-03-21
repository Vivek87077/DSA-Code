import java.util.*;

@SuppressWarnings("unused")
public class ZumaGame {
    public int findMinStep(String board, String hand) {
        int[] count = new int[26]; // Frequency of balls in hand
        for (char c : hand.toCharArray()) count[c - 'A']++;

        int result = dfs(board, count);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(String board, int[] count) {
        if (board.isEmpty()) return 0; // Base case: board is cleared

        int minSteps = Integer.MAX_VALUE;
        
        for (int i = 0; i < board.length(); i++) {
            for (char c = 'A'; c <= 'Z'; c++) {
                if (count[c - 'A'] == 0) continue; // Skip if no balls available
                
                String newBoard = board.substring(0, i) + c + board.substring(i);
                newBoard = eliminate(newBoard); // Remove 3+ consecutive balls
                
                count[c - 'A']--;
                minSteps = Math.min(minSteps, 1 + dfs(newBoard, count));
                count[c - 'A']++; // Backtrack
            }
        }

        return minSteps;
    }

    private String eliminate(String board) {
        int i = 0;
        while (i < board.length()) {
            int j = i;
            while (j < board.length() && board.charAt(j) == board.charAt(i)) j++;

            if (j - i >= 3) { // Found 3+ consecutive balls, remove them
                return eliminate(board.substring(0, i) + board.substring(j));
            }

            i = j;
        }
        return board;
    }

    public static void main(String[] args) {
        ZumaGame zuma = new ZumaGame();
        System.out.println(zuma.findMinStep("WWRRBBWW", "WRBRW")); // Output: 2
        System.out.println(zuma.findMinStep("WRRBBW", "RB")); // Output: -1
    }
}
