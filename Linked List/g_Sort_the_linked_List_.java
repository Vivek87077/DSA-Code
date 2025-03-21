import java.util.ArrayList;
import java.util.Collections;
class Node{
  int data;
  Node next;

  Node(int newData){
    this.data = newData;
    this.next = null;
  }
}
public class g_Sort_the_linked_List_ {
  // Sort the linked list with the use of JAVA inBuilt Library
  public static Node sortList(Node head){
    ArrayList<Integer> arr = new ArrayList<>();
    Node temp = head;

    while(temp != null){
      arr.add(temp.data);
      temp = temp.next;
    }

    Collections.sort(arr);

    temp = head;
    for(int i = 0; i < arr.size(); i++){
      temp.data = arr.get(i);
      temp = temp.next;
    }

    return head;
  }

  // sort the list with the help of recursion
  public static Node sortListRecursion(Node head){
    if(head == null || head.next == null){
      return head;
    }

    Node curr = head;
    Node move = head.next;

    head.next = null;
    move = sortListRecursion(move);
    if(move == null || curr.data <= move.data){
      curr.next = move;
      return curr;
    }
    else{
      Node prev = move;
      while((prev.next != null) && (curr.data < prev.data)){
        prev = prev.next;
      }
      Node temp = prev.next;
      prev.next = curr;
      curr.next = temp;
    }
    return move;
  }


  public static void printList(Node head){
    while(head != null){
      System.out.print(head.data+" ");
      head = head.next;
    }
  }
  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(30);
    head.next.next = new Node(50);
    head.next.next.next = new Node(20);
    head.next.next.next.next = new Node(40);

    printList(head);
    System.out.println();

    // Node ans = sortList(head);

    Node ans = sortListRecursion(head);
    printList(ans);
  }
}
