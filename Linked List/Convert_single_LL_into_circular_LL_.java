class Node {
  int data;
  Node next;
  
  Node(int data) {
      this.data = data;
      this.next = null;
  }
}

public class Convert_single_LL_into_circular_LL_ 
  {
  
  // Function that converts singly linked 
    // list into circular linked list
  static void circular(Node curr, Node head) {
      
      // if last node, then point next ptr
      // to head Node
      if (curr.next == null) {
          curr.next = head;
          return;
      }
      
      // otherwise move to the 
      // next node
      circular(curr.next, head);
  }
  
  static void printList(Node head) {
      Node curr = head;
      
      do {
          System.out.print(curr.data + " ");
          curr = curr.next;
      } while (curr != head);
      System.out.println();
  }

  public static void main(String[] args) {
      
      // create a hard coded list 10->12->14->16
      Node head = new Node(10);
      head.next = new Node(12);
      head.next.next = new Node(14);
      head.next.next.next = new Node(16);
      
      circular(head, head);
      
      printList(head);
  }
}
