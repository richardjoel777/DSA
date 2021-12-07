class Solution {
    public String restoreString(String s, int[] indices) {
        int n;
        n = s.length();
        char res[] = new char[n];
        for(int i=0;i<n;i++)
        {
            res[indices[i]] = s.charAt(i);
        }
        return String.valueOf(res);
    }
}