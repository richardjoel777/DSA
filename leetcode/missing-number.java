class Solution {
    public int missingNumber(int[] nums) {
        int add=0;
        int n = nums.length;
        int sum = ((n)*(n+1))/2;
        for(int i : nums){
            add += i;
        }
        return sum-add;
    }
}