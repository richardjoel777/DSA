package part2.heaps;

import java.util.Arrays;

import part2.heaps.Heap;

public class Main {

    
    public static void main(String[] args) {
        // Heap heap = new Heap();
        int[] numbers = { 5, 3, 8, 4, 1, 2 };
        MaxHeap.heapify(numbers);
        // for(var num : numbers)
        //     heap.insert(num);
        // while (!heap.isEmpty())
        //     System.out.println(heap.remove());
        // for (int i = 0; i < numbers.length; i++)
        //     numbers[i] = heap.remove();
        System.out.println(Arrays.toString(numbers));
        System.out.println(MaxHeap.kthLargest(numbers, 7));
        // System.out.println("Done");
    }
}
