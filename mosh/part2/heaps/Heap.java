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

    public boolean isEmpty()
    {
        return size == 0;
    }

    private int parent(int index)
    {
        return (index - 1) / 2;
    }

    public int remove() {
        if (size == 0)
            throw new IllegalStateException();
        var root = items[0];
        items[0] = items[--size];
        bubbleDown();
        return root;
    }
    
    private void bubbleDown()
    {
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            var largeChildIndex = largerChildIndex(index);
            swap(index, largeChildIndex);
            index = largeChildIndex;
        }
    }

    private int largerChildIndex(int index)
    {
        if(!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);
        return leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index)
    {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index)
    {
        return rightChildIndex(index) <= size;
    }

    private int leftChildIndex(int index)
    {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index)
    {
        return index * 2 + 2;
    }

    private int leftChild(int index)
    {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index)
    {
        return items[rightChildIndex(index)];
    }
    
    private boolean isValidParent(int index)
    {
        if (!hasLeftChild(index))
            return true;
        if (!hasRightChild(index))
            return items[index] >= items[leftChildIndex(index)];

        return items[index] >= items[leftChildIndex(index)] && items[index] >= items[rightChildIndex(index)];
    }

    public int max()
    {
        return items[0];
    }
}
