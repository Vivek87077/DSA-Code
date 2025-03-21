class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int val) {
      this.val = val;
      left = right = null;
  }
}

public class i_LCA_in_BST_ {
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null) return null;

      // If both nodes are smaller, move left
      if (p.val < root.val && q.val < root.val) {
          return lowestCommonAncestor(root.left, p, q);
      }

      // If both nodes are larger, move right
      if (p.val > root.val && q.val > root.val) {
          return lowestCommonAncestor(root.right, p, q);
      }

      // If one node is on the left and the other is on the right, root is LCA
      return root;
  }

  public static void main(String[] args) {
      TreeNode root = new TreeNode(6);
      root.left = new TreeNode(2);
      root.right = new TreeNode(8);
      root.left.left = new TreeNode(0);
      root.left.right = new TreeNode(4);
      root.right.left = new TreeNode(7);
      root.right.right = new TreeNode(9);
      root.left.right.left = new TreeNode(3);
      root.left.right.right = new TreeNode(5);

      TreeNode p = root.left;  // Node 2
      TreeNode q = root.left.right;  // Node 4

      TreeNode lca = lowestCommonAncestor(root, p, q);
      System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);
  }
}
