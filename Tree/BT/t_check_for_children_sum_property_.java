// Java program to check if a Binary Tree follows the Children Sum Property
public class t_check_for_children_sum_property_ {
    
  // Definition of a Tree Node
  static class TreeNode {
      int val;
      TreeNode left, right;
      
      TreeNode(int value) {
          this.val = value;
          this.left = this.right = null;
      }
  }

  // Function to check if the tree satisfies the Children Sum Property
  public static boolean checkChildrenSumProperty(TreeNode root) {
      // Base case: If the node is null or a leaf node, return true
      if (root == null || (root.left == null && root.right == null)) {
          return true;
      }

      int leftVal = (root.left != null) ? root.left.val : 0;
      int rightVal = (root.right != null) ? root.right.val : 0;

      // Check if the current node satisfies the property
      if (root.val == leftVal + rightVal) {
          // Recursively check left and right subtrees
          return checkChildrenSumProperty(root.left) && checkChildrenSumProperty(root.right);
      }
      
      return false;
  }

  public static void main(String[] args) {
      // Constructing a sample Binary Tree
      TreeNode root = new TreeNode(10);
      root.left = new TreeNode(8);
      root.right = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(5);
      root.right.right = new TreeNode(2);

      // Check and print whether the tree satisfies the property
      boolean isValid = checkChildrenSumProperty(root);
      System.out.println("Does the tree follow the Children Sum Property? " + isValid);
  }
}
