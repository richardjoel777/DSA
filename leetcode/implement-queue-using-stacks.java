package leetcode;

import java.util.*;

class MyQueue {
    
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(s2.empty())
            s2.push(x);
        else
        {
            while(!s2.empty())
            {
                s1.push(s2.pop());
            }
            s2.push(x);
            while(!s1.empty())
            {
                s2.push(s1.pop());
            }
        }
    }
    
    public int pop() {
        return s2.pop();
    }
    
    public int peek() {
        return s2.peek();
    }
    
    public boolean empty() {
        return (s1.empty() && s2.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */