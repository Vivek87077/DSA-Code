class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Merge_2_Sorted_LL_ {

    public static ListNode mergeSortedLists(ListNode first, ListNode second) {
        // Dummy node to simplify handling of head
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (first != null && second != null) {
            if (first.value < second.value) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        // Attach the remaining list
        if (first != null) current.next = first;
        if (second != null) current.next = second;

        return dummy.next; // Return merged list (skip dummy node)
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // First sorted list: 1 -> 3 -> 5
        ListNode first = new ListNode(1);
        first.next = new ListNode(3);
        first.next.next = new ListNode(5);

        // Second sorted list: 2 -> 4 -> 6
        ListNode second = new ListNode(2);
        second.next = new ListNode(4);
        second.next.next = new ListNode(6);

        ListNode merged = mergeSortedLists(first, second);
        System.out.print("Merged Sorted List: ");
        printList(merged);
    }
}
