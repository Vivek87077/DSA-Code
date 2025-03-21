class TreeNode {
  int val;
  TreeNode left, right;
  TreeNode(int x) {
      val = x;
      left = right = null;
  }
}

public class Maximum_sum_BST_in_BT_ {

  int maxSum = 0;

  public int maxSumBST(TreeNode root) {
      if (root == null) return 0;
      
      if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
          int sum = sumOfSubtree(root);
          maxSum = Math.max(maxSum, sum);
      }
      
      maxSumBST(root.left);
      maxSumBST(root.right);

      return maxSum;
  }

  private boolean isBST(TreeNode node, int min, int max) {
      if (node == null) return true;
      if (node.val <= min || node.val >= max) return false;
      return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
  }

  private int sumOfSubtree(TreeNode node) {
      if (node == null) return 0;
      return node.val + sumOfSubtree(node.left) + sumOfSubtree(node.right);
  }

  public static void main(String[] args) {
      Maximum_sum_BST_in_BT_ tree = new Maximum_sum_BST_in_BT_();
      
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(3);
      root.right = new TreeNode(5);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(2);
      
      System.out.println("Maximum Sum BST: " + tree.maxSumBST(root));  // Output: 11
  }
}
