import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!wordSet.contains(endWord)) return result;

        // Graph to store shortest paths
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        // BFS: Build graph with shortest paths
        bfs(beginWord, endWord, wordSet, graph, distance);

        // DFS: Find all paths using the graph
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, graph, distance, path, result);

        return result;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet, 
                     Map<String, List<String>> graph, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        distance.put(beginWord, 0);

        for (String word : wordSet) graph.put(word, new ArrayList<>());
        graph.put(beginWord, new ArrayList<>());

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;
            
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                int currDist = distance.get(word);

                for (String neighbor : getNeighbors(word, wordSet)) {
                    graph.get(word).add(neighbor);

                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, currDist + 1);
                        if (neighbor.equals(endWord)) foundEnd = true;
                        else queue.add(neighbor);
                    }
                }
            }
            if (foundEnd) break;
        }
    }

    private void dfs(String word, String endWord, Map<String, List<String>> graph, 
                     Map<String, Integer> distance, List<String> path, List<List<String>> result) {
        if (word.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (String neighbor : graph.get(word)) {
            if (distance.get(neighbor) == distance.get(word) + 1) {
                path.add(neighbor);
                dfs(neighbor, endWord, graph, distance, path, result);
                path.remove(path.size() - 1); // Backtrack
            }
        }
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;
                
                chars[i] = c;
                String newWord = new String(chars);
                
                if (wordSet.contains(newWord)) neighbors.add(newWord);
            }
            chars[i] = originalChar; // Restore original character
        }

        return neighbors;
    }

    public static void main(String[] args) {
        WordLadderII solution = new WordLadderII();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit";
        String endWord = "cog";
        
        List<List<String>> result = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(result);
    }
}
