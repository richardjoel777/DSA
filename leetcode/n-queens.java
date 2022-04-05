class Solution {
    
    public void f(int col, List<String> l, List<List<String>> res, int n)
    {
        if(col == n)
        {
            res.add(new ArrayList<>(l));
            return;
        }
        
        for(int row=0;row<n;row++)
        {
            if(isSafe(row, col, l, n))
            {
                StringBuilder temp = new StringBuilder(l.get(row));
                temp.setCharAt(col, 'Q');
                l.set(row, temp.toString());
                f(col+1, l, res, n);
                temp.setCharAt(col,'.');
                l.set(row, temp.toString());
            }
        }
    }
    
    private boolean isSafe(int row, int col, List<String> l, int n)
    {
        int r = row;
        int c = col;
        
        while(r>=0 && c >= 0)
        {
            if(l.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }
        
        r = row;
        c = col;
        while(c>=0)
        {
            if(l.get(r).charAt(c) == 'Q') return false;
            c--;
        }
        
        r = row;
        c = col;
        while(r<n && c>=0)
        {
            if(l.get(r).charAt(c) == 'Q') return false;
            r++;
            c--;
        }
        return true;
    }
    
    public List<List<String>> solveNQueens(int n) {
        String s = ".".repeat(n);
        List<String> l = new ArrayList<>(n);
        for(int i=0;i<n;i++)
            l.add(s);
        List<List<String>> res = new ArrayList<>();
        f(0, l, res, n);
        return res;
    }
}