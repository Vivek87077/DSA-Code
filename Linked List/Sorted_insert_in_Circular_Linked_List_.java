class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Sorted_insert_in_Circular_Linked_List_ {
    
    public static Node sortedInsert(Node head, int newValue) {
        Node newNode = new Node(newValue);

        // Case 1: Empty list
        if (head == null) {
            newNode.next = newNode; // Point to itself (circular)
            return newNode;
        }

        Node curr = head;

        // Case 2: Insert before head (smallest value)
        if (newValue < head.value) {
            while (curr.next != head) { // Find last node
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.next = head;
            return newNode; // New head
        }

        // Case 3: Insert in correct position
        while (curr.next != head && curr.next.value < newValue) {
            curr = curr.next;
        }

        // Insert new node
        newNode.next = curr.next;
        curr.next = newNode;

        return head; // Head remains unchanged
    }

    // Helper function to print Circular Linked List
    public static void printList(Node head) {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Head)");
    }

    public static void main(String[] args) {
        // Creating a sorted circular linked list: 1 -> 3 -> 5 -> (back to 1)
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = head; // Circular link

        System.out.println("Original Circular Linked List:");
        printList(head);

        // Insert values
        head = sortedInsert(head, 4);
        head = sortedInsert(head, 0);
        head = sortedInsert(head, 6);

        System.out.println("After Inserting 4, 0, 6:");
        printList(head);
    }
}
