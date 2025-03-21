class Node {
  int data;
  Node next;

  Node(int x) {
      data = x;
      next = null;
  }
}

class GfG {

  // Reverses alternate k nodes and returns 
  // the pointer to the new head node
  static Node kAltReverse(Node head, int k) {
      Node curr = head;
      Node next = null;
      Node prev = null;
      int count = 0;

      // Reverse the first k nodes of the linked list
      while (curr != null && count < k) {
          next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;
          count++;
      }

      // Now head points to the kth node. 
      // So change next of head to (k+1)th node
      if (head != null) {
          head.next = curr;
      }

      // Skip the next k nodes
      count = 0;
      while (count < k - 1 && curr != null) {
          curr = curr.next;
          count++;
      }

      // Recursively call for the list 
        // starting from curr->next
      if (curr != null) {
          curr.next = kAltReverse(curr.next, k);
      }

      // prev is the new head of 
        // the input list
      return prev;
  }

  static void printList(Node node) {
      Node curr = node;
      while (curr != null) {
          System.out.print(curr.data + " ");
          curr = curr.next;
      }
      System.out.println();
  }

  public static void main(String[] args) {
    
      // Hardcoded linked list: 1->2->3->4->5->6
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(3);
      head.next.next.next = new Node(4);
      head.next.next.next.next = new Node(5);
      head.next.next.next.next.next = new Node(6);

      head = kAltReverse(head, 2);

      printList(head);
  }
}
