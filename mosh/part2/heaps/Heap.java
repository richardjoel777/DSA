package part2.heaps;

public class Heap {
    int[] items = new int[10];
    private int size;

    public void insert(int data)
    {
        if (isFull())
            throw new IllegalStateException();
        items[size++] = data;
        bubbleUp();
    }

    private void bubbleUp()
    {
        var index = size - 1;
        while (index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }
    
    private void swap(int index, int parentIndex)
    {
        int temp = items[index];
        items[index] = items[parentIndex];
        items[parentIndex] = temp;
    }

    public boolean isFull()
    {
        return size == items.length;
    }

    private int parent(int index)
    {
        return (index - 1) / 2;
    }
}
