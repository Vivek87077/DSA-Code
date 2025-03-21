import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        boolean found = false;

        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    result.add(str);
                    found = true;
                }

                if (found) continue; // If valid results found, don't generate more

                // Generate all possible states by removing one parenthesis at a time
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) != '(' && str.charAt(j) != ')') continue;
                    String newStr = str.substring(0, j) + str.substring(j + 1);
                    if (!visited.contains(newStr)) {
                        queue.add(newStr);
                        visited.add(newStr);
                    }
                }
            }
            if (found) break; // Stop BFS if we found valid expressions
        }
        return result;
    }

    // Function to check if a string is valid (balanced parentheses)
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses obj = new RemoveInvalidParentheses();
        String input = "()())()";
        System.out.println("Valid Expressions: " + obj.removeInvalidParentheses(input));
    }
}
