
// Java code to reverse a doubly linked 
// list in groups of K size

class Node {
  int data;
  Node next;
  Node prev;

  Node(int x) {
      data = x;
      next = null;
      prev = null;
  }
}

// Helper function to reverse K nodes
public class Reverse_a_doubly_LL_in_group_k_size_ {
  static Node reverseKNodes(Node head, int k) {
      Node curr = head, prev = null, next = null;
      int count = 0;

      while (curr != null && count < k) {
          next = curr.next;
          curr.next = prev;
          curr.prev = null;
          if (prev != null) {
              prev.prev = curr;
          }
          prev = curr;
          curr = next;
          count++;
      }

      return prev;
  }

  // Recursive function to reverse in groups of K
  static Node reverseKGroup(Node head, int k) {
      if (head == null) {
          return head;
      }

      Node groupHead = null;
      Node newHead = null;

      // Move temp to the next group
      Node temp = head;
      int count = 0;
      while (temp != null && count < k) {
          temp = temp.next;
          count++;
      }

      // Reverse the first K nodes
      groupHead = reverseKNodes(head, k);

      // Connect the reversed group with the next part
      if (newHead == null) {
          newHead = groupHead;
      }

      // Recursion for the next group
      head.next = reverseKGroup(temp, k);
      if (head.next != null) {
          head.next.prev = head;
      }

      return newHead;
  }

  // Function to print the doubly linked list
  static void printList(Node head) {
      Node curr = head;
      while (curr != null) {
          System.out.print(curr.data + " ");
          curr = curr.next;
      }
      System.out.println();
  }

  public static void main(String[] args) {
    
      // Creating a sample doubly linked list:
      // 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.prev = head;
      head.next.next = new Node(3);
      head.next.next.prev = head.next;
      head.next.next.next = new Node(4);
      head.next.next.next.prev = head.next.next;
      head.next.next.next.next = new Node(5);
      head.next.next.next.next.prev = head.next.next.next;
      head.next.next.next.next.next = new Node(6);
      head.next.next.next.next.next.prev = head.next.next.next.next;

      head = reverseKGroup(head, 2);
      printList(head);
  }
}
