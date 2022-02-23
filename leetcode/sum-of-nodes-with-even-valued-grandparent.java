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
    
    private int sum = 0;
    
    
    private void add(TreeNode root)
    {
        if(root.left != null && root.left.left!=null)
                sum += root.left.left.val;
        if(root.left != null && root.left.right!=null)
                sum += root.left.right.val;
        if(root.right != null && root.right.left!=null)
                sum += root.right.left.val;
        if(root.right != null && root.right.right!=null)
                sum += root.right.right.val;
    }
    
    private void func(TreeNode root)
    {
        if(root == null)
            return;
        if(root.val %2 == 0)
            add(root);
        func(root.left);
        func(root.right);
    }
    
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null)
            return 0;
        func(root);
        return sum;
    }
}