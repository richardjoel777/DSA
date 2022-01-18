class Solution {
    public int countStudents(int[] students, int[] sw) 
    {
        int ones = 0;
        int zeroes = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0;i<students.length;i++)
        {
            q.offer(students[i]);
            s.push(sw[sw.length-1-i]);
            if(students[i] == 1)
                ones++;
            else
                zeroes++;
        }
        while(!q.isEmpty())
        {
            int temp = q.remove();
            if((s.peek() == 0 && zeroes == 0) || (s.peek() == 1 && ones == 0))
                break;
            if(s.peek() == temp)
            {
                s.pop();
                if(temp == 1)
                    ones--;
                else
                    zeroes--;
            }
            else
                q.offer(temp);
        }
        return ones + zeroes;
    }
}