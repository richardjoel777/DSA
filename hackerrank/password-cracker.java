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
     * Complete the 'passwordCracker' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY passwords
     *  2. STRING loginAttempt
     */

    public static String passwordCracker(List<String> passwords, String loginAttempt) {
    HashSet<String> hs = new HashSet<String>();
    for(String i : passwords)
    {
        hs.add(i);
    }
    // System.out.println(hs);
    int n = loginAttempt.length();
    int i=0,j=1;
    int flag = 0;
    String res = "";
    while(j<=n)
    {
        String temp = loginAttempt.substring(i,j);
        // System.out.println(temp);
        if(hs.contains(temp))
        {
            res = res + loginAttempt.substring(i,j) + " ";
            flag = j;
            i = j;
            j = i+1;
        }
        else
        {
            j++;
        }
    }
    // System.out.println(res);
    if(flag==n)
        {
            return res.substring(0,res.length()-1);
        }
    return "WRONG PASSWORD";
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

                List<String> passwords = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .collect(toList());

                String loginAttempt = bufferedReader.readLine();

                String result = Result.passwordCracker(passwords, loginAttempt);

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
