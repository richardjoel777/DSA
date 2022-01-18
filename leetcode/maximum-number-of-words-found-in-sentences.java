class Solution {
    public int mostWordsFound(String[] sentences) {
        int res = Integer.MIN_VALUE;
        for(String s : sentences)
        {
            int temp = 1;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i) == ' ')
                    temp++;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}