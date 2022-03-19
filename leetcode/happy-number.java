class Solution {
    
    int f(int n)
    {
        int sum = 0;
        while(n>0)
        {
            int a = n%10;
            sum += a*a;
            n = n/10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = f(slow);
            fast = f(fast);
            fast = f(fast);
        }while(slow != fast);
        return slow == 1;
    }
}