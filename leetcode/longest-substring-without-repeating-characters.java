import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<Character>();
        int r=0,l=0,max=0;
       while(r<s.length())
       {
           if(!hs.contains(s.charAt(r)))
           {
               hs.add(s.charAt(r++));
               max = Math.max(hs.size(), max);
           }
           else
           {
               hs.remove(s.charAt(l++));
           }
       }
        return max;
    }
}