import java.util.*;
import java.io.*;

class Main
{
    public static void pat(char[] s, int[] lps) 
    {
        int j=0,i=1;
		lps[0] = 0;
		while(i<s.length)
		{
		    if(s[j] == s[i])
		    {
		        j++;
		        lps[i] = j;
		        i++;
		    }
		    else
		    {
		        if(j==0)
		        {
		            lps[i]=0;
		            i++;
		        }
		        else
		        {
		            j = lps[j-1];
		        }
		    }
		}
    }
    
	public static void main(String[] args) {
		char[] p = "AB".toCharArray();
		char[] s = "AAAAABAAABA".toCharArray();
		System.out.println(String.valueOf(p) + " " + String.valueOf(s));
		int i=0,j=0;
		int n = p.length;
		int m = s.length;
		int[] lps = new int[n];
		pat(p, lps);
// 		for(int k=0;k<n;k++)
// 		{
// 		    System.out.print(lps[k]);
// 		}
		while(i < m)
		{
		    if(p[j] == s[i])
		    {
		        i++;
		        j++;
		    }
		    if(j == n)
		    {
		        System.out.println("Pattern found at : " + (i-j));
		        j = lps[j-1];
		    }
		    else if(i<m && p[j] != s[i])
		    {
		        if(j!=0)
		            j = lps[j-1];
		        else
		            i++;
		    }
		}
	}
}
