import java.util.Stack;

public class MinBracketReversals {
    public static int minReversals(String s) {
        int n = s.length();
        
        // If length is odd, balancing is impossible
        if (n % 2 == 1) return -1;
        
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                stack.push(ch);
            } else { // ch == '}'
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop(); // Pair matched, remove it
                } else {
                    stack.push(ch); // Unbalanced '}'
                }
            }
        }
        
        // Count remaining unbalanced brackets
        int openCount = 0, closeCount = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() == '{') openCount++;
            else closeCount++;
        }
        
        // Minimum reversals needed
        return (openCount + 1) / 2 + (closeCount + 1) / 2;
    }

    public static void main(String[] args) {
        String s1 = "{{{{";       // Output: 2
        String s2 = "{{{}}}";     // Output: 1
        String s3 = "}{{}}{{{";   // Output: 3
        String s4 = "{{{{}}}}";   // Output: 0
        
        System.out.println(minReversals(s1));
        System.out.println(minReversals(s2));
        System.out.println(minReversals(s3));
        System.out.println(minReversals(s4));
    }
}
