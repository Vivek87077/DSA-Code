class Node {
  int data;
  Node next;
  Node prev;

  Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
  }
}

public class Sort_a_k_sorted_doubly_LL_ {

  // Function to sort a k-sorted doubly linked list
  static Node sortAKSortedDLL(Node head, int k) {
      if (head == null || head.next == null)
          return head;

      Node node = head.next;

      while (node != null) {
          Node next = node.next;
          Node curr = node;

          while (curr.prev != null
                 && curr.data < curr.prev.data) {

              // Swap curr and curr.prev node
              Node node1 = curr.prev.prev;
              Node node2 = curr.prev;
              Node node3 = curr.next;

              if (node1 != null)
                  node1.next = curr;
              curr.prev = node1;

              node2.next = node3;
              if (node3 != null)
                  node3.prev = node2;

              curr.next = node2;
              node2.prev = curr;
          }

          // If curr is now the new head,
          // then reset head
          if (curr.prev == null)
              head = curr;

          node = next;
      }
      return head;
  }

  static void printList(Node curr) {
      while (curr != null) {
          System.out.print(curr.data + " ");
          curr = curr.next;
      }
      System.out.println();
  }

  public static void main(String[] args) {
    
      // Create the doubly linked list:
      // 3 <-> 2 <-> 1 <-> 5
      Node head = new Node(3);
      head.next = new Node(2);
      head.next.prev = head;
      head.next.next = new Node(1);
      head.next.next.prev = head.next;
      head.next.next.next = new Node(5);
      head.next.next.next.prev = head.next.next;

      int k = 2;
      head = sortAKSortedDLL(head, k);
      printList(head);
  }
}
