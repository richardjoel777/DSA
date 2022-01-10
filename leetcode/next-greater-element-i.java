import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<Integer>();
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums2.length; i++)
        {
            while(!s.isEmpty() && nums2[i] > s.peek())
                hs.put(s.pop(), nums2[i]);
            s.push(nums2[i]);
        }
        for(int i=0;i<nums1.length; i++)
            nums1[i] = hs.getOrDefault(nums1[i], -1);
        return nums1;
    }
}