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
     * Complete the 'isWinning' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING config
     */
    
    public static int nim[] = new int[301];
    public static int mex(List<Integer> arr)
    {
        int mex=0;
        while(arr.contains(mex))
            mex++;
        return mex;
    }
    public static int grundy(int n)
    {
        if(nim[n]!=0)
            return nim[n];
        if(n==0)
        {
            nim[n] = 0;
            return 0;
        }
        if(n==1)
        {
            nim[n] = 1;
            return 1;
        }
        if(n==2)
        {
            nim[n] = 2;
            return 2;
        }
        
        List<Integer> glist = new ArrayList<>();
        int i,j,k,x,y;
        for(i=0,j=0,k=0;i<=n;i++)
        {
            if(i<=n/2)
            {
                x = grundy(j);
                y = grundy(n-j-2);
                j++;
            }
            else
            {
                x = grundy(k);
                y = grundy(n-k-1);
                k++;
            }
            glist.add(x^y);
        }
        nim[n] = mex(glist);
        return nim[n];
        
    }
    public static String isWinning(int n, String config) {
        List<Integer> list = new ArrayList<>();
        int count = 0,i,result=0;
        for(i=0;i<n;i++)
        {
            if(config.charAt(i)!='X')
                count++;
            else
            {
                if(count!=0)
                    list.add(count);
                count = 0;
            }
        }
        if(count>0)
            list.add(count);
        for(i=0;i<list.size();i++)
        {
            result ^= grundy(list.get(i));
        }
        
        return result<=0?"LOSE":"WIN";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String config = bufferedReader.readLine();

                String result = Result.isWinning(n, config);

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
