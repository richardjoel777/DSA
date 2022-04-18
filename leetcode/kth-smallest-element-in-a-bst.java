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
    
    private int ind = 1;
    private int res = 0;
    
    private void f(TreeNode root, int k)
    {
        if(root == null)
            return;
        f(root.left, k);
        if(ind == k)
        {
            res = root.val;
        }
        ind++;
        f(root.right, k);
    }
    
    
    public int kthSmallest(TreeNode root, int k) {
        f(root, k);
        return res;
    }
}