class TreeNode {
  int val;
  TreeNode left, right;
  
  TreeNode(int val) {
      this.val = val;
      left = right = null;
  }
}

// Helper class to store BST information for each subtree
class BSTInfo {
  int size;  // Size of the largest BST
  int min;   // Minimum value in the subtree
  int max;   // Maximum value in the subtree
  boolean isBST;

  BSTInfo(int size, int min, int max, boolean isBST) {
      this.size = size;
      this.min = min;
      this.max = max;
      this.isBST = isBST;
  }
}

public class o_Largest_BST_in_BT_ {
  
  private static int maxSize = 0; // Track largest BST size

  // Function to find the largest BST in a Binary Tree
  public static BSTInfo findLargestBST(TreeNode root) {
      // Base case: null tree
      if (root == null) return new BSTInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);

      // Recursively get BST info for left and right subtrees
      BSTInfo left = findLargestBST(root.left);
      BSTInfo right = findLargestBST(root.right);

      // Check if current tree is a BST
      if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
          int newSize = left.size + right.size + 1;
          maxSize = Math.max(maxSize, newSize); // Update max BST size
          return new BSTInfo(newSize, Math.min(root.val, left.min), Math.max(root.val, right.max), true);
      }

      // If not a BST, return invalid range and maximum BST size found so far
      return new BSTInfo(Math.max(left.size, right.size), 0, 0, false);
  }

  public static int largestBST(TreeNode root) {
      maxSize = 0;
      findLargestBST(root);
      return maxSize;
  }

  public static void main(String[] args) {
      // Example Binary Tree
      TreeNode root = new TreeNode(10);
      root.left = new TreeNode(5);
      root.right = new TreeNode(15);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(8);
      root.right.right = new TreeNode(7); // This node violates the BST property

      System.out.println("Size of the largest BST: " + largestBST(root));
  }
}
