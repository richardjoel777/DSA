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
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
    for(int i=1;i<grid.size()-1;i++)
    {
        for(int j=1;j<grid.get(i).length()-1;j++)
        {
            char temp = grid.get(i).charAt(j);
            if(grid.get(i-1).charAt(j)!='X' && grid.get(i-1).charAt(j) < temp && grid.get(i).charAt(j+1)!='X' && grid.get(i).charAt(j+1) < temp &&grid.get(i).charAt(j-1)!='X' && grid.get(i).charAt(j-1) < temp && grid.get(i+1).charAt(j)!='X' && grid.get(i+1).charAt(j) < temp)
            {
                char[] chars = grid.get(i).toCharArray();
                chars[j] = 'X';
                grid.set(i, String.valueOf(chars));
            }
        }
    }
    return grid;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
