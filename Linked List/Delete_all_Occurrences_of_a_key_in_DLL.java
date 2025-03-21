class Node {
  int value;
  Node prev, next;

  Node(int value) {
      this.value = value;
      this.prev = this.next = null;
  }
}

public class Delete_all_Occurrences_of_a_key_in_DLL {

  public static Node deleteOccurrences(Node head, int key) {
      if (head == null) return null;

      Node curr = head;

      while (curr != null) {
          if (curr.value == key) {
              // If curr is the head
              if (curr == head) {
                  head = curr.next;
                  if (head != null) head.prev = null;
              }
              // If curr is in the middle
              else if (curr.next != null) {
                  curr.prev.next = curr.next;
                  curr.next.prev = curr.prev;
              }
              // If curr is the last node (tail)
              else {
                  curr.prev.next = null;
              }
          }
          curr = curr.next;
      }
      return head;
  }

  // Helper function to print the list
  public static void printList(Node head) {
      Node temp = head;
      while (temp != null) {
          System.out.print(temp.value + " <=> ");
          temp = temp.next;
      }
      System.out.println("null");
  }

  public static void main(String[] args) {
      Node head = new Node(10);
      head.next = new Node(20);
      head.next.prev = head;
      head.next.next = new Node(30);
      head.next.next.prev = head.next;
      head.next.next.next = new Node(20);
      head.next.next.next.prev = head.next.next;
      head.next.next.next.next = new Node(40);
      head.next.next.next.next.prev = head.next.next.next;

      System.out.println("Original DLL:");
      printList(head);

      int key = 20;
      head = deleteOccurrences(head, key);

      System.out.println("DLL after deleting occurrences of " + key + ":");
      printList(head);
  }
}
