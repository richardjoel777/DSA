class Solution {
    
    void join(int i, List<Integer> l, List<Integer> temp, int k, List<List<Integer>> res)
    {
        // System.out.println(i + " " + temp);
        if(temp.size() == k)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(i>= l.size())
            return;
        temp.add(l.get(i));
        join(i+1, l, temp, k, res);
        temp.remove(temp.size() - 1);
        join(i+1, l, temp, k, res);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>(n);
        for(int i=1; i<= n; i++)
            l.add(i);
        // System.out.println(l);
        join(0, l, new ArrayList<>(), k, res);
        return res;
    }
}