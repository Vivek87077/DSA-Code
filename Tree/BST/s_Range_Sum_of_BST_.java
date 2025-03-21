class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class s_Range_Sum_of_BST_ {

    // Function to calculate range sum in BST
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        // If root value is below range, explore right subtree
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        // If root value is above range, explore left subtree
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        // If root is within range, add its value and explore both sides
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
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
        // Constructing BST
        TreeNode root = null;
        int[] values = {10, 5, 15, 3, 7, 18};
        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("BST Inorder: ");
        printInorder(root);
        System.out.println();

        // Range Sum Query
        int low = 7, high = 15;
        s_Range_Sum_of_BST_ solver = new s_Range_Sum_of_BST_();
        int sum = solver.rangeSumBST(root, low, high);

        System.out.println("Range Sum [" + low + ", " + high + "]: " + sum);
    }
}
