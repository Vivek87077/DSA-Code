import java.util.*;

class LFUCache {
    private int capacity;
    private int size;
    private Map<Integer, ListIterator<int[]>> keyToNode; // key -> reference to list node {key, value, freq}
    private TreeMap<Integer, LinkedList<int[]>> freqMap; // freq -> list of {key, value, freq}

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keyToNode = new HashMap<>();
        this.freqMap = new TreeMap<>();
    }

    private void makeMostFrequentlyUsed(int key) {
        ListIterator<int[]> nodeIterator = keyToNode.get(key);
        int[] node = nodeIterator.next();
        nodeIterator.remove(); // Remove from current frequency list

        int value = node[1];
        int f = node[2];

        if (freqMap.get(f).isEmpty()) {
            freqMap.remove(f);
        }

        f++; // Increase frequency

        freqMap.putIfAbsent(f, new LinkedList<>());
        freqMap.get(f).addFirst(new int[]{key, value, f});
        keyToNode.put(key, freqMap.get(f).listIterator());
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        ListIterator<int[]> nodeIterator = keyToNode.get(key);
        int[] node = nodeIterator.next();
        int value = node[1];

        makeMostFrequentlyUsed(key);
        return value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToNode.containsKey(key)) {
            ListIterator<int[]> nodeIterator = keyToNode.get(key);
            int[] node = nodeIterator.next();
            node[1] = value;
            makeMostFrequentlyUsed(key);
        } else {
            if (size >= capacity) { // Remove LFU element
                int leastFreq = freqMap.firstKey();
                LinkedList<int[]> list = freqMap.get(leastFreq);
                int[] nodeToRemove = list.removeLast(); // Remove least recently used if tie
                if (list.isEmpty()) {
                    freqMap.remove(leastFreq);
                }
                keyToNode.remove(nodeToRemove[0]);
                size--;
            }

            size++;
            freqMap.putIfAbsent(1, new LinkedList<>());
            freqMap.get(1).addFirst(new int[]{key, value, 1});
            keyToNode.put(key, freqMap.get(1).listIterator());
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // LRU key 2 gets removed because 1 is more frequently used
        System.out.println(cache.get(2)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        cache.put(4, 4); // LRU key 1 gets removed
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
