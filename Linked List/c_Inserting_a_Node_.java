import java.util.Scanner;

class Node {
  int data;
  Node next;

  Node(int newData) {
     this.data = newData;
     this.next = null;
  }
}
public class c_Inserting_a_Node_ {
  public static Node insertAtHead(Node head, int x){
    Node newNode = new Node(x);
    if(head == null){
      return newNode;
    }
    newNode.next = head;
    return newNode;
  }

  public static Node insertAtEnd(Node head, int x){
    Node newNode = new Node(x);
    Node temp = head;
    while(temp.next != null){
      temp = temp.next;
    }
    temp.next = newNode;
    return head;
  }

  public static Node insertAtAnyPosition(Node head, int x, int position){
    Node newNode = new Node(x);
    // Base cases
    if(position == 1){
      newNode.next = head;
      return newNode;
    }

    Node temp = head;
    for(int i = 0; i < (position-1) && (temp != null); i++){
      temp = temp.next;
    }
    // edge cases
    if(temp == null){
      System.out.println("Position out of bounds");
      return head;
    }

    newNode.next = temp.next;
    temp.next = newNode;

    return head;
  }

  public static boolean searchNode(Node head, int val){
    while(head != null){
      if(head.data == val){
        return true;
      }
      head = head.next;
    }
    return false;
  }

  public static void printList(Node head){
    while(head != null){
      System.out.print(head.data+" ");
      head = head.next;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(50);

    Scanner sc = new Scanner(System.in);
    // System.out.println("Enter the value of x: ");
    // int x = sc.nextInt();

    // Node ans = insertAtHead(head, x);

    // Node ans = insertAtEnd(head, x);

    // System.out.println("Enter the position on which you want to insert:");
    // int position = sc.nextInt();

    // Node ans = insertAtAnyPosition(head, x, position);

    System.out.println("Enter the Node value that you want to search: ");
    int val = sc.nextInt();

    boolean ans = searchNode(head, val);

    // printList(ans);
    System.out.println(ans);

    sc.close();
  }
}
