class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Add_Two_Numbers_LL_{

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node ans = new Node(0); // Dummy node for result list
        Node current = ans;  // Pointer to construct the result list
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }

            carry = sum / 10; // Carry for next step
            current.next = new Node(sum % 10); // Create new node with last digit
            current = current.next; // Move forward
        }

        return ans.next; // Head of the result list
    }

    // Helper function to print linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // List 1: 2 → 4 → 3  (represents 342)
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        // List 2: 5 → 6 → 4  (represents 465)
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        System.out.println("List 1:");
        printList(l1);
        System.out.println("List 2:");
        printList(l2);

        Node result = addTwoNumbers(l1, l2);
        System.out.println("Sum:");
        printList(result);
    }
}
