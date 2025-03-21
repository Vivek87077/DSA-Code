class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class j_Construct_a_BST_from_preorder_traversal_ {
    private static int index = 0;

    public static TreeNode constructBST(int[] preorder) {
        index = 0;  // Reset index before building tree
        return buildTree(preorder, Integer.MAX_VALUE);
    }

    private static TreeNode buildTree(int[] preorder, int bound) {
        if (index >= preorder.length || preorder[index] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);

        // Recursively build left and right subtrees with updated bounds
        root.left = buildTree(preorder, root.val);   // Left subtree (values < root)
        root.right = buildTree(preorder, bound);     // Right subtree (values < bound)

        return root;
    }

    // Inorder Traversal (for verification)
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = constructBST(preorder);

        System.out.print("Inorder Traversal of Constructed BST: ");
        inorder(root);  // Should print sorted order: 1 5 7 8 10 12
    }
}

