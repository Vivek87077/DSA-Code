class TreeNode {
  int val;
  TreeNode left, right;

  public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
  }
}

public class i_Check_two_trees_are_identical_ {
  public static boolean isIdentical(TreeNode root1, TreeNode root2) {
    // Base Cases
    if (root1 == null && root2 == null) return true;  // Both trees are empty
    if (root1 == null || root2 == null) return false; // One is empty, the other is not

    // Check current node values and recursively check left and right subtrees
    return (root1.val == root2.val) &&
            isIdentical(root1.left, root2.left) &&
            isIdentical(root1.right, root2.right);
  }

  public static void main(String[] args) {

      // Creating two sample identical binary trees
      TreeNode root1 = new TreeNode(1);
      root1.left = new TreeNode(2);
      root1.right = new TreeNode(3);
      root1.left.left = new TreeNode(4);
      root1.left.right = new TreeNode(5);

      TreeNode root2 = new TreeNode(1);
      root2.left = new TreeNode(2);
      root2.right = new TreeNode(3);
      root2.left.left = new TreeNode(4);
      root2.left.right = new TreeNode(5);

      System.out.println("Are the two trees identical? " + isIdentical(root1, root2));
  }
}
