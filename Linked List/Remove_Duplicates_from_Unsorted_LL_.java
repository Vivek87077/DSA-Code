import java.util.HashSet;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Remove_Duplicates_from_Unsorted_LL_ {
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) return null;

        HashSet<Integer> seen = new HashSet<>();
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (seen.contains(current.value)) {
                prev.next = current.next; // Remove duplicate
            } else {
                seen.add(current.value);
                prev = current; // Move prev forward
            }
            current = current.next; // Move current forward
        }

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Input: 4 -> 2 -> 4 -> 3 -> 2 -> 1
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);

        System.out.println("Original List:");
        printList(head);

        head = removeDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(head);
    }
}
