class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Sort_Linked_List_0_1_2_ {
    // Apply Dutch National Flag Algorithm

    // Function to sort the linked list of 0s, 1s, and 2s
    public static Node sortList(Node head) {
        if (head == null || head.next == null) return head; // Edge case

        // Create dummy heads for three lists
        Node zeroHead = new Node(0), oneHead = new Node(0), twoHead = new Node(0);
        Node zeroTail = zeroHead, oneTail = oneHead, twoTail = twoHead;
        Node current = head;

        // Step 1: Divide nodes into three lists
        while (current != null) {
            if (current.value == 0) {
                zeroTail.next = current;
                zeroTail = zeroTail.next;
            } else if (current.value == 1) {
                oneTail.next = current;
                oneTail = oneTail.next;
            } else {
                twoTail.next = current;
                twoTail = twoTail.next;
            }
            current = current.next;
        }

        // Step 2: Merge three lists
        zeroTail.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        oneTail.next = twoHead.next;
        twoTail.next = null; // End the final list

        // Step 3: Return the new head (skip dummy node)
        return zeroHead.next;
    }

    // Helper function to print a linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 → 2 → 0 → 1 → 2 → 0 → 1
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(1);

        System.out.println("Original List:");
        printList(head);

        head = sortList(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
