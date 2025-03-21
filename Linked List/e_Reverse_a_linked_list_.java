import java.util.Stack;

class Node{
  int data;
  Node next;

  Node(int newData){
    this.data = newData;
    this.next = null;
  }
}
public class e_Reverse_a_linked_list_ {
  // Reverse a linked list using Stack approach 
  public static Node reverseListStack(Node head){
    Node temp = head;
    Stack<Integer> st = new Stack<>();
    while(temp != null){
      st.push(temp.data);
      temp = temp.next;
    }

    temp = head;
    while(!st.isEmpty()){
      temp.data = st.pop();
      temp = temp.next;
    }
    return head;
  }

  // Reverse a linked list using iterative approach 
  public static Node reverseListIterative(Node head){
    Node temp = head;
    Node prev = null;

    while(temp != null){
      Node front = temp.next;
      temp.next = prev;
      prev = temp;
      temp = front;
    }

    return prev;
  }

  // Reverse a linked list using recursive appraoch
  public static Node reverseListRecursive(Node head){
    if(head == null || head.next == null){
      return head;
    }
    Node newNode = reverseListRecursive(head.next);
    Node front = head.next;
    front.next = head;
    head.next = null;
    return newNode;
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

    // Node ans = reverseListStack(head);
    // Node ans = reverseListIterative(head);
    Node ans = reverseListRecursive(head);
    printList(ans);
  }
}
