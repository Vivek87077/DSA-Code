class TreeNode {
  int val;
  TreeNode left, right;
  
  TreeNode(int val) {
      this.val = val;
      left = right = null;
  }
}

public class f_Binary_Tree_is_balanced_or_not_ {
  
  public static boolean isBalanced(TreeNode root) {
      return checkHeight(root) != -1;
  }

  private static int checkHeight(TreeNode root) {
      if (root == null) return 0;
      
      int leftHeight = checkHeight(root.left);
      if (leftHeight == -1) return -1;
      
      int rightHeight = checkHeight(root.right);
      if (rightHeight == -1) return -1;
      
      if (Math.abs(leftHeight - rightHeight) > 1) return -1;
      
      return Math.max(leftHeight, rightHeight) + 1;
  }

  public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.left.left.left = new TreeNode(6); // Adding extra node to make it unbalanced

      if (isBalanced(root)) {
          System.out.println("The binary tree is balanced.");
      } else {
          System.out.println("The binary tree is not balanced.");
      }
  }
}
