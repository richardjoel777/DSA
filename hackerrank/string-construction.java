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
     * Complete the 'stringConstruction' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int stringConstruction(String s) {
    Set<Character> st = new HashSet<>();
    for(int i=0;i<s.length();i++)
    {
            st.add(s.charAt(i));
    }
    return st.size();
    }

}
