import java.util.HashMap;

public class Isomorphic_Strings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            // Check forward mapping (s -> t)
            if (mapST.containsKey(chS)) {
                if (mapST.get(chS) != chT) return false;
            } else {
                mapST.put(chS, chT);
            }

            // Check reverse mapping (t -> s)
            if (mapTS.containsKey(chT)) {
                if (mapTS.get(chT) != chS) return false;
            } else {
                mapTS.put(chT, chS);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));  // Output: true
        System.out.println(isIsomorphic("foo", "bar"));  // Output: false
        System.out.println(isIsomorphic("paper", "title"));  // Output: true
    }
}
