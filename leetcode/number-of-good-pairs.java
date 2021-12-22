class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> hs = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(hs.containsKey(nums[i]))
                hs.put(nums[i], hs.get(nums[i])+1);
            else
                hs.put(nums[i], 1);
        }
        int res=0;
        for(Integer c : hs.values() )
        {
            if(c>1)
            {
                res+= ((c-1)*(c))/2;
            }
        }
        return res;
    }
}