class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Rotate_Linked_List_ {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // No rotation needed
        }

        // Step 1: Find the length of the linked list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Optimize k
        k = k % length;
        if (k == 0) return head; // If k is a multiple of length, no change needed

        // Step 3: Connect tail to head (make it circular)
        current.next = head;  // Connect last node to head

        // Step 4: Find new tail (node at position length - k)
        int newTailPosition = length - k;
        current = head;
        for (int i = 1; i < newTailPosition; i++) {
            current = current.next;
        }

        // Step 5: Break the link to form the new head
        ListNode newHead = current.next;
        current.next = null;

        return newHead;
    }

    // Helper function to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        System.out.println("Original List:");
        printList(head);

        head = rotateRight(head, k);
        System.out.println("Rotated List by " + k + " places:");
        printList(head);
    }
}
