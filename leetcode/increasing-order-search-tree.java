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
    
    TreeNode curr;
    
    public void func(TreeNode root)
    {
        if(root == null)
            return;
        func(root.left);
        curr.right = new TreeNode(root.val);
        curr = curr.right;
        func(root.right);
    }
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(-1);
        curr = res;
        func(root);
        return res.right;
    }
}