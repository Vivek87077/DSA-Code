import java.util.Scanner;

class Node {
  int data;
  Node next;

  Node(int newData) {
    this.data = newData;
    this.next = null;
  }
}

public class d_Deleting_a_Node_ {

  // Delete from head
  public static Node deletingFromHead(Node head) {
    if (head == null) {
      System.out.println("List is already empty.");
      return null;
    }
    return head.next; // Move head to the next node
  }

  // Delete from end
  public static Node deletingFromEnd(Node head) {
    if (head == null || head.next == null) {
      return null; // If list has 0 or 1 node, return null (empty list)
    }
    Node temp = head;
    while (temp.next.next != null) { // Traverse to the second last node
      temp = temp.next;
    }
    temp.next = null; // Remove the last node
    return head;
  }

  // Delete from any position
  public static Node deletingFromAnyPosition(Node head, int position) {
    if (head == null) {
      System.out.println("List is empty.");
      return null;
    }

    if (position <= 0) {
      System.out.println("Invalid position. Position should be >= 1.");
      return head;
    }

    if (position == 1) {
      return head.next; // Delete head
    }

    Node temp = head;
    for (int i = 1; i < position - 1 && temp != null; i++) {
      temp = temp.next;
    }

    if (temp == null || temp.next == null) {
      System.out.println("Position out of bounds.");
      return head;
    }

    temp.next = temp.next.next; // Delete node at the position
    return head;
  }

  // Print linked list
  public static void printList(Node head) {
    if (head == null) {
      System.out.println("List is empty.");
      return;
    }
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(50);

    Scanner sc = new Scanner(System.in);
    System.out.println("Choose the operation:");
    System.out.println("1. Delete from head");
    System.out.println("2. Delete from end");
    System.out.println("3. Delete from any position");
    int choice = sc.nextInt();

    switch (choice) {
      case 1:
        head = deletingFromHead(head);
        break;
      case 2:
        head = deletingFromEnd(head);
        break;
      case 3:
        System.out.print("Enter the position to delete: ");
        int position = sc.nextInt();
        head = deletingFromAnyPosition(head, position);
        break;
      default:
        System.out.println("Invalid choice.");
    }

    System.out.println("Updated List:");
    printList(head);

    sc.close();
  }
}
