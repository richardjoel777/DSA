import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
           int n,m;
        List<Integer> l = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        if(n==m)
        {
            System.out.println("0");
        }
        else
        {
        for(int i=0;i<m;i++)
        {
            l.add(sc.nextInt());
        }
        Collections.sort(l);
        int max = Math.max(l.get(0), n-l.get(l.size()-1)-1);
        for(int i=1;i<m;i++)
        {
            int d = l.get(i) - l.get(i-1);
            max = Math.max(d/2, max);
        }
        System.out.println(max);
        }
    }
}