import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class u_Find_Mode_in_Binary_Search_Tree_ {
    private int maxCount = 0;    // Stores highest frequency
    private int count = 0;       // Current frequency count
    private Integer prev = null; // Previous node value
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        // Inorder traversal (Left -> Node -> Right)
        inorder(node.left);

        // Processing the current node
        if (prev != null && prev == node.val) {
            count++; // Increment frequency if value repeats
        } else {
            count = 1; // Reset count for new value
        }
        prev = node.val; // Update previous value

        // Update modes if needed
        if (count > maxCount) {
            maxCount = count;
            modes.clear();
            modes.add(node.val);
        } else if (count == maxCount) {
            modes.add(node.val);
        }

        inorder(node.right);
    }

    // Helper function to insert nodes into BST
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    // Helper function to print inorder traversal
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        // Construct BST
        TreeNode root = null;
        int[] values = {1, 2, 2}; // BST with duplicate values
        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("BST Inorder: ");
        printInorder(root);
        System.out.println();

        // Find mode(s)
        u_Find_Mode_in_Binary_Search_Tree_ finder = new u_Find_Mode_in_Binary_Search_Tree_();
        int[] modes = finder.findMode(root);

        System.out.println("Mode(s) in BST: " + Arrays.toString(modes));
    }
}
