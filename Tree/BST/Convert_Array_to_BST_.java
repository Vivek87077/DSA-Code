class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int x) {
      val = x;
      left = right = null;
  }
}

public class Convert_Array_to_BST_ {
  
  public static TreeNode sortedArrayToBST(int[] nums) {
      if (nums == null || nums.length == 0) return null;
      return constructBST(nums, 0, nums.length - 1);
  }

  private static TreeNode constructBST(int[] nums, int left, int right) {
      if (left > right) return null; // Base case

      int mid = (left + right) / 2; // Select middle element
      TreeNode node = new TreeNode(nums[mid]);

      // Recursively construct left and right subtrees
      node.left = constructBST(nums, left, mid - 1);
      node.right = constructBST(nums, mid + 1, right);

      return node;
  }

  public static void inorderTraversal(TreeNode root) {
      if (root == null) return;
      inorderTraversal(root.left);
      System.out.print(root.val + " ");
      inorderTraversal(root.right);
  }

  public static void main(String[] args) {
      int[] nums = {-10, -3, 0, 5, 9}; // Sorted input array
      TreeNode root = sortedArrayToBST(nums);
      
      System.out.print("Inorder Traversal of BST: ");
      inorderTraversal(root); // Should print the sorted array
  }
}
