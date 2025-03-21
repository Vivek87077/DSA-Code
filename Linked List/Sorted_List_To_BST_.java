class ListNode {
    int value;
    ListNode next;
    
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class TreeNode {
    int value;
    TreeNode left, right;
    
    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class Sorted_List_To_BST_ {
    
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildBST(head, null);
    }
    
    private static TreeNode buildBST(ListNode start, ListNode end) {
        if (start == end) return null;

        // Find the middle element
        ListNode mid = findMiddle(start, end);
        TreeNode root = new TreeNode(mid.value);

        // Recursively build left and right subtrees
        root.left = buildBST(start, mid);
        root.right = buildBST(mid.next, end);
        
        return root;
    }

    private static ListNode findMiddle(ListNode start, ListNode end) {
        ListNode slow = start, fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to print inorder traversal of BST
    public static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.value + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Creating a sorted linked list: -10 → -3 → 0 → 5 → 9
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST(head);
        System.out.println("Inorder traversal of BST:");
        inorderTraversal(root);
    }
}
