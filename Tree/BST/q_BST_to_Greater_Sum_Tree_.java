class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class q_BST_to_Greater_Sum_Tree_ {

    private int greaterSum = 0; // Keeps track of sum of greater nodes

    // Function to transform BST to Greater Sum Tree
    public void convertToGST(TreeNode root) {
        if (root == null) return;

        // Reverse Inorder Traversal: Right -> Root -> Left
        convertToGST(root.right);

        // Update node value and greaterSum
        greaterSum += root.val;
        root.val = greaterSum - root.val; // New node value is sum of greater nodes

        convertToGST(root.left);
    }

    // Helper function for inorder traversal (to check result)
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        // Example BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(8);

        System.out.print("Before conversion (Inorder): ");
        printInorder(root);
        System.out.println();

        // Convert BST to Greater Sum Tree
        q_BST_to_Greater_Sum_Tree_ converter = new q_BST_to_Greater_Sum_Tree_();
        converter.convertToGST(root);

        System.out.print("After conversion (Inorder): ");
        printInorder(root);
        System.out.println();
    }
}
