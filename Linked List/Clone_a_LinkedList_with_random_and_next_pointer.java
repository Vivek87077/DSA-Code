class Node {
    int value;
    Node next, random;

    Node(int value) {
        this.value = value;
        this.next = null;
        this.random = null;
    }
}

public class Clone_a_LinkedList_with_random_and_next_pointer {

    public static Node cloneList(Node head) {
        if (head == null) return null;

        // Step 1: Insert cloned nodes between original nodes
        Node current = head;
        while (current != null) {
            Node clonedNode = new Node(current.value);
            clonedNode.next = current.next;
            current.next = clonedNode;
            current = clonedNode.next;
        }

        // Step 2: Assign correct random pointers
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next; // Move to next original node
        }

        // Step 3: Separate cloned list from original list
        current = head;
        Node clonedHead = head.next;
        Node copy = clonedHead;

        while (current != null) {
            current.next = current.next.next;
            copy.next = (copy.next != null) ? copy.next.next : null;
            current = current.next;
            copy = copy.next;
        }

        return clonedHead;
    }

    // Helper function to print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("[" + temp.value + ", Random: " + (temp.random != null ? temp.random.value : "null") + "] → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Assign random pointers
        head.random = head.next.next; // 1 → 3
        head.next.random = head; // 2 → 1
        head.next.next.random = head.next.next.next.next; // 3 → 5
        head.next.next.next.random = head.next.next; // 4 → 3
        head.next.next.next.next.random = head.next; // 5 → 2

        System.out.println("Original Linked List:");
        printList(head);

        Node clonedHead = cloneList(head);
        System.out.println("Cloned Linked List:");
        printList(clonedHead);
    }
}
