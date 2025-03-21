// Java program to convert Binary Tree into Doubly
// Linked List where the nodes are represented spirally

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

// Function to insert node at the 
// front of DLL and return the new head
public class Convert_a_BT_into_doubly_LL_in_spiral_form_ {

    static Node push(Node head, Node node) {
        node.right = head;
        node.left = null;
        if (head != null) {
            head.left = node;
        }
        return node;
    }

    // Function to perform spiral level-order traversal
    // and convert binary tree into DLL
    static Node spiralToDLL(Node root) {
        if (root == null) return null;

        Deque<Node> dq = new ArrayDeque<>();
        dq.addFirst(root);

        Stack<Node> stk = new Stack<>();
        Node head = null;

        boolean leftToRight = true;

        // Perform spiral level order traversal
        while (!dq.isEmpty()) {
            int levelSize = dq.size();

            while (levelSize-- > 0) {
                if (leftToRight) {
                    
                    // Left-to-right traversal: pop from front
                    Node node = dq.pollFirst();

                    // Push children for next level (left to right)
                    if (node.left != null) dq.addLast(node.left);
                    if (node.right != null) dq.addLast(node.right);

                    stk.push(node);  
                } else {
                    
                    // Right-to-left traversal: pop from back
                    Node node = dq.pollLast();

                    // Push children for next level (right to left)
                    if (node.right != null) dq.addFirst(node.right);
                    if (node.left != null) dq.addFirst(node.left);
                    
                    stk.push(node);  
                }
            }
            leftToRight = !leftToRight;
        }

        // Pop nodes from stack and form the DLL
        while (!stk.isEmpty()) {
            Node node = stk.pop();
            
            // Insert node at the front of DLL and update head
            head = push(head, node); 
        }
        
        // Return the head of the created DLL
        return head; 
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
      
        // Example tree:
        //          1
        //        /   \
        //       2     3
        //      / \   / \
        //     4   5 6   7
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node head = spiralToDLL(root);
        printList(head);
    }
}
