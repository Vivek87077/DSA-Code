import java.util.*;

public class ExpressionAddOperatorsBruteForce {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        generateExpressions(num, "", 0, target, result);
        return result;
    }

    private void generateExpressions(String num, String expression, int index, int target, List<String> result) {
        if (index == num.length()) {
            if (evaluate(expression) == target) {
                result.add(expression);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            String part = num.substring(index, i + 1);

            // Prevent numbers with leading zeros (e.g., "05" is invalid)
            if (part.length() > 1 && part.charAt(0) == '0') break;

            if (index == 0) {
                // First number (No operator needed)
                generateExpressions(num, part, i + 1, target, result);
            } else {
                generateExpressions(num, expression + "+" + part, i + 1, target, result);
                generateExpressions(num, expression + "-" + part, i + 1, target, result);
                generateExpressions(num, expression + "*" + part, i + 1, target, result);
            }
        }
    }

    private int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (!Character.isDigit(c) || i == expression.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                sign = c;
                num = 0;
            }
        }

        int result = 0;
        for (int val : stack) {
            result += val;
        }
        return result;
    }

    public static void main(String[] args) {
        ExpressionAddOperatorsBruteForce solver = new ExpressionAddOperatorsBruteForce();
        System.out.println(solver.addOperators("123", 6));  // Output: ["1+2+3", "1*2*3"]
        System.out.println(solver.addOperators("232", 8));  // Output: ["2*3+2", "2+3*2"]
        System.out.println(solver.addOperators("105", 5));  // Output: ["1*0+5", "10-5"]
    }
}
