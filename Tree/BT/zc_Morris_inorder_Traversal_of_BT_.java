public class zc_Morris_inorder_Traversal_of_BT_ {

  // Definition for a Tree Node
  static class TreeNode {
      int val;
      TreeNode left, right;

      TreeNode(int value) {
          this.val = value;
          this.left = this.right = null;
      }
  }

  // Function for Morris Inorder Traversal
  public static void morrisInorder(TreeNode root) {
      TreeNode curr = root;

      while (curr != null) {
          // Case 1: If left subtree is null, print and move right
          if (curr.left == null) {
              System.out.print(curr.val + " "); // Visit the node
              curr = curr.right; // Move to right subtree
          } else {
              // Case 2: Find the inorder predecessor (rightmost node in left subtree)
              TreeNode pred = curr.left;
              while (pred.right != null && pred.right != curr) {
                  pred = pred.right;
              }

              // If thread does not exist, create a temporary thread
              if (pred.right == null) {
                  pred.right = curr; // Create the thread
                  curr = curr.left;  // Move to left subtree
              }
              // If thread exists, remove it and visit the node
              else {
                  pred.right = null; // Remove the thread
                  System.out.print(curr.val + " "); // Visit the node
                  curr = curr.right; // Move to right subtree
              }
          }
      }
  }

  public static void main(String[] args) {
      // Sample Tree
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(7);

      // Perform Morris Inorder Traversal
      System.out.print("Morris Inorder Traversal: ");
      morrisInorder(root);
  }
}
