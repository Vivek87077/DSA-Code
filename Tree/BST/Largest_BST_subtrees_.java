class TreeNode {
  int val;
  TreeNode left, right;
  TreeNode(int x) {
      val = x;
      left = right = null;
  }
}

public class Largest_BST_subtrees_ {

  public int largestBSTSubtree(TreeNode root) {
      if (root == null) return 0;
      if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
          return countNodes(root);
      }
      return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
  }

  private boolean isBST(TreeNode node, int min, int max) {
      if (node == null) return true;
      if (node.val <= min || node.val >= max) return false;
      return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
  }

  private int countNodes(TreeNode node) {
      if (node == null) return 0;
      return 1 + countNodes(node.left) + countNodes(node.right);
  }

  public static void main(String[] args) {
      Largest_BST_subtrees_ tree = new Largest_BST_subtrees_();
      
      TreeNode root = new TreeNode(10);
      root.left = new TreeNode(5);
      root.right = new TreeNode(15);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(8);
      root.right.right = new TreeNode(7);

      System.out.println("Size of Largest BST: " + tree.largestBSTSubtree(root)); // Output: 3
  }
}
