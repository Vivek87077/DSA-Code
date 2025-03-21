import java.util.*;

public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> countMap = new HashMap<>();
        int i = 0, n = formula.length();

        while (i < n) {
            char ch = formula.charAt(i);

            if (ch == '(') {
                stack.push(countMap);  // Save current map on stack
                countMap = new HashMap<>();
                i++;

            } else if (ch == ')') {
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplier = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;

                if (!stack.isEmpty()) {
                    Map<String, Integer> prevMap = stack.pop();
                    for (String atom : countMap.keySet()) {
                        prevMap.put(atom, prevMap.getOrDefault(atom, 0) + countMap.get(atom) * multiplier);
                    }
                    countMap = prevMap;
                }

            } else {
                int start = i;
                i++;  // Move past the first capital letter
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String atom = formula.substring(start, i);

                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;

                countMap.put(atom, countMap.getOrDefault(atom, 0) + count);
            }
        }

        // Sort and build the result
        StringBuilder result = new StringBuilder();
        TreeMap<String, Integer> sortedMap = new TreeMap<>(countMap);
        for (String atom : sortedMap.keySet()) {
            result.append(atom);
            if (sortedMap.get(atom) > 1) {
                result.append(sortedMap.get(atom));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        NumberOfAtoms solution = new NumberOfAtoms();
        System.out.println(solution.countOfAtoms("Mg(OH)2")); // Expected: "H2MgO2"
        System.out.println(solution.countOfAtoms("K4(ON(SO3)2)2")); // Expected: "K4N2O14S4"
    }
}
