class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class t_Trim_a_BST_ {

    // Function to trim the BST within range [low, high]
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        // If root is smaller than low, trim left subtree
        if (root.val < low) return trimBST(root.right, low, high);

        // If root is greater than high, trim right subtree
        if (root.val > high) return trimBST(root.left, low, high);

        // If within range, trim left and right subtrees
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
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
        int[] values = {3, 0, 4, 2, 1};
        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("Original BST (Inorder): ");
        printInorder(root);
        System.out.println();

        // Trim BST to range [1, 3]
        int low = 1, high = 3;
        t_Trim_a_BST_ trimmer = new t_Trim_a_BST_();
        TreeNode trimmedRoot = trimmer.trimBST(root, low, high);

        System.out.print("Trimmed BST (Inorder): ");
        printInorder(trimmedRoot);
        System.out.println();
    }
}
