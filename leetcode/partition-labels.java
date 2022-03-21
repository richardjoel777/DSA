class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] a = new int[26];
        for(int i=0;i<s.length();i++)
            a[s.charAt(i) - 'a']++;
        List<Integer> res = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        if(s.length() == 1)
        {
            res.add(1);
            return res;
        }
        int st = 0;
        for(int i=0;i<s.length();i++)
        {
            a[s.charAt(i) - 'a']--;
            if(a[s.charAt(i) - 'a'] > 0)
                set.add(s.charAt(i));
            else
                set.remove(s.charAt(i));
            if(set.isEmpty())
            {
                res.add(i-st+1);
                st = i+1;
            }
        }
        return res;
    }
}