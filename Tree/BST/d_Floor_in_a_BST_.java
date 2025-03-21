// Floor value : => value of greatest node which is smaller than or equal to key
public class d_Floor_in_a_BST_ {
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

  public static int floorKey(TreeNode root, int key) {
    int floor = -1;
    while (root != null) {
        if (root.val == key) {
            floor = root.val;
            return floor;
        }

        if (key > root.val) {
          floor = root.val;
          root = root.right;
        } else {
          root = root.left;
        }
    }     
    return floor;
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

    int key = 7;
    int ans = floorKey(root, key);
    System.out.println("Floor value for the key in the BT: " +ans);
  }
}
