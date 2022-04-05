class Solution {
    
    public void f(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] freq) {
        if(temp.size() == nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]) {
                freq[i] = true;
                temp.add(nums[i]);
                f(nums, temp, res, freq);
                temp.remove(temp.size() - 1);
                freq[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        f(nums, temp, res, freq);
        return res;
    }
}


//SWAP METHOD

// class Solution {
    
//     public void f(int ind, int[] nums, List<List<Integer>> res)
//     {
//         if(ind == nums.length)
//         {
//             List<Integer> temp = new ArrayList<>();
//             for(int i : nums)
//                 temp.add(i);
//             res.add(temp);
//             return;
//         }
//         for(int i=ind;i<nums.length;i++){
//             swap(ind, i, nums);
//             f(ind+1, nums, res);
//             swap(ind, i, nums);
//         }
//     }
    
//     private void swap(int i, int j, int[] nums){
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
    
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         f(0, nums, res);
//         return res;
//     }
// }