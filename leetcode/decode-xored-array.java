class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length+1];
        res[0] = first;
        int k=1;
        for(int i=0;i<encoded.length;i++)
        {
            res[k++] = res[i]^encoded[i];
        }
        return res;
    }
}