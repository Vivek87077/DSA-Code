import java.util.HashSet;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Delete_Nodes_from_LL_that_are_present_in_an_array_{

    public static Node deleteNodes(Node head, int[] toDelete) {
        // Step 1: Store values to delete in a HashSet for quick lookup
        HashSet<Integer> deleteSet = new HashSet<>();
        for (int num : toDelete) {
            deleteSet.add(num);
        }

        // Step 2: Use a dummy node to simplify head deletion cases
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy, current = head;

        // Step 3: Traverse the list and remove matching nodes
        while (current != null) {
            if (deleteSet.contains(current.value)) {
                prev.next = current.next; // Skip the node
            } else {
                prev = current; // Move prev only if current is not deleted
            }
            current = current.next; // Move to the next node
        }

        return dummy.next; // Return the updated list
    }

    // Helper function to print the linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
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

        int[] toDelete = {2, 4}; // Nodes to delete

        System.out.println("Original List:");
        printList(head);

        head = deleteNodes(head, toDelete);

        System.out.println("List after Deletion:");
        printList(head);
    }
}
