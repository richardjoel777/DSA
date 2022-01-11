import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        Queue<Character> q = new LinkedList<Character>();
        char temp;
        for(int i=0;i<s.length();i++)
        {
            q.offer(s.charAt(i));
        }
        for(int i=0;i<s.length();i++)
        {
            temp = q.poll();
            if(!q.contains(temp))
                return s.indexOf(temp);
            else
                q.offer(temp);
        }
        return -1;
    }
}