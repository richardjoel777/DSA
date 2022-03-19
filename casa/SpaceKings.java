import java.util.*;

class Solution {

    public int maxGold(List<List<Integer>> aliens, int P, int Q) {
        if (aliens.isEmpty())
            return 0;
        int maxi = 0;
        for (int i = 0; i <= aliens.size(); i++) {
            int golds = 0;
            List<List<Integer>> temp = new ArrayList<>(aliens);
            if (i != aliens.size())
            {
                temp.get(i).set(0, temp.get(i).get(0) - P);
                if (temp.get(i).get(0) <= 0) {
                    golds += temp.get(i).get(1);
                    temp.remove(i);
                }
            }
            if (!temp.isEmpty())
            {
                temp.get(0).set(0, temp.get(0).get(0) - Q);
                if (temp.get(0).get(0) <= 0) {
                    temp.remove(0);
                }
            }
            
            golds += maxGold(temp, P, Q);
            maxi = Math.max(maxi, golds);
        }
        return maxi;
    }
}

public class SpaceKings {
    public static void main(String[] args) {
        Solution o = new Solution();
        String input = null;

    // read input from stdin
    
        Scanner sc = new Scanner(System.in);
        
        input = sc.nextLine();
        
        String[] temp = input.split(" ");
        int P = Integer.valueOf(temp[0]);
        int Q = Integer.valueOf(temp[1]);
        int N = Integer.valueOf(temp[2]);
        List<List<Integer>> l = new ArrayList<>();

        for(int i=0;i<N;i++)
        {
            List<Integer> tList = new ArrayList<>();
            tList.add(sc.nextInt());
            tList.add(sc.nextInt());
            l.add(tList);
        }

        sc.close();
        int res = o.maxGold(l, P, Q);
        System.out.println(res);

    }
} 
