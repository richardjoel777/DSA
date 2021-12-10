class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(hs.containsKey(nums[i]))
                res[i] = hs.get(nums[i]);
            else
            {
                int count=0;
                for(int j=0;j<nums.length;j++)
                {
                    if(nums[j]<nums[i])
                        count++;
                }
                res[i] = count;
                hs.put(nums[i], count);
            }
        }
        return res;
    }
}