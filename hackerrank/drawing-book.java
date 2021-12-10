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
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
    if(p==1 || (n%2==0 && p==n) || (n%2!=0 && (p==n || p==n-1)))
        return 0;
    int end = n%2==0 ? n-1 : n-2;
    int count=0;
    int r1,r2;
    for(int i=2;i<=end;i+=2)
    {
        count++;
        if(p==i || p==i+1)
            break;
    }
    r1=count;
    count=0;
    for(int i=end;i>=2;i-=2)
    {
        count++;
        if(p==i || p==i-1)
        {
            break;
        }
    }
    r2=count;
    return Math.min(r1,r2);
}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
