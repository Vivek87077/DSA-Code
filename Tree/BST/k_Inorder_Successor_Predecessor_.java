class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int val) {
      this.val = val;
      left = right = null;
  }
}

public class k_Inorder_Successor_Predecessor_ {
  public static TreeNode findPredecessor(TreeNode root, TreeNode node) {
      TreeNode predecessor = null;
      while (root != null) {
          if (node.val > root.val) { 
              predecessor = root;  // Candidate for predecessor
              root = root.right; 
          } else {
              root = root.left;
          }
      }
      return predecessor;
  }

  public static TreeNode findSuccessor(TreeNode root, TreeNode node) {
      TreeNode successor = null;
      while (root != null) {
          if (node.val < root.val) {
              successor = root;  // Candidate for successor
              root = root.left;
          } else {
              root = root.right;
          }
      }
      return successor;
  }

  public static void main(String[] args) {
      // Constructing BST
      TreeNode root = new TreeNode(20);
      root.left = new TreeNode(10);
      root.right = new TreeNode(30);
      root.left.left = new TreeNode(5);
      root.left.right = new TreeNode(15);
      root.right.left = new TreeNode(25);
      root.right.right = new TreeNode(35);

      TreeNode node = root.left.right; // Node 15

      TreeNode predecessor = findPredecessor(root, node);
      TreeNode successor = findSuccessor(root, node);

      System.out.println("Predecessor of " + node.val + ": " + (predecessor != null ? predecessor.val : "None"));
      System.out.println("Successor of " + node.val + ": " + (successor != null ? successor.val : "None"));
  }
}
