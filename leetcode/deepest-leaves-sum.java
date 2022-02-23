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
    
    private int hl = 0;
    private int sum = 0;
    
    private void func(TreeNode root, int level)
    {
        if(root == null) return;
        if(level > hl)
        {
            sum = 0;
            hl = level;
        }
        if(hl == level)
            sum += root.val;
        func(root.left, level + 1);
        func(root.right, level + 1);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        if(root == null)
            return 0;
        func(root, 0);
        return sum;
    }
}