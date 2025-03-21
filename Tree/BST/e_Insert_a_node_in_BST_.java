public class e_Insert_a_node_in_BST_ {
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
  
  public static TreeNode insertIntoBST(TreeNode root, int key) {
    if(root == null) return new TreeNode(key);

    if(root.val < key){
      root.right = insertIntoBST(root.right, key);
    }
    else{
      root.left = insertIntoBST(root.left, key);
    }
    return root;
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

    System.out.println("Binary Search Tree before insertion: ");
    printInOrder(root);
    System.out.println();

    int val = 7;
    insertIntoBST(root, val);
    printInOrder(root);
  }
}
