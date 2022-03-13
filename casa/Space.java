import java.io.*;
import java.util.*;

class Space {


  static int f(List<List<Integer>> aliens, int last, int N, int P, int Q)
  {
      if(aliens.isEmpty())
          return 0;
      int maxi = 0;
      for(int i=0;i<=N;i++)
      {
          int gold = 0;
          if (i!=N && aliens.get(i).get(0) > 1)
          {
              aliens.get(i).set(0, P - aliens.get(i).get(0));
          }
      }
      
      return maxi;
  }

  public static void main(String[] args) throws Exception {
    String input = null;

    // read input from stdin
    input = new BufferedReader(new InputStreamReader(System.in)).readLine();
    
    String[] temp = input.split(" ");
    int P = Integer.valueOf(temp[0]);
    int Q = Integer.valueOf(temp[1]);
    int N = Integer.valueOf(temp[2]);

    Scanner sc = new Scanner(System.in);

    List<List<Integer>> l = new ArrayList<>();

    for(int i=0;i<N;i++)
    {
        List<Integer> tList = new ArrayList<>();
        tList.add(sc.nextInt());
        tList.add(sc.nextInt());
        l.add(tList);
    }

    f(l, N, N, P, Q);

    // write output to stdin
    // System.out.println(input);
  }
}
