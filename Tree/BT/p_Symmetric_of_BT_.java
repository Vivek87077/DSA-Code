class TreeNode {
  int val;
  TreeNode left, right;
  
  public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
  }
}

public class p_Symmetric_of_BT_ {
  
  // Function to check if a tree is symmetric
  public static boolean isSymmetric(TreeNode root) {
      if (root == null) return true;
      return isMirror(root.left, root.right);
  }
  
  // Helper function to check if two subtrees are mirror images
  private static boolean isMirror(TreeNode t1, TreeNode t2) {
      if (t1 == null && t2 == null) return true;
      if (t1 == null || t2 == null) return false;
      
      // Check if current nodes are equal and their subtrees are mirrors
      return (t1.val == t2.val) 
          && isMirror(t1.left, t2.right) 
          && isMirror(t1.right, t2.left);
  }
  
  // Main method to test the implementation
  public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);
      
      System.out.println("Is the tree symmetric? " + isSymmetric(root));
  }
}