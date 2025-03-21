class Node {
  int data;
  Node prev, next;

  Node(int x) {
      data = x;
      prev = null;
      next = null;
  }
}

public class Rotate_doubly_Linked_LL_by_N_nodes_ {

  // Function to rotate the doubly-linked list
  static Node rotateDLL(Node head, int p) {
      Node tail = head;

      // Find the last node
      while (tail.next != null) {
          tail = tail.next;
      }

      // Make the list circular
      tail.next = head;
      head.prev = tail;

      // Move head and tail by the given position
      for (int count = 1; count <= p; count++) {
          head = head.next;
          tail = tail.next;
      }

      // Break the circular connection
      tail.next = null;
      head.prev = null;

      return head;
  }

  static void printList(Node head) {
      Node curr = head;
      while (curr != null) {
          System.out.print(curr.data);
          if (curr.next != null) {
              System.out.print(" ");
          }
          curr = curr.next;
      }
      System.out.println();
  }

  public static void main(String[] args) {

      Node head = new Node(2);
      head.next = new Node(6);
      head.next.prev = head;
      head.next.next = new Node(5);
      head.next.next.prev = head.next;
      head.next.next.next = new Node(4);
      head.next.next.next.prev = head.next.next;

      int p = 3;
      head = rotateDLL(head, p);
      printList(head);
  }
}
