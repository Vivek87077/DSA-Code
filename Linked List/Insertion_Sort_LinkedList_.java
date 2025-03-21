class ListNode {
    int value;
    ListNode next;
    
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Insertion_Sort_LinkedList_ {
    
    public static ListNode insertionSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);  // Dummy node for sorted list
        ListNode curr = head;  // Pointer for traversing the unsorted list

        while (curr != null) {
            ListNode prev = dummy;  // Start from dummy node
            ListNode nextNode = curr.next;  // Save next node

            // Find the correct position for insertion in sorted list
            while (prev.next != null && prev.next.value < curr.value) {
                prev = prev.next;
            }

            // Insert the current node in the sorted list
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node in unsorted list
            curr = nextNode;
        }

        return dummy.next;
    }

    // Helper function to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating an unsorted linked list: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Unsorted List:");
        printList(head);

        head = insertionSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
