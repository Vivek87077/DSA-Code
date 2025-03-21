import java.util.*;

// Class representing a Node in the binary tree
class TreeNode {
    int val;
    TreeNode left, right;
    
    // Constructor to initialize node value
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class q_Root_to_Node_path_in_BT_ {
    
    // Method to find the path from root to a given node
    public static boolean findPath(TreeNode root, List<Integer> path, int target) {
        // Base case: If root is null, return false
        if (root == null) {
            return false;
        }
        
        // Add current node's value to path
        path.add(root.val);
        
        // If the current node is the target, return true
        if (root.val == target) {
            return true;
        }
        
        // Recursively check left and right subtrees
        if (findPath(root.left, path, target) || findPath(root.right, path, target)) {
            return true;
        }
        
        // If not found in subtree, remove current node from path and return false
        path.remove(path.size() - 1);
        return false;
    }
    
    // Driver method to test the function
    public static void main(String[] args) {
        // Constructing a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        int target = 5; // Node we want to find the path to
        List<Integer> path = new ArrayList<>();
        
        if (findPath(root, path, target)) {
            System.out.println("Path from root to node " + target + ": " + path);
        } else {
            System.out.println("Node not found in the tree");
        }
    }
}