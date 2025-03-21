// Java program to find the Maximum Width of a Binary Tree
import java.util.*;

public class s_Maximum_width_of_BT_ {
    
    // Definition of a Tree Node
    static class TreeNode {
        int val;
        TreeNode left, right;
        
        TreeNode(int value) {
            this.val = value;
            this.left = this.right = null;
        }
    }
    
    // Class to store node along with its index in the tree
    static class NodeInfo {
        TreeNode node;
        int index;
        
        NodeInfo(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // Function to calculate the maximum width of the binary tree
    public static int getMaxWidth(TreeNode root) {
        if (root == null) return 0;

        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, 0));  // Root node with index 0
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;  // First node's index at this level
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                NodeInfo current = queue.poll();
                int currIndex = current.index - minIndex;  // Normalize index to prevent overflow
                
                if (i == 0) first = currIndex;  // Leftmost node index
                if (i == size - 1) last = currIndex;  // Rightmost node index
                
                if (current.node.left != null) {
                    queue.offer(new NodeInfo(current.node.left, currIndex * 2 + 1));
                }
                if (current.node.right != null) {
                    queue.offer(new NodeInfo(current.node.right, currIndex * 2 + 2));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        // Constructing a sample Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        // Find and print the maximum width
        int maxWidth = getMaxWidth(root);
        System.out.println("Maximum Width of the Binary Tree: " + maxWidth);
    }
}
