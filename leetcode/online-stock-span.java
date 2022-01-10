import java.util.*;

class StockSpanner {
    
    Stack<Integer> s;
    int i;
    List<Integer> l;

    public StockSpanner() {
        s = new Stack<Integer>();
        l = new ArrayList<Integer>();
        i = -1; 
    }
    
    public int next(int price) {
        int res = 1;
        i++;
        l.add(price);
        while(!s.isEmpty() && l.get(s.peek()) <= price)
        {
            s.pop();
        }
        if(s.isEmpty())
        {
            res = i + 1;
        }
        else
        {
            res = i - s.peek();
        }
        s.push(i);
        return res;
    }
}