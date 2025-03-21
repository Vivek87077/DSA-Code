class ListNode {
    int value;
    ListNode next;
    ListNode bottom;

    ListNode(int value) {
        this.value = value;
        this.next = null;
        this.bottom = null;
    }
}

public class Flatten_a_Linked_List_ {

    // Merge two sorted linked lists
    private static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode result;
        if (a.value < b.value) {
            result = a;
            result.bottom = mergeTwoLists(a.bottom, b);
        } else {
            result = b;
            result.bottom = mergeTwoLists(a, b.bottom);
        }
        result.next = null; // Ensure next is null in flattened list
        return result;
    }

    // Function to flatten the linked list
    public static ListNode flatten(ListNode head) {
        if (head == null || head.next == null) 
            return head; // Base case

        // Recursively flatten the next list
        head.next = flatten(head.next);

        // Merge current list with the next flattened list
        head = mergeTwoLists(head, head.next);

        return head;
    }

    // Helper function to print the flattened list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.bottom;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.bottom = new ListNode(7);
        head.bottom.bottom = new ListNode(8);
        head.bottom.bottom.bottom = new ListNode(30);

        head.next = new ListNode(10);
        head.next.bottom = new ListNode(20);

        head.next.next = new ListNode(19);
        head.next.next.bottom = new ListNode(22);
        head.next.next.bottom.bottom = new ListNode(50);

        head.next.next.next = new ListNode(28);
        head.next.next.next.bottom = new ListNode(35);
        head.next.next.next.bottom.bottom = new ListNode(40);
        head.next.next.next.bottom.bottom.bottom = new ListNode(45);

        System.out.println("Flattened Linked List:");
        head = flatten(head);
        printList(head);
    }
}
