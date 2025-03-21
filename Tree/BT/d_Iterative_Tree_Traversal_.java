import java.util.*;

public class d_Iterative_Tree_Traversal_ {
  static class Node{
    int data;
    Node left, right;

    Node(int newData){
      this.data = newData;
      this.left = null;
      this.right = null;
    }
  }

  public static ArrayList<Integer> preOrder(Node root){
    ArrayList<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Stack<Node> st = new Stack<>();
    st.push(root);
    while(!st.isEmpty()){
      root = st.pop();
      list.add(root.data);

      if(root.left != null) st.push(root.left);
      if(root.right != null) st.push(root.right);
    }
    return list;
  }

  public static ArrayList<Integer> postOrder(Node root){
    ArrayList<Integer> postorder = new ArrayList<>();

    if (root == null) {
        return postorder;
    }

    Stack<Node> st1 = new Stack<>();
    Stack<Node> st2 = new Stack<>();

    st1.push(root);

    while (!st1.empty()) {
        root = st1.pop();

        st2.push(root);

        if (root.left != null) {
            st1.push(root.left);
        }

        if (root.right != null) {
            st1.push(root.right);
        }
    }

    while (!st2.empty()) {
        postorder.add(st2.pop().data);
    }

    return postorder;
}
  

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    ArrayList<Integer> preOrder = preOrder(root);
    for(int num : preOrder){
      System.out.print(num + " ");
    }

    System.out.println();
    
    ArrayList<Integer> result = postOrder(root);
    System.out.print("Postorder traversal: ");
    for(int num : result){
      System.out.print(num + " ");
    }

    System.out.println();
  }
}
