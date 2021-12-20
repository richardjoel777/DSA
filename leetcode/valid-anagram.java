import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sh = new char[26];
        char[] ph = new char[26];
        if(s.length()!=t.length())
            return false;
        for(int i=0;i<t.length();i++)
        {
            ph[t.charAt(i)-'a']++;
            sh[s.charAt(i)-'a']++;
        }
        return Arrays.equals(sh,ph);
    }
}