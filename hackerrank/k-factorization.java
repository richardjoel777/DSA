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
     * Complete the 'kFactorization' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY A
     */

    public static List<Integer> kFactorization(int n, List<Integer> A) {
        List<Integer> result = new ArrayList<>();
        if(n==1)
        {
            result.add(1);
            return result;
        }
        List<Integer> r = new ArrayList<>();
        for(int i:A)
        {
            if(n%i==0)
            {
                r = kFactorization(n/i,A);
                if(r.get(0)==-1)
                {
                    result.add(-1);
                    return result;
                }
                result.add(n);
                result.addAll(r);
                return result;
            }
        }
        
        result.add(-1);
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
            
        Collections.sort(A, Collections.reverseOrder());
        List<Integer> result = Result.kFactorization(n, A);
        Collections.sort(result);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
