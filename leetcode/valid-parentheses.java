class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                st.push(c);
            else
            {
                if(!st.isEmpty())
                {
                   char temp = st.peek();
                    
                    if((c == ')' && temp == '(') || (c == '}' && temp == '{') || (c == ']' && temp == '['))
                        st.pop();
                    else
                        return false;
                }
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}