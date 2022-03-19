class Solution {
    public void moveZeroes(int[] nums) {
        int r=0,l=0;
        while(r<nums.length)
        {
            if(r == l)
                r++;
            else
            {
                if(nums[l] == 0 && nums[r] != 0)
                {
                    int temp = nums[r];
                    nums[r] = nums[l];
                    nums[l] = temp;
                    l++;
                    r++;
                    continue;
                }
                if(nums[l] != 0)
                    l++;
                if(nums[r] == 0)
                    r++;
                }
        }
    }
}