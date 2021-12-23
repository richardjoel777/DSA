package mosh.part2.trees;

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

    private int height(Node root)
    {
        if(root==null)
            return -1;
        if(root.rightChild == null && root.leftChild == null)
            return 0;
        return 1 + Math.max(height(root.rightChild), height(root.leftChild)); 
    }

    public int height()
    {
        return height(root);
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
        // t.preOrderTraversal();
        System.out.println(t.height());
    }
}