class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == '(')
                st.push(-1);
            else
            {
                if(st.peek() == -1)
                {
                    st.pop();
                    st.push(1);
                }
                else
                {
                    int tsum = 0;
                    while(st.peek() != -1)
                        tsum += st.pop();
                    st.pop();
                    st.push(tsum*2);
                }    
            }
        }
        int score = 0;
        while(!st.isEmpty())
            score += st.pop();
        return score;
    }
}