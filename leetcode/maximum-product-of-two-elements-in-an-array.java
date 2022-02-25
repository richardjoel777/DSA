class Solution {
    public int maxProduct(int[] nums) {
        var maxHeap = new PriorityQueue<Integer>(3);
        for(int num : nums)
        {
            maxHeap.add(num);
            if(maxHeap.size()>2)
                maxHeap.poll();
        }
        return (maxHeap.poll()-1) * (maxHeap.poll()-1);
    }
}