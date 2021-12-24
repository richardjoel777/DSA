package mosh.part2.trees;

import java.util.ArrayList;

public class Tree {
    Node root;

    private class Node {
        private int value;
        private Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "Node=" + this.value;
        }
    }
    
    public void insert(int value)
    {
        Node new_node = new Node(value);
        if (root == null) {
            root = new_node;
            return;
        }
        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = new_node;
                    break;
                } else
                    current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = new_node;
                    break;
                } else
                    current = current.rightChild;
            }
        }
    }
    
    public boolean find(int value)
    {
        Node current = root;
        while (current != null) {
            if (value > current.value)
                current = current.rightChild;
            else if (value < current.value)
                current = current.leftChild;
            else
                return true;
        }
        return false;
    }
    
    public void preOrderTraversal()
    {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node root)
    {
        if (root == null)
            return;
        System.out.println(root.value);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    private boolean isLeaf(Node node)
    {
        if(node.rightChild == null && node.leftChild == null)
            return true;
        return false;
    }

    private int height(Node root)
    {
        if(root==null)
            return -1;
        if(isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.rightChild), height(root.leftChild)); 
    }

    public int height()
    {
        return height(root);
    }

    private int min(Node root)
    {
        if (root == null)
            throw new IllegalStateException();
        if (isLeaf(root))
            return root.value;
        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min((Math.min(left, right)), root.value);
    }
    
    public int min()
    {
        return min(root);
    }

    public void swap()
    {
        Node temp = root.rightChild;
        root.rightChild = root.leftChild;
        root.leftChild = temp;
    }

    private boolean equals(Node first, Node second)
    {
        if (first == null && second == null)
            return true;
        if(first != null  && second != null)
            return ((first.value == second.value) && (equals(first.leftChild, second.leftChild))
                && (equals(first.rightChild, second.rightChild)));
        return false;

    }
    
    public boolean equals(Tree other)
    {
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean isValid(Node root,int min,int max)
    {
        if (isLeaf(root))
            return (root.value > min && root.value < max);
        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;
        return ((root.value > min && root.value < max) && isValid(root.leftChild, min, root.value)
                && isValid(root.rightChild, root.value, max));
    }
    
    public boolean isValid()
    {
        if (root == null)
            return false;
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void kthNodes(Node root, int k, ArrayList<Integer> list)
    {
        if (root == null)
            return;
        if (k == 0) {
            list.add(root.value);
            return;
        }
        kthNodes(root.leftChild, k - 1, list);
        kthNodes(root.rightChild, k - 1, list);
    }
    
    public ArrayList<Integer> kthNodes(int k)
    {
        ArrayList<Integer> list = new ArrayList<>();
        kthNodes(root, k, list);
        return list;
    }

    public void leverOrderTraverse()
    {
        int height = height();
        for(int i=0;i<=height;i++)
        {
            for(var item : kthNodes(i))
                System.out.print(item + " ");
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(7);
        t.insert(4);
        t.insert(9);
        t.insert(1);
        t.insert(6);
        t.insert(8);
        t.insert(10);

        Tree t1 = new Tree();
        t1.insert(7);
        t1.insert(4);
        t1.insert(9);
        t1.insert(1);
        t1.insert(6);
        t1.insert(8);
        t1.insert(10);
        // t.preOrderTraversal();

        // t.swap();

        // System.out.println(t.isValid());

        // ArrayList<Integer> list = t.kthNodes(2);
        // for(int i : list)
        //     System.out.println(i);
        t.leverOrderTraverse();
    }
}