// Java program to find the minimum time to burn the entire Binary Tree from a given target node
import java.util.*;

public class v_Min_time_taken_to_BURN_the_BT_from_a_node_ {
    
    // Definition of a Tree Node
    static class Node {
        int val;
        Node left, right;
        
        Node(int value) {
            this.val = value;
            this.left = this.right = null;
        }
    }

    // Step 1: Build Parent References
    public static void markParent(Node root, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                parentMap.put(current.left, current); // Mark parent
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current); // Mark parent
                queue.offer(current.right);
            }
        }
    }

    // Step 2: Perform BFS to find min time to burn the tree
    public static int minTimeToBurnTree(Node root, Node target) {
        if (root == null || target == null) return 0;

        Map<Node, Node> parentMap = new HashMap<>();
        markParent(root, parentMap); // Store parent references

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;
            
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                // Burn left child
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                    burned = true;
                }

                // Burn right child
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                    burned = true;
                }

                // Burn parent node
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    visited.add(parentMap.get(node));
                    queue.offer(parentMap.get(node));
                    burned = true;
                }
            }

            if (burned) time++; // Increment time only if at least one node is burned in this level
        }
        
        return time;
    }

    public static void main(String[] args) {
        // Constructing a sample Binary Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        Node target = root.left.right; // Target node with value 5

        int burnTime = minTimeToBurnTree(root, target);
        System.out.println("Minimum time to burn the tree from target node " + target.val + ": " + burnTime);
    }
}
