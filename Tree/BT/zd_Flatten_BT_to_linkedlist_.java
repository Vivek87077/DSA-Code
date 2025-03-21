public class zd_Flatten_BT_to_linkedlist_ {

  // Definition for a Tree Node
  static class TreeNode {
      int val;
      TreeNode left, right;

      TreeNode(int value) {
          this.val = value;
          this.left = this.right = null;
      }
  }

  static TreeNode prev = null; // Stores the previous node in reverse preorder

  public static void flatten(TreeNode root) {
      if (root == null) return;

      flatten(root.right);  // Process right subtree first
      flatten(root.left);   // Process left subtree

      root.right = prev;  // Link the current node to the previous node
      root.left = null;   // Set left child to null (linked list property)
      prev = root;        // Move prev pointer to current node
  }

  public static void printFlattenedList(TreeNode root) {
      while (root != null) {
          System.out.print(root.val + " -> ");
          root = root.right;
      }
      System.out.println("NULL");
  }

  public static void main(String[] args) {
      // Sample Tree
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(5);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right.right = new TreeNode(6);

      // Flattening the tree
      flatten(root);

      // Print the flattened list
      System.out.print("Flattened Linked List: ");
      printFlattenedList(root);
  }
}
