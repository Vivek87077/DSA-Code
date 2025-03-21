class Node{
  int data;
  Node next;

  Node(int newData){
    this.data = newData;
    this.next = null;
  }
}

public class b_Length_of_LL_ {
  public static int printLength(Node head){
    int cnt = 0;
    while(head != null){
      cnt++;
      head = head.next;
    }
    return cnt;
  }
  
  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(50);

    System.out.println(printLength(head));
  }
}
