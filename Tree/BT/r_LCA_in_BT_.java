// Java program to find the Lowest Common Ancestor (LCA) in a Binary Tree
public class r_LCA_in_BT_ {
    
  // Definition of a Tree Node
  static class TreeNode {
      int val;
      TreeNode left, right;
      
      TreeNode(int value) {
          this.val = value;
          this.left = this.right = null;
      }
  }
  
  // Function to find the Lowest Common Ancestor (LCA) of two given nodes
  public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
      // Base Case: If root is null or matches one of the given nodes, return root
      if (root == null || root == p || root == q) {
          return root;
      }
      
      // Recursively find LCA in left and right subtrees
      TreeNode leftLCA = findLCA(root.left, p, q);
      TreeNode rightLCA = findLCA(root.right, p, q);
      
      // If both left and right return non-null, this node is the LCA
      if (leftLCA != null && rightLCA != null) {
          return root;
      }
      
      // Otherwise, return the non-null subtree (either left or right)
      return (leftLCA != null) ? leftLCA : rightLCA;
  }
  
  public static void main(String[] args) {
      // Constructing a sample Binary Tree
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(5);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(6);
      root.left.right = new TreeNode(2);
      root.right.left = new TreeNode(0);
      root.right.right = new TreeNode(8);
      root.left.right.left = new TreeNode(7);
      root.left.right.right = new TreeNode(4);
      
      TreeNode p = root.left; // Node with value 5
      TreeNode q = root.left.right.right; // Node with value 4
      
      // Find and print LCA
      TreeNode lca = findLCA(root, p, q);
      System.out.println("Lowest Common Ancestor: " + (lca != null ? lca.val : "Not Found"));
  }
}
