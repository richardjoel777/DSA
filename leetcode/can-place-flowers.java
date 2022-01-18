class Solution {
    public boolean canPlaceFlowers(int[] fl, int n) {
        if(fl.length == 1)
        {
            if(fl[0] == 0)
                n--;
        }
        else
        {
            for(int i=0;i<fl.length;i++)
            {
              if(n==0)
                  break;
               if(fl[i] == 0)
               {
                   if(i == 0)
                   {
                       if(fl[i+1] == 0)
                       {
                           fl[i] = 1;
                           n--;
                       }
                   }
                   else if(i == fl.length-1)
                   {
                       if(fl[i-1] == 0)
                       {
                           fl[i] = 1;
                           n--;
                       }
                   }
                   else
                   {
                       if(fl[i-1] != 1 && fl[i+1] != 1)
                       {
                           fl[i] = 1;
                           n--;
                       }
                   }
               }
            }
        }
        if(n>0)
            return false;
        return true;
    }
}