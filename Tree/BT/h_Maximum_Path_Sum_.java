class TreeNode {
  int val;
  TreeNode left, right;

  public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
  }
}

public class h_Maximum_Path_Sum_ {
  private int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
      findMaxPath(root);
      return maxSum;
  }

  private int findMaxPath(TreeNode node) {
      if (node == null) return 0;

      // Recursively calculate max path sum for left and right subtrees
      int leftMax = Math.max(0, findMaxPath(node.left));  // Ignore negative sums
      int rightMax = Math.max(0, findMaxPath(node.right));

      // Compute max sum at current node (including both left & right subtrees)
      int currentSum = node.val + leftMax + rightMax;

      // Update global max sum
      maxSum = Math.max(maxSum, currentSum);

      // Return max single path sum (node + max(left, right))
      return node.val + Math.max(leftMax, rightMax);
  }

  public static void main(String[] args) {
      h_Maximum_Path_Sum_ tree = new h_Maximum_Path_Sum_();
      
      // Creating a sample binary tree
      TreeNode root = new TreeNode(-10);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);

      System.out.println("Maximum Path Sum: " + tree.maxPathSum(root));
  }
}
