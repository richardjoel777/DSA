class Solution {
    
    public void f(int ind, int[] nums, List<Integer> temp, List<List<Integer>> res)
    {
        res.add(new ArrayList<>(temp));
        for(int i=ind;i<nums.length;i++)
        {
            if(i != ind && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            f(i+1, nums, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(0, nums, temp, res);
        return res;
    }
}