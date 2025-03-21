// Java program to construct a Binary Tree from given Inorder and Postorder traversals
public class z_Construct_BT_from_inorder_and_postorder_ {

  // Definition for a Tree Node
  static class TreeNode {
      int val;
      TreeNode left, right;

      TreeNode(int value) {
          this.val = value;
          this.left = this.right = null;
      }
  }

  // Index to keep track of the current index in Postorder array (starting from last)
  static int postIndex;

  // Function to build the tree from Inorder and Postorder
  public static TreeNode buildTree(int[] inorder, int[] postorder) {
      postIndex = postorder.length - 1; // Start from the last element in postorder
      return constructTree(postorder, inorder, 0, inorder.length - 1);
  }

  // Recursive function to construct the tree
  private static TreeNode constructTree(int[] postorder, int[] inorder, int inStart, int inEnd) {
      // Base case: If no elements are left in inorder range
      if (inStart > inEnd) return null;

      // Pick the current node from Postorder (postIndex)
      TreeNode node = new TreeNode(postorder[postIndex--]);

      // If this node has no children, return it (Leaf node case)
      if (inStart == inEnd) return node;

      // Find the index of this node in Inorder array
      int inIndex = search(inorder, inStart, inEnd, node.val);

      // Recursively construct right and left subtrees (Postorder processes right subtree first)
      node.right = constructTree(postorder, inorder, inIndex + 1, inEnd);
      node.left = constructTree(postorder, inorder, inStart, inIndex - 1);

      return node;
  }

  // Helper function to find an element’s index in Inorder array
  private static int search(int[] inorder, int start, int end, int key) {
      for (int i = start; i <= end; i++) {
          if (inorder[i] == key) return i;
      }
      return -1;  // Should never happen for valid input
  }

  // Function to print the inorder traversal of the constructed tree (for verification)
  public static void printInorder(TreeNode root) {
      if (root == null) return;
      printInorder(root.left);
      System.out.print(root.val + " ");
      printInorder(root.right);
  }

  public static void main(String[] args) {
      // Sample Input
      int[] inorder = {9, 3, 15, 20, 7};
      int[] postorder = {9, 15, 7, 20, 3};

      // Constructing the binary tree
      TreeNode root = buildTree(inorder, postorder);

      // Printing the inorder traversal of the constructed tree
      System.out.print("Inorder traversal of constructed tree: ");
      printInorder(root);
  }
}
