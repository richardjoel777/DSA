import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
     
    public static int find(String s, String t)
    {
        char[] sh = new char[26];
        char[] ph = new char[26];
        for(int i=0;i<t.length();i++)
        {
            ph[t.charAt(i)-'a']++;
            sh[s.charAt(i)-'a']++;
        }
        return Arrays.equals(sh,ph) ? 1 : 0;
    }

    public static int sherlockAndAnagrams(String s) {
    List<String> l = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
   for (int j = i+1; j <= s.length(); j++) {
       l.add(s.substring(i,j));
   }
    }
   int count=0;
   int n = l.size();
   for(int i=0;i<n-1;i++)
   {
       for(int j=i+1;j<n;j++)
       {
           if(l.get(i).length() == l.get(j).length())
                count += find(l.get(i), l.get(j));
       }
   }
   return count;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = Result.sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
