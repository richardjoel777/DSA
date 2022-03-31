class Solution {
    
    public void f(int[] c,int i, int t, List<Integer> temp, List<List<Integer>> res) {
        if(i == c.length)
        {
            if(t == 0)
                res.add(new ArrayList(temp));
            return;
        }
        if(c[i] <= t)
        {
            temp.add(c[i]);
            f(c, i, t - c[i], temp,  res);
            temp.remove(temp.size() - 1);
        }
        f(c, i+1, t, temp, res);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(candidates, 0, target, temp, res);
        return res;
    }
}