
class Node {
  int data;
  Node next;

  Node(int newValue) {
      data = newValue;
      next = null;
  }
}

class Pair {
  Node first;
  Node second;

  Pair(Node first, Node second) {
      this.first = first;
      this.second = second;
  }
}

public class Split_a_circular_LL_into_two_halves_ {

  // Function to split a list into two lists.
  static Pair splitList(Node head) {
      Node slow = head;
      Node fast = head;

      if (head == null) {
          return new Pair(null, null);
      }

      // For odd nodes, fast.next is head and
      // for even nodes, fast.next.next is head
      while (fast.next != head && 
             fast.next.next != head) {
          fast = fast.next.next;
          slow = slow.next;
      }

      // If there are even elements in 
        // the list then move fast
      if (fast.next.next == head) {
          fast = fast.next;
      }

      // Set the head pointer of the first half
      Node head1 = head;

      // Set the head pointer of the second half
      Node head2 = slow.next;

      // Make the second half circular
      fast.next = slow.next;

      // Make the first half circular
      slow.next = head;

      return new Pair(head1, head2);
  }

  static void printList(Node head) {
      Node curr = head;
      if (head != null) {
          do {
              System.out.print(curr.data + " ");
              curr = curr.next;
          } while (curr != head);
            System.out.println();
      }
  }

  public static void main(String[] args) {
      
      Node head1 = null;
      Node head2 = null;

      // Created linked list will be 1->2->3->4
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(3);
      head.next.next.next = new Node(4);
      head.next.next.next.next = head;

      Pair result = splitList(head);
      head1 = result.first;
      head2 = result.second;

      printList(head1);
      printList(head2);
  }   
}

