class a_Search_in_BST_{
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
  }

  public static TreeNode searchBST(TreeNode root, int val) {
    while (root != null && root.val != val) {
        root = val < root.val ? root.left : root.right;
    }
    return root;
  }

  public static void printInOrder(TreeNode root) {
    if (root == null) {
        return;
    }
    printInOrder(root.left);
    System.out.print(root.val + " ");
    printInOrder(root.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(10);
    
    System.out.println("Binary Search Tree: ");
    printInOrder(root);
    System.out.println();

    int target = 6;
    TreeNode result = searchBST(root, target);

    // Displaying the search result
    if (result != null) {
        System.out.println("Value " + target + " found in the BST!");
    } else {
        System.out.println("Value " + target + " not found in the BST.");
    }
  }
}