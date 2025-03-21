import java.util.*;

public class c_Level_order_Traversal_ {
  static class Node{
    int data;
    Node left, right;

    Node(int newData){
      this.data = newData;
      this.left = null;
      this.right = null;
    }
  }

  public static ArrayList<ArrayList<Integer>> levelOrder(Node root){
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
      int size = q.size();
      ArrayList<Integer> level = new ArrayList<>();
      for(int i = 0; i < size; i++){
        Node node = q.poll();
        level.add(node.data);

        if(node.left != null) q.add(node.left);
        if(node.right != null) q.add(node.right);
      }
      ans.add(level);
    }
    return ans;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.right = new Node(5);

    ArrayList<ArrayList<Integer>> result = levelOrder(root);
    for(ArrayList<Integer> num : result){
      System.out.print(num + " ");
    }
  }
}
