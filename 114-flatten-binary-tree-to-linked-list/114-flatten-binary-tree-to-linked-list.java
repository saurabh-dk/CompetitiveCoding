/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);

        // prev.right = root.left;
        // while(curr != null) {
        //     curr = curr.right;
        // }
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
    
    // private TreeNode dfs(TreeNode root) {
    //     if(root == null) return null;
    //     prev = root;
    //     TreeNode left = dfs(root.left);
    //     // if()
    //     left.right = prev.right;
    //     return dfs(root.right);
    // }
}