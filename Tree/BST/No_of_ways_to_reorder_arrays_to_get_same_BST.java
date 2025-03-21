import java.util.*;

public class No_of_ways_to_reorder_arrays_to_get_same_BST {
    
    static List<List<Integer>> validPermutations = new ArrayList<>();
    
    public static int numOfWays(int[] nums) {
        List<Integer> originalList = new ArrayList<>();
        for (int num : nums) originalList.add(num);
        
        TreeNode originalBST = constructBST(originalList);  // Build BST from original array
        
        // Generate all permutations
        permute(nums, 0, originalBST);
        
        return validPermutations.size() - 1;  // Exclude the original order
    }
    
    private static void permute(int[] nums, int index, TreeNode originalBST) {
        if (index == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) perm.add(num);
            
            TreeNode newBST = constructBST(perm);
            if (isSameBST(originalBST, newBST)) {
                validPermutations.add(new ArrayList<>(perm));
            }
            return;
        }
        
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permute(nums, index + 1, originalBST);
            swap(nums, i, index);  // Backtrack
        }
    }
    
    private static TreeNode constructBST(List<Integer> nums) {
        TreeNode root = null;
        for (int num : nums) {
            root = insertIntoBST(root, num);
        }
        return root;
    }
    
    private static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }
    
    private static boolean isSameBST(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null || root1.val != root2.val) return false;
        return isSameBST(root1.left, root2.left) && isSameBST(root1.right, root2.right);
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3};  // Example Input
        System.out.println("Number of ways: " + numOfWays(nums));  // Output: 1

        int[] nums2 = {3, 4, 5, 1, 2}; 
        System.out.println("Number of ways: " + numOfWays(nums2));  // Output: 5
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}
