class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int prev = nums[0];
        int c = 0;
        int f = 1;
        int res = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == prev)
                c++;
            else
            {
                if(c > f)
                {
                    res = prev;
                    f = c;
                }
                prev = nums[i];
                c = 1;
            }
        }
        if(c > f)
            res = prev; 
        return res;
    }
}