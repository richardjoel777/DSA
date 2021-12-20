import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] sh = new char[26];
        char[] ph = new char[26];
        if(p.length()>s.length())
            return res;
        int right=0,left=0;
        for(int i=0;i<p.length();i++)
        {
            sh[s.charAt(right)-'a']++;
            ph[p.charAt(right)-'a']++;
            right++;
        }
        right--;
        while(right<s.length())
        {
            if(Arrays.equals(sh,ph))
                res.add(left);
            right++;
            if(right!=s.length())
                sh[s.charAt(right)-'a']++;
            sh[s.charAt(left)-'a']--;
            left++;
        }
        return res;
    }
}