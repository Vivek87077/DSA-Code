public class f_Delete_a_node_in_BST_ {
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
  
  public static TreeNode findMin(TreeNode root) {
    while (root.left != null) {
        root = root.left;
    }
    return root;
  }

  public static TreeNode deleteFromBST(TreeNode root, int key) {
    if(root == null) return null;

    if(root.val > key){
      root.left = deleteFromBST(root.left, key);
    }
    else if(root.val < key){
        root.right = deleteFromBST(root.right, key);
    }
    else{
      if (root.left == null && root.right == null) {
        return null;
      }
      else if (root.left == null) {
        return root.right;
      }
      else if (root.right == null) {
        return root.left;
      }
      else {
        TreeNode successor = findMin(root.right);
        root.val = successor.val; 
        root.right = deleteFromBST(root.right, successor.val); 
      }
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

    System.out.println("Binary Search Tree before deletion: ");
    printInOrder(root);
    System.out.println();

    int val = 8;
    deleteFromBST(root, val);
    System.out.println("Binary Search Tree after deletion: ");
    printInOrder(root);
  }
}
