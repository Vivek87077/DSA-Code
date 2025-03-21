class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Intersection_Of_two_Linked_Lists_Y {

    // Function to get the length of a linked list
    private static int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // Function to find the intersection node
    public static Node findIntersection(Node head1, Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        // Move the pointer of the longer list ahead by the length difference
        while (len1 > len2) {
            head1 = head1.next;
            len1--;
        }
        while (len2 > len1) {
            head2 = head2.next;
            len2--;
        }

        // Traverse both lists together until they meet
        while (head1 != null && head2 != null) {
            if (head1 == head2) { // Found the intersection
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null; // No intersection found
    }

    // Helper function to print a linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating two intersecting linked lists:
        // List 1: 1 → 2 → 3
        //                    ↘
        //                      6 → 7 → null
        //                    ↗
        // List 2:      4 → 5 

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        Node intersection = new Node(6);
        head1.next.next.next = intersection;
        intersection.next = new Node(7);

        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = intersection; // Intersecting at node 6

        System.out.println("List 1:");
        printList(head1);
        System.out.println("List 2:");
        printList(head2);

        Node result = findIntersection(head1, head2);
        if (result != null) {
            System.out.println("Intersection Point: " + result.value);
        } else {
            System.out.println("No Intersection Found.");
        }
    }
}
