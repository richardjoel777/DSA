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
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
    HashMap<String, Integer> hs = new HashMap<String,Integer>();
    List<Integer> res = new ArrayList<>(queries.size());
    for(String s : strings)
    {
        if(hs.containsKey(s))
            hs.put(s, hs.get(s) + 1);
        else
            hs.put(s, 1);
    }
    for(String s : queries)
    {
        if(hs.containsKey(s))
            res.add(hs.get(s));
        else
            res.add(0);
    }
    return res;
    }

}