class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int[] cnt = new int[26];
        char[] a = s.toCharArray();
        for(char c : a)
            cnt[c - 'a']++;
        boolean[] vst = new boolean[26];
        for(char c : a){
            cnt[c - 'a']--;
            if(vst[c - 'a'])
                continue;
            while(!st.isEmpty() && st.peek() > c && cnt[st.peek() - 'a'] > 0)
            {
                vst[st.pop() - 'a'] = false;
            }
            st.push(c);
            vst[c - 'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        for(char c : st)
            res.append(c);
        return res.toString();
    }
}