class Node {
  int data;
  Node next;

  Node(int val) {
      data = val;
      next = null;
  }
}

class Partition_a_list_around_a_given_value_ {

  static Node partition(Node head, int x) {
      // Dummy head for nodes less than x
      Node lessHead = new Node(0);

      // Dummy head for nodes equal to x
      Node equalHead = new Node(0);

      // Dummy head for nodes greater than or equal to x
      Node greaterHead = new Node(0);

      Node less = lessHead;
      Node equal = equalHead;
      Node greater = greaterHead;

      Node curr = head;

      while (curr != null) {
          if (curr.data < x) {
              less.next = curr;
              less = less.next;
          } else if (curr.data == x) {
              equal.next = curr;
              equal = equal.next;
          } else {
              greater.next = curr;
              greater = greater.next;
          }
          curr = curr.next;
      }

      // Connect the partitions together
      greater.next = null;

      // Connect equal to greater
      equal.next = greaterHead.next;

      // Connect less to equal
      less.next = equalHead.next;

      // New head of the rearranged list
      Node newHead = lessHead.next;

      return newHead;
  }

  static void printList(Node head) {
      Node curr = head;
      while (curr != null) {
          System.out.print(curr.data + " ");
          curr = curr.next;
      }
      System.out.println();
  }

  public static void main(String[] args) {
      // Creating the linked list: 1 -> 4 -> 3 -> 2 -> 5 -> 2
      Node head = new Node(1);
      head.next = new Node(4);
      head.next.next = new Node(3);
      head.next.next.next = new Node(2);
      head.next.next.next.next = new Node(5);
      head.next.next.next.next.next = new Node(2);
      int x = 3;
      head = partition(head, x);
      printList(head);
  }
}
