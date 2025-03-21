import java.util.*;

// Class representing a tree node
class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

// Class to represent a node along with its horizontal distance
class NodeInfo {
    TreeNode node;
    int hd; // Horizontal Distance
    
    public NodeInfo(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class n_Bottom_View_Of_BT {
    
    // Method to print the Bottom View of a Binary Tree
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        // TreeMap stores (horizontal distance -> last seen node value at that distance)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        // Queue for Level Order Traversal (BFS)
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(root, 0));
        
        while (!queue.isEmpty()) {
            NodeInfo temp = queue.poll();
            TreeNode node = temp.node;
            int hd = temp.hd;
            
            // Always update the map with the latest (deepest) node at this horizontal distance
            map.put(hd, node.val);
            
            // If left child exists, push it with hd - 1
            if (node.left != null) {
                queue.add(new NodeInfo(node.left, hd - 1));
            }
            
            // If right child exists, push it with hd + 1
            if (node.right != null) {
                queue.add(new NodeInfo(node.right, hd + 1));
            }
        }
        
        // Collecting values from the map to return as result
        for (int value : map.values()) {
            result.add(value);
        }
        
        return result;
    }
    
    // Main method to test the implementation
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        
        System.out.println("Bottom View of the Binary Tree: " + bottomView(root));
    }
}
