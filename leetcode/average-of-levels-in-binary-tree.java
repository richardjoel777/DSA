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
    
    public void kthNodes(TreeNode root, int k, ArrayList<Integer> list)
    {
        if (root == null)
            return;
        if (k == 0) {
            list.add(root.val);
            return;
        }
        kthNodes(root.left, k - 1, list);
        kthNodes(root.right, k - 1, list);
    }
    
    public Double avg(int k, TreeNode root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        kthNodes(root, k, list);
        return list.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }
    
    public boolean isLeaf(TreeNode node)
    {
        if(node.right == null && node.left == null)
            return true;
        return false;
    }
    
    public int height(TreeNode root)
    {
        if(root==null)
            return -1;
        if(isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.right), height(root.left)); 
    }
    
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        int height = height(root);
        for(int i = 0; i <= height; i++) 
            res.add(avg(i, root));
        return res;
    }
}