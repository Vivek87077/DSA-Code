class TreeNode {
  int val;
  TreeNode left, right;
  TreeNode(int x) {
      val = x;
      left = right = null;
  }
}

public class Insert_into_BST_ {

  public TreeNode insertIntoBST(TreeNode root, int val) {
      if (root == null) return new TreeNode(val); // Base case: Insert new node
      
      if (val < root.val) {
          root.left = insertIntoBST(root.left, val);  // Insert in left subtree
      } else {
          root.right = insertIntoBST(root.right, val); // Insert in right subtree
      }
      return root;  // Return updated root
  }

  public void inorder(TreeNode root) {
      if (root != null) {
          inorder(root.left);
          System.out.print(root.val + " ");
          inorder(root.right);
      }
  }

  public static void main(String[] args) {
      Insert_into_BST_ bst = new Insert_into_BST_();
      
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(7);

      System.out.println("Before insertion (Inorder Traversal):");
      bst.inorder(root);

      root = bst.insertIntoBST(root, 4);  // Inserting value 4

      System.out.println("\nAfter insertion (Inorder Traversal):");
      bst.inorder(root);
  }
}
