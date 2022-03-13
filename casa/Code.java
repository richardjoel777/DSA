import java.io.*;
import java.util.*;

class code {

    private static boolean isGainable(int ashaPower, int amarPower, List<Integer> aliens)
    {
        return ((aliens.get(0) < ashaPower && aliens.get(0) < amarPower && aliens.get(1) < ashaPower
                && aliens.get(1) < amarPower) || (aliens.get(0) > ashaPower && aliens.get(0) < amarPower && aliens.get(1) < 2*ashaPower
                && aliens.get(1) < amarPower));
    }

    static int findMaxGold(int ashaPower, int amarPower, int numOfAliens, List<Integer> aliens, List<Integer> golds)
    {
        if(numOfAliens == 2)
        {
            if (isGainable(ashaPower, amarPower, aliens)) {
                return Math.max(golds.get(0), golds.get(1));
            } else
                return 0;
        }

        else
        {
            int ratioBtwAshaAmar = ashaPower / amarPower;
            if(ratioBtwAshaAmar % 2 != 0 || ratioBtwAshaAmar != 0)
            {
                Collections.sort(golds);
                int totalGains = 0;
                for (int ind = 0; ind < numOfAliens; ind++) {
                    totalGains += golds.get(ind);
                }
                return (totalGains - golds.get(0));
            }
            else
            {
                int totalGains = 0;
                for (int ind = 0; ind < numOfAliens; ind++) {
                    totalGains += golds.get(ind);
                }
                return totalGains;
            }
            
        }
    }

  public static void main(String[] args) throws Exception {
    String input = null;

    // read input from stdin
    input = new BufferedReader(new InputStreamReader(System.in)).readLine();
    
    String[] temp = input.split(" ");
    int ashaPower = Integer.valueOf(temp[0]);
    int amarPower = Integer.valueOf(temp[1]);
    int numOfAliens = Integer.valueOf(temp[2]);

    Scanner scanner = new Scanner(System.in);

    List<Integer> aliens = new ArrayList<>();
    List<Integer> golds = new ArrayList<>();

    for(int i=0;i<numOfAliens;i++)
    {
        aliens.add(scanner.nextInt());
        golds.add(scanner.nextInt());
    }

    scanner.close();

    int maxGold = findMaxGold(ashaPower, amarPower, numOfAliens, aliens, golds);

    System.out.println(maxGold);

    // write output to stdin
    // System.out.println(input);
  }
}
