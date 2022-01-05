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
    
    public boolean func(TreeNode root, int k)
    {
        if(root == null)
            return true;
        return (root.val == k && func(root.right, k) && func(root.left, k));
    }
    
    public boolean isUnivalTree(TreeNode root) {
        return func(root, root.val);
    }
}