class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
      val = x;
      next = null;
  }
}

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int x) {
      val = x;
      left = right = null;
  }
}

public class Convert_Sorted_list_to_BST_ {

  public static TreeNode sortedListToBST(ListNode head) {
      if (head == null) return null;

      // Step 1: Convert Linked List to ArrayList
      ListNode temp = head;
      int size = 0;
      while (temp != null) {
          size++;
          temp = temp.next;
      }

      int[] nums = new int[size];
      temp = head;
      for (int i = 0; i < size; i++) {
          nums[i] = temp.val;
          temp = temp.next;
      }

      // Step 2: Convert Sorted Array to BST
      return constructBST(nums, 0, size - 1);
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

  // Inorder Traversal to Print BST
  public static void inorderTraversal(TreeNode root) {
      if (root == null) return;
      inorderTraversal(root.left);
      System.out.print(root.val + " ");
      inorderTraversal(root.right);
  }

  public static void main(String[] args) {
      // Creating a sorted linked list: -10 -> -3 -> 0 -> 5 -> 9
      ListNode head = new ListNode(-10);
      head.next = new ListNode(-3);
      head.next.next = new ListNode(0);
      head.next.next.next = new ListNode(5);
      head.next.next.next.next = new ListNode(9);

      TreeNode root = sortedListToBST(head);

      System.out.print("Inorder Traversal of BST: ");
      inorderTraversal(root); // Output should be: -10 -3 0 5 9
  }
}
