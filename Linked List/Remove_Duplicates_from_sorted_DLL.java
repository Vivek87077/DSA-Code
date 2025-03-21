class Node {
  int value;
  Node prev, next;

  Node(int value) {
      this.value = value;
      this.prev = this.next = null;
  }
}

public class Remove_Duplicates_from_sorted_DLL {

  // Function to remove duplicates from a sorted DLL
  public static Node removeDuplicates(Node head) {
      if (head == null) return null;

      Node current = head;

      while (current != null && current.next != null) {
          if (current.value == current.next.value) {
              Node duplicate = current.next;
              current.next = duplicate.next;

              if (duplicate.next != null) {
                  duplicate.next.prev = current;
              }
          } else {
              current = current.next;
          }
      }

      return head;
  }

  // Helper function to print DLL
  public static void printList(Node head) {
      Node temp = head;
      while (temp != null) {
          System.out.print(temp.value + " ⇄ ");
          temp = temp.next;
      }
      System.out.println("null");
  }

  public static void main(String[] args) {
      Node head = new Node(1);
      head.next = new Node(1);
      head.next.prev = head;
      head.next.next = new Node(2);
      head.next.next.prev = head.next;
      head.next.next.next = new Node(3);
      head.next.next.next.prev = head.next.next;
      head.next.next.next.next = new Node(3);
      head.next.next.next.next.prev = head.next.next.next;
      head.next.next.next.next.next = new Node(4);
      head.next.next.next.next.next.prev = head.next.next.next.next;

      System.out.println("Original DLL:");
      printList(head);

      head = removeDuplicates(head);

      System.out.println("DLL after removing duplicates:");
      printList(head);
  }
}
