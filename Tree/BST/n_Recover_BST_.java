class TreeNode {
  int val;
  TreeNode left, right;
  
  TreeNode(int val) {
      this.val = val;
      left = right = null;
  }
}

public class n_Recover_BST_ {
  
  private TreeNode first, second, prev;
  
  // Inorder traversal to detect swapped nodes
  private void inorder(TreeNode root) {
      if (root == null) return;

      inorder(root.left);

      // Detect swapped nodes
      if (prev != null && root.val < prev.val) {
          if (first == null) first = prev; // First misplaced node
          second = root; // Second misplaced node
      }
      prev = root;

      inorder(root.right);
  }

  // Function to fix the BST by swapping back misplaced values
  public void recoverTree(TreeNode root) {
      first = second = prev = null;

      // Find the two swapped nodes
      inorder(root);

      // Swap values to correct BST
      if (first != null && second != null) {
          int temp = first.val;
          first.val = second.val;
          second.val = temp;
      }
  }

  // Inorder traversal to print BST
  public static void printInorder(TreeNode root) {
      if (root == null) return;
      printInorder(root.left);
      System.out.print(root.val + " ");
      printInorder(root.right);
  }

  public static void main(String[] args) {
      // Construct a BST with swapped nodes
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(1);
      root.right = new TreeNode(4);
      root.right.left = new TreeNode(2); // Swapped node (2 should be left of 3)

      System.out.print("Before recovery: ");
      printInorder(root);
      System.out.println();

      // Recover BST
      n_Recover_BST_ bstFixer = new n_Recover_BST_();
      bstFixer.recoverTree(root);

      System.out.print("After recovery: ");
      printInorder(root);
      System.out.println();
  }
}
