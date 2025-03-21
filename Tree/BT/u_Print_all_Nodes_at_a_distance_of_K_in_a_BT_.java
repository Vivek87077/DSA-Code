// Java program to print all nodes at distance K from a given target node in a Binary Tree
import java.util.*;

public class u_Print_all_Nodes_at_a_distance_of_K_in_a_BT_ {
    
    // Definition of a Tree Node
    static class TreeNode {
        int val;
        TreeNode left, right;
        
        TreeNode(int value) {
            this.val = value;
            this.left = this.right = null;
        }
    }
    
    // Step 1: Build Parent References
    public static void markParent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                parentMap.put(current.left, current);  // Mark parent
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);  // Mark parent
                queue.offer(current.right);
            }
        }
    }

    // Step 2: Find nodes at distance K
    public static List<Integer> findNodesAtDistanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || target == null) return result;
        
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParent(root, parentMap);  // Build parent references
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        
        int currentDistance = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentDistance == k) break;
            currentDistance++;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                // Traverse left child
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                
                // Traverse right child
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }
                
                // Traverse parent node
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    visited.add(parentMap.get(node));
                    queue.offer(parentMap.get(node));
                }
            }
        }
        
        // Collect all nodes at distance K
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Constructing a sample Binary Tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode target = root.left; // Target node with value 5
        int k = 2;

        List<Integer> result = findNodesAtDistanceK(root, target, k);
        System.out.println("Nodes at distance " + k + " from target " + target.val + ": " + result);
    }
}
