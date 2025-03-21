class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class r_Minimum_Absolute_Difference_in_BST_ {
    
    private int minDiff = Integer.MAX_VALUE;
    private Integer prev = null; // To track previous node in inorder traversal

    // Function to compute minimum absolute difference
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;

        inorderTraversal(root.left);

        // Compute absolute difference with the previous node
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        }
        prev = root.val; // Update previous node

        inorderTraversal(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    // Helper function to print inorder traversal
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        // Example BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.print("BST Inorder: ");
        printInorder(root);
        System.out.println();

        // Find Minimum Absolute Difference
        r_Minimum_Absolute_Difference_in_BST_ finder = new r_Minimum_Absolute_Difference_in_BST_();
        int minDiff = finder.getMinimumDifference(root);

        System.out.println("Minimum Absolute Difference: " + minDiff);
    }
}
