import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class Inorder_Successor_in_BST_ {
    
    List<TreeNode> inorderList = new ArrayList<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorderTraversal(root);
        for (int i = 0; i < inorderList.size(); i++) {
            if (inorderList.get(i) == p && i + 1 < inorderList.size()) {
                return inorderList.get(i + 1); // Return next node in inorder sequence
            }
        }
        return null;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        inorderList.add(node);
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        Inorder_Successor_in_BST_ tree = new Inorder_Successor_in_BST_();
        
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left; // Node with value 3
        TreeNode successor = tree.inorderSuccessor(root, p);
        
        if (successor != null) {
            System.out.println("Inorder Successor of " + p.val + " is: " + successor.val);
        } else {
            System.out.println("No Inorder Successor found");
        }
    }
}
