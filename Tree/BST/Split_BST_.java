class TreeNode {
  int val;
  TreeNode left, right;
  TreeNode(int x) {
      val = x;
      left = right = null;
  }
}

public class Split_BST_ {
  
  public TreeNode[] splitBST(TreeNode root, int V) {
      if (root == null) return new TreeNode[]{null, null}; // Base case
      
      if (root.val <= V) {
          TreeNode[] split = splitBST(root.right, V); // Split the right subtree
          root.right = split[0]; // Attach the left part of the right subtree
          return new TreeNode[]{root, split[1]}; // Left subtree includes root, Right subtree is split[1]
      } else {
          TreeNode[] split = splitBST(root.left, V); // Split the left subtree
          root.left = split[1]; // Attach the right part of the left subtree
          return new TreeNode[]{split[0], root}; // Left subtree is split[0], Right subtree includes root
      }
  }

  // Inorder Traversal (For Testing)
  public void inorder(TreeNode root) {
      if (root != null) {
          inorder(root.left);
          System.out.print(root.val + " ");
          inorder(root.right);
      }
  }

  public static void main(String[] args) {
      Split_BST_ bst = new Split_BST_();

      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(6);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      root.right.left = new TreeNode(5);
      root.right.right = new TreeNode(7);

      System.out.println("Original BST (Inorder Traversal):");
      bst.inorder(root);
      
      int V = 3;
      TreeNode[] splitTrees = bst.splitBST(root, V);

      System.out.println("\n\nLeft Subtree (≤ " + V + "):");
      bst.inorder(splitTrees[0]);

      System.out.println("\nRight Subtree (> " + V + "):");
      bst.inorder(splitTrees[1]);
  }
}
