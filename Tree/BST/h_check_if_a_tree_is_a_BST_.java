import java.util.ArrayList;
import java.util.List;

public class h_check_if_a_tree_is_a_BST_ {
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

  public static void printInOrder(TreeNode root) {
    if(root == null){
      return;
    }
    printInOrder(root.left);
    System.out.print(root.val + " ");
    printInOrder(root.right);
  }

  public static void inorderTraversal(TreeNode node, List<Integer> inorderList) {
    if (node == null) return;
    inorderTraversal(node.left, inorderList);
    inorderList.add(node.val);
    inorderTraversal(node.right, inorderList);
  }

  public static boolean isBST_Inorder(TreeNode root) {
    List<Integer> inorderList = new ArrayList<>();
    inorderTraversal(root, inorderList);

    // Check if inorder traversal is strictly increasing
    for (int i = 1; i < inorderList.size(); i++) {
      if (inorderList.get(i) <= inorderList.get(i - 1)) {
        return false;
      }
    }
    return true;
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

    System.out.println("Is BST (Inorder Method): " + isBST_Inorder(root)); 
  }
}
