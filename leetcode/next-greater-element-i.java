class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<Integer>();
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        s.push(nums2[0]);
        for(int i = 1;i<nums2.length; i++)
        {
            if(nums2[i] > s.peek())
            {
                while(!s.isEmpty() && nums2[i] > s.peek())
                    hs.put(s.pop(), nums2[i]);
            }
            s.push(nums2[i]);
        }
        while(!s.isEmpty())
            hs.put(s.pop(), -1);
        for(int i=0;i<nums1.length; i++)
            nums1[i] = hs.get(nums1[i]);
        return nums1;
    }
}