import java.util.Stack;

public class BasicCalculator {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0, result = 0, sign = 1; // sign = 1 for '+', -1 for '-'

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // Build the number
            } 
            else if (ch == '+' || ch == '-') {
                result += sign * num; // Apply the previous sign to num
                num = 0; // Reset num
                sign = (ch == '+') ? 1 : -1; // Update sign
            } 
            else if (ch == '(') {
                stack.push(result); // Store current result
                stack.push(sign); // Store sign
                result = 0; // Reset result for sub-expression
                sign = 1; // Reset sign for new expression
            } 
            else if (ch == ')') {
                result += sign * num; // Apply last num
                num = 0; // Reset num
                result *= stack.pop(); // Apply the sign before '('
                result += stack.pop(); // Add the stored result before '('
            }
        }

        return result + (sign * num); // Add the last number
    }

    public static void main(String[] args) {
        String expression1 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("Result: " + calculate(expression1)); // Output: 23

        String expression2 = "2 - (1 + 2)";
        System.out.println("Result: " + calculate(expression2)); // Output: -1
    }
}
