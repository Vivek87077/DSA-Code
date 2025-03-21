
// Java to implement linked matrix 
// from a 2D matrix recursively 

class Node {
    int data;
    Node right, down;

    Node(int data) {
        this.data = data;
        this.right = null;
        this.down = null;
    }
}

public class Construct_a_LL_from_2D_Matrix_ {

    // Function to recursively construct the linked
    // matrix from a given 2D array
    static Node constructUtil(int[][] arr, int i, int j) {
      
        // Base case: if we are out of bounds, return null
        if (i >= arr.length || j >= arr[0].length) {
            return null;
        }

        // Create a new Node with the current
        // matrix value
        Node curr = new Node(arr[i][j]);

        // Recursively construct the right
        // and down pointers
        curr.right = constructUtil(arr, i, j + 1);
        curr.down = constructUtil(arr, i + 1, j);

        // Return the constructed Node
        return curr;
    }

    // Function to construct the linked 
    // matrix given a 2D array
    static Node construct(int arr[][]) {
      
        // Call the utility function starting from the 
        // top-left corner of the matrix
        return constructUtil(arr, 0, 0);
    }

    static void printList(Node head) {
        Node currRow = head;
        while (currRow != null) {
            Node currCol = currRow;
            while (currCol != null) {
                System.out.print(currCol.data + " ");
                currCol = currCol.right;
            }
            System.out.println();
            currRow = currRow.down;
        }
    }

    public static void main(String[] args) {
      
        int arr[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Node head = construct(arr);
        printList(head);
    }
}
