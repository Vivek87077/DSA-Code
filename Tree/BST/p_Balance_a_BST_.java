import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class p_Balance_a_BST_ {
    
    // Step 1: Store inorder traversal (sorted elements)
    private void inorderTraversal(TreeNode root, List<Integer> sortedList) {
        if (root == null) return;
        inorderTraversal(root.left, sortedList);
        sortedList.add(root.val);
        inorderTraversal(root.right, sortedList);
    }

    // Step 2: Build a balanced BST from sorted array
    private TreeNode buildBalancedBST(List<Integer> sortedList, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(sortedList.get(mid));

        root.left = buildBalancedBST(sortedList, start, mid - 1);
        root.right = buildBalancedBST(sortedList, mid + 1, end);

        return root;
    }

    // Function to balance a BST
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        inorderTraversal(root, sortedList);
        return buildBalancedBST(sortedList, 0, sortedList.size() - 1);
    }

    // Helper function to print inorder traversal of BST
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        // Unbalanced BST
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);

        System.out.print("Before balancing: ");
        printInorder(root);
        System.out.println();

        // Balance BST
        p_Balance_a_BST_ bstBalancer = new p_Balance_a_BST_();
        root = bstBalancer.balanceBST(root);

        System.out.print("After balancing: ");
        printInorder(root);
        System.out.println();
    }
}
