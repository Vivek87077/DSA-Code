public class b_Find_Min_max_in_BST_ {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
  }

  public static int minValue(TreeNode root) {
    if(root == null) return -1;
    
    while(root.left != null) {
        root = root.left;
    }
    
    return root.val;
  }

  public static void printInOrder(TreeNode root) {
    if (root == null) {
        return;
    }
    printInOrder(root.left);
    System.out.print(root.val + " ");
    printInOrder(root.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(10);

    System.out.println("Binary Search Tree: ");
    printInOrder(root);
    System.out.println();

    int ans = minValue(root);
    System.out.println("The minimum node in the tree: " +ans);
  }


}
