class TreeNode {
  int val;
  TreeNode left, right;
  
  TreeNode(int val) {
      this.val = val;
      left = right = null;
  }
}

public class e_Height_of_Binary_Tree_ {
  
  public static int findHeight(TreeNode root) {
      if (root == null) return 0;
      
      int leftHeight = findHeight(root.left);
      int rightHeight = findHeight(root.right);
      
      return Math.max(leftHeight, rightHeight) + 1;
  }

  public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);

      System.out.println("Height of the Binary Tree: " + findHeight(root));
  }
}
