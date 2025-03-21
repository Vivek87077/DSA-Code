import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class l_Merge_2_BSTs_ {
    
    // Perform inorder traversal and store in a list
    private static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Merge two sorted lists
    private static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i++));
            } else {
                mergedList.add(list2.get(j++));
            }
        }
        while (i < list1.size()) mergedList.add(list1.get(i++));
        while (j < list2.size()) mergedList.add(list2.get(j++));
        return mergedList;
    }

    // Convert a sorted list to a balanced BST
    private static TreeNode sortedListToBST(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedListToBST(list, start, mid - 1);
        root.right = sortedListToBST(list, mid + 1, end);
        return root;
    }

    // Merge two BSTs into one BST
    public static TreeNode mergeBSTs(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Get sorted lists from both BSTs
        inorder(root1, list1);
        inorder(root2, list2);

        // Merge the two sorted lists
        List<Integer> mergedList = mergeSortedLists(list1, list2);

        // Construct a balanced BST from the merged list
        return sortedListToBST(mergedList, 0, mergedList.size() - 1);
    }

    // Inorder traversal to print BST
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        // First BST
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(5);

        // Second BST
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(6);

        // Merging BSTs
        TreeNode mergedRoot = mergeBSTs(root1, root2);

        // Print inorder of merged BST (should be sorted)
        System.out.print("Inorder traversal of merged BST: ");
        printInorder(mergedRoot);
    }
}
