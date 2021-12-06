import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
        int i,n,spCount = 0;
        n = b.length();
        int count[] = new int[26];
        char c;
        for(i=0;i<n;i++)
        {
            c = b.charAt(i);
            if(c=='_')
                spCount++;
            else
                count[c-'A']++;
        }
        for(i=0;i<26;i++)
        {
            if(count[i]==0 || count[i]>1)
                continue;
            else
                return "NO";   
        }
        if(spCount>0)
            return "YES";
        else
        {
            for(i=0;i<n-1;i++)
                if(b.charAt(i)!=b.charAt(i+1) && b.charAt(i+1) != b.charAt(i+2))
                    return "NO";
        }
        return "YES";
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
