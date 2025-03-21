class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Reverse_Linked_List_II_ {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move to the node before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse nodes from `left` to `right`
        ListNode curr = prev.next;
        ListNode next = null;
        ListNode prevSub = null;

        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = prevSub;
            prevSub = curr;
            curr = next;
        }

        // Step 3: Connect the reversed sublist back
        prev.next.next = next;  // Connect tail of reversed sublist
        prev.next = prevSub;    // Connect head of reversed sublist

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Input: 1 -> 2 -> 3 -> 4 -> 5, left = 2, right = 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        head = reverseBetween(head, 2, 4);

        System.out.println("Reversed List (2 to 4):");
        printList(head);
    }
}
