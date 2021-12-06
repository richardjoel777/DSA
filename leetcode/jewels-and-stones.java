import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> s = new HashSet<Character>();
        int count=0;
        for(int i=0;i<jewels.length();i++)
        {
            s.add(jewels.charAt(i));
        }
        for(int i=0;i<stones.length();i++)
        {
            if(s.contains(stones.charAt(i)))
                count++;
        }
        return count;
    }
}