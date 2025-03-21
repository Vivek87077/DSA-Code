import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class m_Two_sum_in_BST_ {
    
    // Perform inorder traversal and store elements in a list
    private static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Two-pointer approach to find two numbers that sum to target
    private static boolean findTwoSum(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == target) return true;
            else if (sum < target) left++;  // Increase sum
            else right--;  // Decrease sum
        }
        return false;
    }

    // Main function to check if there exists a pair with the given sum in BST
    public static boolean findTarget(TreeNode root, int target) {
        List<Integer> sortedList = new ArrayList<>();
        
        // Get inorder traversal (sorted values)
        inorder(root, sortedList);
        
        // Use two-pointer approach to check if any two numbers sum to target
        return findTwoSum(sortedList, target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int target = 9;

        if (findTarget(root, target)) {
            System.out.println("Two nodes found with sum = " + target);
        } else {
            System.out.println("No pair found with sum = " + target);
        }
    }
}
