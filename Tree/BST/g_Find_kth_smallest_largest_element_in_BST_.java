import java.util.*;

public class g_Find_kth_smallest_largest_element_in_BST_ {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
      val = x;
      left = null;
      right = null;
    }
  }

  public static void inorder(TreeNode node, ArrayList<Integer> arr) {
    if (node == null) {
      return;
    }
    inorder(node.left, arr);
    arr.add(node.val);
    inorder(node.right, arr);
    return;
  }

  public static int[] findKth(TreeNode node, int k) {
    int[] ans = new int[2];
    // List to store the
    // elements of the BST
    ArrayList<Integer> arr = new ArrayList<>();
    
    // Perform inorder traversal
    // to populate the vector
    inorder(node, arr);
    
    // Calculate Kth largest
    // and smallest elements
    int kLargest = arr.get(arr.size() - k);
    int kSmallest = arr.get(k - 1); 
    
    // Returning a list containing
    // Kth smallest and largest elements
    ans[0] = kSmallest;
    ans[1] = kLargest;
    return ans;
  }

  public static void printInOrder(TreeNode root) {
    if(root == null){
      return;
    }
    printInOrder(root.left);
    System.out.print(root.val + " ");
    printInOrder(root.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(13);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(2);
    root.left.left.right = new TreeNode(4);
    root.left.right = new TreeNode(6);
    root.left.right.right = new TreeNode(9);
    root.right.left = new TreeNode(11);
    root.right.right = new TreeNode(14);

    System.out.println("Binary Search Tree: ");
    printInOrder(root);
    System.out.println();

    int k = 3;
    System.out.println("k: " + k);

    int[] kthElements = findKth(root, k);

    System.out.println("Kth smallest element: " + kthElements[0]);
    System.out.println("Kth largest element: " + kthElements[1]);
  }
}
