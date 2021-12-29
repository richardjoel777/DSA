package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'beautifulBinaryString' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING b as parameter.
     */

    public static int beautifulBinaryString(String b) {
    int i=0;
    int flag=0;
    int res=0;
    int n = b.length();
    while(i<n-2)
    {
        if(b.charAt(i) == '0' && b.charAt(i+1) == '1' && b.charAt(i+2) == '0' && i<n-2)
        {
            res++;
            if(i<n-5 && b.charAt(i+3) == '1' && b.charAt(i+4) == '0')
                i = i+4;
            else
                i++;
        }
        else
        i++;
    }
    return res;
    }

}