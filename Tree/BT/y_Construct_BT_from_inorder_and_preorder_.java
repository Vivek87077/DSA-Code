// Java program to construct a Binary Tree from given Inorder and Preorder traversals
public class y_Construct_BT_from_inorder_and_preorder_ {

  // Definition for a Tree Node
  static class TreeNode {
      int val;
      TreeNode left, right;

      TreeNode(int value) {
          this.val = value;
          this.left = this.right = null;
      }
  }

  // Index to keep track of the current index in Preorder array
  static int preIndex = 0;

  // Function to build the tree from Inorder and Preorder
  public static TreeNode buildTree(int[] inorder, int[] preorder) {
      return constructTree(preorder, inorder, 0, inorder.length - 1);
  }

  // Recursive function to construct the tree
  private static TreeNode constructTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
      // Base case: If no elements are left in inorder range
      if (inStart > inEnd) return null;

      // Pick the current node from Preorder (preIndex)
      TreeNode node = new TreeNode(preorder[preIndex++]);

      // If this node has no children, return it (Leaf node case)
      if (inStart == inEnd) return node;

      // Find the index of this node in Inorder array
      int inIndex = search(inorder, inStart, inEnd, node.val);

      // Recursively construct left and right subtrees
      node.left = constructTree(preorder, inorder, inStart, inIndex - 1);
      node.right = constructTree(preorder, inorder, inIndex + 1, inEnd);

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
      int[] preorder = {3, 9, 20, 15, 7};

      // Constructing the binary tree
      TreeNode root = buildTree(inorder, preorder);

      // Printing the inorder traversal of the constructed tree
      System.out.print("Inorder traversal of constructed tree: ");
      printInorder(root);
  }
}
