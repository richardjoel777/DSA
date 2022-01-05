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
    
    public int res;
    
    public void func(TreeNode root, List<Integer> prev)
    {
        if(root.right == null && root.left == null)
        {
            prev.add(root.val);
            String bin = prev.stream().map(Object::toString)
                        .collect(Collectors.joining(""));
            System.out.println(prev);
            res += Integer.parseInt(bin,2);
            return;
        }
        if(root.right != null && root.left != null)
        {
            List<Integer> t1 = new ArrayList<Integer>(prev);
            t1.add(root.val);
            List<Integer> t2 = new ArrayList<Integer>(prev);
            t2.add(root.val);
            func(root.right, t1);
            func(root.left,t2);
            return;
        }
        if(root.left == null)
        {
            List<Integer> t = new ArrayList<Integer>(prev);
            t.add(root.val);
            func(root.right,t);
            return;
        }
        if(root.right == null)
        {
            List<Integer> t = new ArrayList<Integer>(prev);
            t.add(root.val);
            func(root.left,t);
            return;
        }
        
    }
    
    public int sumRootToLeaf(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        func(root,l);
        return res;
    }
}