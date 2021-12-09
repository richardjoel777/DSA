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
     * Complete the 'fairRations' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static String fairRations(List<Integer> B) {
    int n = B.size();
    int[] l = new int[n];
    for(int i=0;i<n;i++)
    {
        l[i] = B.get(i);
    }
    int count=0;
    for(int i=0;i<n;i++)
    {
        if(i==0 && l[i]%2!=0)
        {
                l[i]++;
                l[i+1]++;
                count+=2;
                continue;
        }
        if(i==n-1 && l[i]%2!=0)
        {
            return "NO";
        }  
        if(l[i]%2!=0)
        {
            if(l[i-1]%2!=0)
            {
                l[i]++;
                l[i-1]++;
                count+=2;
            }
            else
            {
                l[i]++;
                l[i+1]++;
                count+=2;
            }
        }
    }
    return String.valueOf(count);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
