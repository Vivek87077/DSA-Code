class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Swap_Nodes_In_Pairs_ {

    public static Node swapPairs(Node head) {
        // Dummy node before the head to simplify swapping
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            Node first = prev.next;
            Node second = first.next;

            // Swapping the two nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move to the next pair
            prev = first;
        }

        return dummy.next; // Return new head
    }

    // Helper function to print the linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 → 2 → 3 → 4 → 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printList(head);

        head = swapPairs(head);

        System.out.println("Swapped List:");
        printList(head);
    }
}


/*

Input:
1 → 2 → 3 → 4 → 5 → null

Step-by-step Swapping:
Swap (1,2) → 2 → 1 → 3 → 4 → 5
Swap (3,4) → 2 → 1 → 4 → 3 → 5
Final list → 2 → 1 → 4 → 3 → 5 → null

Output:
2 → 1 → 4 → 3 → 5 → null

 */