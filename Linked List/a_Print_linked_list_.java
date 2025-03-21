class Node{
  int data;
  Node next;
  
  Node(int newData){
    this.data = newData;
    this.next = null;
  }
}
public class a_Print_linked_list_{
  // Iterative Approach
  public static void printList(Node head){
    while(head != null){
      System.out.print(head.data+" ");
      head = head.next;
    }
  }
  // Using Recursive Approach 
  public static void printList2(Node head){
    if(head == null){
      return;
    }
    System.out.print(head.data+" ");
    printList2(head.next);
  }
  public static void main(String[] args) {
    System.out.println("Linked list are: ");
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);

    // printList(head);
    printList2(head);
  }
}