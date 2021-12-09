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
     * Complete the 'stoneDivision' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER n
     *  2. LONG_INTEGER_ARRAY s
     */

    public static long stoneDivision(long n, List<Long> s,HashMap<Long,Long> dp) {
        // System.out.println(n + " " + s + " " + dp);
        if(n==0 || n==1)
            return 0;
        if(dp.containsKey(n))
            return dp.get(n);
        long max = 0;
        for(long d:s)
        {
            long sum = 0;
            if(n%d!=0 || n==d)
                continue;
            long nofPiles = n/d;
            sum += stoneDivision(d,s,dp) * nofPiles;
            sum += 1;
            max = max>sum?max:sum;
        }
        dp.put(n,max);
       
        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                long n = Long.parseLong(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<Long> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Long::parseLong)
                    .collect(toList());
                long result = Result.stoneDivision(n, s, new HashMap<>());

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
