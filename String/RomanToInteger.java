import java.util.*;

public class RomanToInteger {
    public static int romanToInt(String s) {
        // Step 1: Create a map of Roman numeral values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int result = 0;
        int n = s.length();
        
        // Step 2: Traverse the string
        for (int i = 0; i < n; i++) {
            // Get the value of the current numeral
            int value = romanMap.get(s.charAt(i));
            
            // If the next numeral is greater, subtract current value
            if (i < n - 1 && value < romanMap.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String roman = "MCMXCIV";  // 1994
        System.out.println("Integer: " + romanToInt(roman));  
    }
}
