class Solution {
    ArrayList<Integer> list=new ArrayList<>();
    int count=0;
    public void recoverTree(TreeNode root) {
        inorder(root);
        Collections.sort(list); // Sorting the list 
        insertinorder(root);
        
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val); // Adding to the list
        inorder(root.right);
    }
	public void insertinorder(TreeNode root){
        if(root==null){
            return;
        }
        insertinorder(root.left);
        root.val=list.get(count); // Changing the value of the node as per the sorted list
        count++;
        insertinorder(root.right);
    }
}