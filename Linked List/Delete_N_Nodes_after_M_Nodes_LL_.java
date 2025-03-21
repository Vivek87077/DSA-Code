

class Node {
  int data;
  Node next;

  Node(int data)
  {
      this.data = data;
      this.next = null;
  }
}

public class Delete_N_Nodes_after_M_Nodes_LL_ {

  // Function to skip m nodes and then delete n nodes
  // of the linked list
  static Node skipMdeleteN(Node head, int m, int n)
  {
      Node curr = head; // Current node pointer
      Node t; // Temporary node pointer
      int count; // Counter variable

      // Traverse through the entire linked list
      while (curr != null) {

          // Skip m nodes
          for (count = 1; count < m && curr != null;
               count++)
              curr = curr.next;

          // If end of the list is reached, return the
          // head
          if (curr == null)
              return head;

          // Start from the next node and delete n nodes
          t = curr.next;
          for (count = 1; count <= n && t != null;
               count++) {
              Node temp = t;
              t = t.next;

              // Dereference the node for garbage
              // collection
              temp = null;
          }

          // Link the current node to the remaining list
          curr.next = t;

          // Move the current pointer to the next node
          curr = t;
      }

      return head;
  }

  static void printList(Node head)
  {
      Node curr = head;
      while (curr != null) {
          System.out.print(curr.data + " ");
          curr = curr.next;
      }
      System.out.println();
  }

  public static void main(String[] args)
  {
      // Create the following linked list:
      // 1->2->3->4->5->6
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(3);
      head.next.next.next = new Node(4);
      head.next.next.next.next = new Node(5);
      head.next.next.next.next.next = new Node(6);

      int m = 2, n = 2;
      head = skipMdeleteN(head, m, n);
      printList(head);
  }
}
