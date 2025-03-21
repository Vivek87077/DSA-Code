import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class k_Boundary_Traversal_of_BT_ {

    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        if (!isLeaf(root)) result.add(root.val);  // Add root if it's not a leaf

        addLeftBoundary(root.left, result);
        addLeafNodes(root, result);
        addRightBoundary(root.right, result);

        return result;
    }

    private static void addLeftBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) result.add(node.val); 
            node = (node.left != null) ? node.left : node.right;  // Move downwards
        }
    }

    private static void addLeafNodes(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }
        addLeafNodes(node.left, result);
        addLeafNodes(node.right, result);
    }

    private static void addRightBoundary(TreeNode node, List<Integer> result) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.val);
            node = (node.right != null) ? node.right : node.left;  // Move downwards
        }
        while (!stack.isEmpty()) result.add(stack.pop()); // Reverse order
    }

    private static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);

        System.out.println("Boundary Traversal: " + boundaryTraversal(root));
    }
}
