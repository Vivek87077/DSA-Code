class Node {
  int data;
  Node next;

  Node(int new_data) {
      data = new_data;
      next = null;
  }
}
public class Reverse_a_Sublist_of_list_ {
  // Function to reverse a linked list
  static Node reverse(Node head) {
    Node prevNode = null;
    Node currNode = head;
    while (currNode != null) {
      Node nextNode = currNode.next;
      currNode.next = prevNode;
      prevNode = currNode;
      currNode = nextNode;
    }
    return prevNode;
  }

  // Function to reverse a linked list from position m to n
  static Node reverseBetween(Node head, int m, int n) {

    // If m and n are the same, no reversal is needed
    if (m == n)
      return head;

    Node revs = null, revs_prev = null;
    Node revend = null, revend_next = null;

    // Traverse the list to locate the nodes
    // and pointers needed for reversal
    int i = 1;
    Node currNode = head;
    while (currNode != null && i <= n) {

      // Track the node just before the start of
      // the reversal segment
      if (i < m)
        revs_prev = currNode;

      // Track the start of the reversal segment
      if (i == m)
        revs = currNode;

      // Track the end of the reversal
      // segment and the node right after it
      if (i == n) {
        revend = currNode;
        revend_next = currNode.next;
      }
      currNode = currNode.next;
      i++;
    }

    // Detach the segment to be reversed
    // from the rest of the list
    if (revs != null)
      revend.next = null;

    // Reverse the segment from position m to n
    revend = reverse(revs);

    // Reattach the reversed segment back to the list
    // If the reversal segment was not at the head of the list
    if (revs_prev != null)
      revs_prev.next = revend;
    else
      head = revend;

    // Connect the end of the reversed
    // segment to the rest of the list
    if (revs != null)
      revs.next = revend_next;

    return head;
  }

  static void print(Node head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println("NULL");
  }

  public static void main(String[] args) {

    // Initialize linked list:
    // 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> 70
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(50);
    head.next.next.next.next.next = new Node(60);
    head.next.next.next.next.next.next = new Node(70);

    System.out.print("Original list: ");
    print(head);

    head = reverseBetween(head, 3, 6);

    System.out.print("Modified list: ");
    print(head);
  }
}
