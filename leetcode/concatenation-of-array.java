class Solution {
    public int[] getConcatenation(int[] nums) {
        int l = nums.length;
        int[] res = new int[2*l];
        for(int i=0;i<l;i++)
        {
            res[i] = nums[i];
            res[i+l] = nums[i];
        }
        return res;
    }
}