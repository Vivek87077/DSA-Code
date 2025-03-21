class Node {
  int data;
  Node next;

  Node(int x)
  {
      data = x;
      next = null;
  }
}

public class Intersection_of_two_sorted_list_ {
  public static Node findIntersection(Node a, Node b)
  {

      // Base case: if either list is empty, the
      // intersection is also empty
      if (a == null || b == null) {
          return null;
      }

      // Recursive case
      if (a.data < b.data) {

          // The current node in the first list is
          // smaller, so we move to the next node in the
          // first list
          return findIntersection(a.next, b);
      }
      else if (a.data > b.data) {

          // The current node in the second list is
          // smaller, so we move to the next node in the
          // second list
          return findIntersection(a, b.next);
      }
      else {

          // The current nodes in both lists have the same
          // value, so we create a new node with this
          // value and recursively call the function on
          // the remaining parts of both lists
          Node temp = new Node(a.data);
          temp.next = findIntersection(a.next, b.next);
          return temp;
      }
  }

  public static void main(String[] args)
  {
      // Create the first linked list
      Node head1 = new Node(1);
      head1.next = new Node(2);
      head1.next.next = new Node(3);
      head1.next.next.next = new Node(4);
      head1.next.next.next.next = new Node(6);

      // Create the second linked list
      Node head2 = new Node(2);
      head2.next = new Node(4);
      head2.next.next = new Node(6);
      head2.next.next.next = new Node(8);

      // Find the intersection of the two linked lists
      Node result = findIntersection(head1, head2);

      // Print the intersection list
      while (result != null) {
          System.out.print(result.data + " ");
          result = result.next;
      }
  }
}
