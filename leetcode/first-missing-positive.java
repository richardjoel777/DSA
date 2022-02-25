class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int f = 0;
        int prev = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] > 0)
            {
                if(f == 0)
                {
                    prev = nums[i];
                    if(prev != 1)
                        return 1;
                    f = 1;
                }
                else
                {
                    if(nums[i] != prev && nums[i]-prev != 1)
                        return prev+1;
                    prev = nums[i];
                }
            }
        }
        if(f == 0)
            return 1;
        return nums[nums.length-1]+1;
    }
}