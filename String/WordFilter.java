public class WordFilter{
  private String[] words;

  public WordFilter(String[] words) {
      this.words = words; // Store words in an array
  }

  public int f(String prefix, String suffix) {
      int index = -1; // Default index if no match is found
      for (int i = 0; i < words.length; i++) {
          String word = words[i];
          if (word.startsWith(prefix) && word.endsWith(suffix)) {
              index = i; // Update index if found
          }
      }
      return index;
  }

  public static void main(String[] args) {
      String[] words = {"apple", "banana", "application", "ape", "apply"};
      WordFilter wordFilter = new WordFilter(words);

      System.out.println(wordFilter.f("app", "e"));  // Output: 4 (apply)
      System.out.println(wordFilter.f("ban", "a"));  // Output: 1 (banana)
      System.out.println(wordFilter.f("xyz", "z"));  // Output: -1 (not found)
  }
}
