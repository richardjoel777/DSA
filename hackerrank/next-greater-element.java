import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int[] l = new int[100];
        int[] res = new int[100];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        { 
            l[i] = sc.nextInt();
        }
        int max;
        for(int i=0;i<n-1;i++)
        {
            max = -1;
            for(int j=i+1;j<n;j++)
            {
                if(l[i] < l[j])
                {
                    max = l[j];
                    break;
                }
            }
            res[i] = max;
        }
        res[n-1] = -1;
        for(int i=0;i<n;i++)
        {
            System.out.print(res[i] + " ");
        }
    }
}