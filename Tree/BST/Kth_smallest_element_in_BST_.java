import java.util.ArrayList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int x) {
      val = x;
      left = right = null;
  }
}

public class Kth_smallest_element_in_BST_ {

  public static int kthSmallest(TreeNode root, int k) {
      List<Integer> inorderList = new ArrayList<>();
      
      // Step 1: Perform inorder traversal
      inorderTraversal(root, inorderList);
      
      // Step 2: Get the Kth smallest element (1-based index)
      return inorderList.get(k - 1);
  }

  private static void inorderTraversal(TreeNode node, List<Integer> inorderList) {
      if (node == null) return;
      
      inorderTraversal(node.left, inorderList);  // Left
      inorderList.add(node.val);                 // Root
      inorderTraversal(node.right, inorderList); // Right
  }

  public static void main(String[] args) {
      /* Example BST:
              5
             / \
            3   7
           / \   \
          2   4   8
      */
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(7);
      root.left.left = new TreeNode(2);
      root.left.right = new TreeNode(4);
      root.right.right = new TreeNode(8);

      int k = 3;
      System.out.println("Kth Smallest Element: " + kthSmallest(root, k)); // Output: 4
  }
}
