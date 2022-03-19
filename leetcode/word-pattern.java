class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] w = s.split(" ");
        if(pattern.length() != w.length)
            return false;
        Map<Character, String> hs = new HashMap<>();
        for(int i=0;i<w.length;i++)
        {
            if(!hs.containsValue(w[i]) && !hs.containsKey(pattern.charAt(i)))
                hs.put(pattern.charAt(i), w[i]);
            if(!w[i].equals(hs.get(pattern.charAt(i))))
                return false;
        }
        return true;
    }
}