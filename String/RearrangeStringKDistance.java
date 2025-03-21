import java.util.*;

public class RearrangeStringKDistance {
    public String rearrangeString(String s, int k) {
        if (k == 0) return s; // No constraint, return original string
        
        List<String> permutations = new ArrayList<>();
        generatePermutations(s.toCharArray(), 0, permutations);

        for (String perm : permutations) {
            if (isValid(perm, k)) {
                return perm;
            }
        }
        return ""; // No valid arrangement found
    }

    private void generatePermutations(char[] arr, int index, List<String> permutations) {
        if (index == arr.length) {
            permutations.add(new String(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            generatePermutations(arr, index + 1, permutations);
            swap(arr, i, index);
        }
    }

    private boolean isValid(String s, int k) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (lastSeen.containsKey(ch) && i - lastSeen.get(ch) < k) {
                return false;
            }
            lastSeen.put(ch, i);
        }
        return true;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        RearrangeStringKDistance obj = new RearrangeStringKDistance();
        String s = "aabbcc";
        int k = 3;
        System.out.println(obj.rearrangeString(s, k));
    }
}
