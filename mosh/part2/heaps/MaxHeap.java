package part2.heaps;

public class MaxHeap {
    public static void heapify(int[] items)
    {
        int lastParentIndex = items.length / 2 - 1;
        for(int i=lastParentIndex;i>=0;i--)
            heapify(items, i);
    }

    private static void heapify(int[] items, int index)
    {
        int largerIndex = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < items.length && items[left] > items[largerIndex])
            largerIndex = left;
        if (right < items.length && items[right] > items[largerIndex])
            largerIndex = right;
        if (largerIndex == index)
            return;
        swap(items, index, largerIndex);
        heapify(items, largerIndex);
    }
    
    private static void swap(int[] items, int index, int largerIndex)
    {
        int temp = items[index];
        items[index] = items[largerIndex];
        items[largerIndex] = temp;
    }

    public static int kthLargest(int[] items, int k)
    {
        if (k<1 || k > items.length)
            throw new IllegalStateException();
        Heap heap = new Heap();
        for (int num : items)
            heap.insert(num);
        for (int i = 0; i < k - 1; i++)
            heap.remove();
        return heap.max();
    }
    
    
}
