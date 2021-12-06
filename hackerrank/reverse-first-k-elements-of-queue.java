import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> p = new LinkedList<Integer>();
        Stack<Integer> s = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int temp;
        for(int i=0;i<n;i++)
        {
            temp = sc.nextInt();
            if(i<k)
            {
                s.push(temp);
            }
            else
                p.add(temp);
        }
        // System.out.println(s);
        // System.out.println(p);
        for(int i=0;i<k;i++)
        {
            q.add(s.pop());
        }
        for(int i=k;i<n;i++)
        {
            q.add(p.poll());
        }
        for(int i : q)
        {
            System.out.print(i + " ");
        }
    }
}