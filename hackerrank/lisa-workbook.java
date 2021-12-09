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
     * Complete the 'workbook' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY arr
     */

    public static int workbook(int n, int k, List<Integer> arr) {
    int page = 1;
    int count=0;
    int j;
    for(int i=0;i<n;i++)
    {
            int max = arr.get(i)/k; 
            for(j=1;j<=max;j++)
            {
                if(page<=j*k && page>j*k-k)
                {
                    count++; 
                    System.out.println("l1 " + count + " Page " + page + " Element " + arr.get(i)); 
                } 
                page++; 
            }
            if(arr.get(i)%k!=0 && page>(max*k) && page<=arr.get(i)) 
            {
                count++; 
                System.out.println("l2 " + count + " Page " + page + " Element " + arr.get(i)); 
            } 
            if(arr.get(i)%k!=0)
                page++; 
    }
    System.out.println(page);
    return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
