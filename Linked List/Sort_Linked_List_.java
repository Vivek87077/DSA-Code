class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Sort_Linked_List_ {

    // Function to find the middle node (using slow-fast pointer approach)
    private static Node getMiddle(Node head) {
        if (head == null || head.next == null) return head;

        Node slow = head, fast = head.next; 
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Middle node
    }

    // Function to merge two sorted linked lists
    private static Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (left != null && right != null) {
            if (left.value < right.value) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        // Attach the remaining part of either list
        tail.next = (left != null) ? left : right;

        return dummy.next; // Skip the dummy node
    }

    // Function to sort linked list using merge sort
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) 
            return head; // Base case

        // Step 1: Split the list into two halves
        Node middle = getMiddle(head);
        Node rightHead = middle.next;
        middle.next = null; // Break the list into two parts

        // Step 2: Recursively sort both halves
        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        // Step 3: Merge the sorted halves
        return merge(left, right);
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
        // Creating an unsorted linked list: 4 → 2 → 1 → 3
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Original List:");
        printList(head);

        head = mergeSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
