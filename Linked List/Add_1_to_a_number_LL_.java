class Node {
  int value;
  Node next;

  Node(int value) {
      this.value = value;
      this.next = null;
  }
}

public class Add_1_to_a_number_LL_{

  // Function to reverse a linked list
  private static Node reverse(Node head) {
      Node prev = null, current = head;
      while (current != null) {
          Node nextNode = current.next;
          current.next = prev;
          prev = current;
          current = nextNode;
      }
      return prev;
  }

  // Function to add 1 to a reversed linked list
  private static Node addOneUtil(Node head) {
      Node current = head;
      int carry = 1; // Adding 1
      Node prev = null;

      while (current != null) {
          int sum = current.value + carry;
          carry = sum / 10;
          current.value = sum % 10;
          prev = current;
          current = current.next;
      }

      // If carry is still left, add a new node at the end
      if (carry > 0) {
          prev.next = new Node(carry);
      }

      return head;
  }

  // Main function to add 1 to the number represented by linked list
  public static Node addOne(Node head) {
      head = reverse(head); // Step 1: Reverse
      head = addOneUtil(head); // Step 2: Add 1
      return reverse(head); // Step 3: Reverse back
  }

  // Helper function to print linked list
  public static void printList(Node head) {
      while (head != null) {
          System.out.print(head.value + " -> ");
          head = head.next;
      }
      System.out.println("null");
  }

  public static void main(String[] args) {
      // Number: 129 (1 → 2 → 9)
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(9);

      System.out.println("Original List:");
      printList(head);

      head = addOne(head);

      System.out.println("After Adding 1:");
      printList(head);
  }
}
