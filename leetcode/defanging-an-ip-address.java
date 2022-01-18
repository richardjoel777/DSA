class Solution {
    public String defangIPaddr(String add) {
        StringBuffer res = new StringBuffer();
        for(int i=0;i<add.length();i++)
        {
            if(add.charAt(i) == '.')
                res.append("[.]");
            else
                res.append(add.charAt(i));
        }
        return res.toString();
    }
}