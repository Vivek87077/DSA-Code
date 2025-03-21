import java.util.Stack;

class Node {
    int value;
    Node next;
    Node prev;
    Node child;

    Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
        this.child = null;
    }
}

public class Flatten_Multi_level_Doubly_LL_ {
    
    public static Node flatten(Node head) {
        if (head == null) return null;

        Stack<Node> stack = new Stack<>();
        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                // If next exists, push it to stack
                if (curr.next != null) {
                    stack.push(curr.next);
                    curr.next.prev = null; // Break prev link for safe reconnect
                }

                // Connect child as next
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }

            // If reached end and stack has nodes, pop and attach
            if (curr.next == null && !stack.isEmpty()) {
                Node nextNode = stack.pop();
                curr.next = nextNode;
                nextNode.prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }

    // Helper function to print the list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ⇄ ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating a multilevel doubly linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.child = new Node(7);
        head.next.child.next = new Node(8);
        head.next.child.next.prev = head.next.child;
        head.next.child.next.child = new Node(11);
        head.next.child.next.child.next = new Node(12);
        head.next.child.next.child.next.prev = head.next.child.next.child;

        System.out.println("Original List:");
        printList(head);

        head = flatten(head);

        System.out.println("Flattened List:");
        printList(head);
    }
}
