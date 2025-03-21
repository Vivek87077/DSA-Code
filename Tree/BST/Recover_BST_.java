class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int x) {
      val = x;
      left = right = null;
  }
}

public class Recover_BST_ {

  TreeNode first, middle, last, prev;

  public void recoverTree(TreeNode root) {
      first = middle = last = prev = null;
      inorder(root);

      // If two nodes are swapped and are not adjacent
      if (first != null && last != null) {
          swap(first, last);
      } 
      // If two nodes are swapped and are adjacent
      else if (first != null && middle != null) {
          swap(first, middle);
      }
  }

  private void inorder(TreeNode node) {
      if (node == null) return;

      inorder(node.left); // Left subtree

      // Check for misplaced nodes
      if (prev != null && node.val < prev.val) {
          if (first == null) {
              first = prev;  // First wrong node
              middle = node; // Possible second wrong node (if adjacent)
          } else {
              last = node;   // Second wrong node (if non-adjacent)
          }
      }
      prev = node; // Move to next node

      inorder(node.right); // Right subtree
  }

  private void swap(TreeNode a, TreeNode b) {
      int temp = a.val;
      a.val = b.val;
      b.val = temp;
  }

  public static void main(String[] args) {
      // Example: Swapped nodes (3 and 7)
      TreeNode root = new TreeNode(6);
      root.left = new TreeNode(3);
      root.right = new TreeNode(8);
      root.left.left = new TreeNode(2);
      root.left.right = new TreeNode(7); // This should be 3, but is swapped

      Recover_BST_ obj = new Recover_BST_();
      obj.recoverTree(root);

      System.out.println("BST recovered successfully.");
  }
}
