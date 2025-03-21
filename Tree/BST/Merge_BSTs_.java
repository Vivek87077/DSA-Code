import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class Merge_BSTs_ {

    // Step 1: Perform Inorder Traversal
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Step 2: Merge Two Sorted Lists
    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                merged.add(list1.get(i++));
            } else {
                merged.add(list2.get(j++));
            }
        }
        while (i < list1.size()) merged.add(list1.get(i++));
        while (j < list2.size()) merged.add(list2.get(j++));
        return merged;
    }

    // Step 3: Construct a Balanced BST from Sorted List
    private TreeNode sortedListToBST(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedListToBST(list, start, mid - 1);
        root.right = sortedListToBST(list, mid + 1, end);
        return root;
    }

    // Main Function to Merge BSTs
    public TreeNode mergeBSTs(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        // Get inorder traversal lists
        inorder(root1, list1);
        inorder(root2, list2);

        // Merge sorted lists
        List<Integer> mergedList = mergeSortedLists(list1, list2);

        // Convert merged sorted list to balanced BST
        return sortedListToBST(mergedList, 0, mergedList.size() - 1);
    }

    // Print Inorder Traversal (For Testing)
    public void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {
        Merge_BSTs_ bst = new Merge_BSTs_();

        // BST 1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        // BST 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(5);

        System.out.println("BST 1 (Inorder):");
        bst.printInorder(root1);

        System.out.println("\nBST 2 (Inorder):");
        bst.printInorder(root2);

        // Merge BSTs
        TreeNode mergedRoot = bst.mergeBSTs(root1, root2);

        System.out.println("\nMerged BST (Inorder):");
        bst.printInorder(mergedRoot);
    }
}
