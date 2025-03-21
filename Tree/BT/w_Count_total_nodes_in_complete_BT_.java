// Java program to count the total number of nodes in a Complete Binary Tree efficiently
public class w_Count_total_nodes_in_complete_BT_ {

  // Definition of a Tree Node
  static class TreeNode {
      int val;
      TreeNode left, right;

      TreeNode(int value) {
          this.val = value;
          this.left = this.right = null;
      }
  }

  // Function to calculate the depth of the leftmost path
  private static int getLeftDepth(TreeNode node) {
      int depth = 0;
      while (node != null) {
          depth++;
          node = node.left;
      }
      return depth;
  }

  // Function to calculate the depth of the rightmost path
  private static int getRightDepth(TreeNode node) {
      int depth = 0;
      while (node != null) {
          depth++;
          node = node.right;
      }
      return depth;
  }

  // Function to count nodes in a complete binary tree
  public static int countNodes(TreeNode root) {
      if (root == null) return 0;

      int leftDepth = getLeftDepth(root);
      int rightDepth = getRightDepth(root);

      // If left depth == right depth, it's a perfect tree, use formula 2^depth - 1
      if (leftDepth == rightDepth) {
          return (1 << leftDepth) - 1;  // 2^depth - 1
      }

      // Otherwise, recursively count nodes in left and right subtrees
      return 1 + countNodes(root.left) + countNodes(root.right);
  }

  public static void main(String[] args) {
      // Constructing a sample Complete Binary Tree
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.right.left = new TreeNode(6);

      int totalNodes = countNodes(root);
      System.out.println("Total number of nodes in the complete binary tree: " + totalNodes);
  }
}
