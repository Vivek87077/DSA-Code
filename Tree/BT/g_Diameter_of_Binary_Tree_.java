class TreeNode {
  int val;
  TreeNode left, right;

  public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
  }
}

public class g_Diameter_of_Binary_Tree_ {
  private int maxDiameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
      height(root);
      return maxDiameter;
  }

  private int height(TreeNode node) {
      if (node == null) return 0;

      int leftHeight = height(node.left);
      int rightHeight = height(node.right);

      // Update maximum diameter found so far
      maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

      return Math.max(leftHeight, rightHeight) + 1;
  }

  public static void main(String[] args) {
      g_Diameter_of_Binary_Tree_ tree = new g_Diameter_of_Binary_Tree_();
      
      // Creating a sample binary tree
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.right.right = new TreeNode(6);
      root.left.right.left = new TreeNode(7);

      System.out.println("Diameter of the Binary Tree: " + tree.diameterOfBinaryTree(root));
  }
}
