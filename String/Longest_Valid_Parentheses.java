import java.util.Stack;
import java.util.Scanner;

public class Longest_Valid_Parentheses{
    public static int helper(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1); // Base index to handle edge cases
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop(); // Pop the last index
                
                if (st.isEmpty()) {
                    st.push(i); // Push current index as a new base
                } else {
                    maxLength = Math.max(maxLength, i - st.peek());
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string of parentheses: ");
        String s = scanner.nextLine();
        
        int result = helper(s);
        
        System.out.println("Longest valid parentheses length: " + result);
        
        scanner.close();
    }
}
