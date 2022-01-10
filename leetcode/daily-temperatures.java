import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> s = new Stack<Integer>();
        int[] res = new int[t.length];
        int temp;
        for(int i = 0; i < t.length; i++)
        {
            while(!s.isEmpty() && t[i] > t[s.peek()] )
            {
                temp = s.pop();
                res[temp] = i - temp;
            }
            s.push(i);
        }
        return res;
    }
}

