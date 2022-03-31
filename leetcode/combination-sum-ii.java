class Solution {
    
    public void f(int[] c,int ind, int t, List<Integer> temp, List<List<Integer>> res) {
       if(t == 0)
       {
            res.add(new ArrayList(temp));
            return;
        }
        for(int i = ind; i < c.length; i++)
        {
            if(i > ind && c[i] == c[i-1])
                continue;
            if(c[i] > t)
                break;
            temp.add(c[i]);
            f(c, i+1, t - c[i], temp,  res);
            temp.remove(temp.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        f(candidates, 0, target, temp, res);
        return res;
    }
}