class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int x) {
      val = x;
      left = right = null;
  }
}

public class Validate_BST_ {

  public static boolean isValidBST(TreeNode root) {
      return isValidBST_Helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private static boolean isValidBST_Helper(TreeNode node, long min, long max) {
      if (node == null) return true; // Base case: empty tree is valid

      if (node.val <= min || node.val >= max) return false; // BST property violated

      // Recursively check left and right subtrees
      return isValidBST_Helper(node.left, min, node.val) && 
             isValidBST_Helper(node.right, node.val, max);
  }

  public static void main(String[] args) {
      // Example: Creating a valid BST
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(7);
      root.left.left = new TreeNode(2);
      root.left.right = new TreeNode(4);
      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(8);

      System.out.println("Is the tree a valid BST? " + isValidBST(root)); // Output: true
  }
}
