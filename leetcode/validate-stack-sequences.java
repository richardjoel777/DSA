class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j=0;
        st.push(pushed[j++]);
        int n = popped.length;
        for(int i=0;i<n;i++)
        {
            if(!st.isEmpty() && st.peek() == popped[i])
                    st.pop();
            else if(j < n)
            {
                    while(j<n && pushed[j] != popped[i])
                        st.push(pushed[j++]);
                    if(j >= n)
                        return false;
                    st.push(pushed[j++]);  
                    st.pop();
            }
            else
                return false;
        }
        return true;
    }
}