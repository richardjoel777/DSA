package part2.AVLTree;

class AVL {
    Node root;

    private class Node {
        private int value;
        private int height;
        private Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + this.value;
        }
    }

    private Node insert(Node root, int val)
    {
        if (root == null)
            return new Node(val);
        if (val > root.value)
            root.rightChild = insert(root.rightChild, val);
        else
            root.leftChild = insert(root.leftChild, val);

        setHeight(root);

        return balance(root);
    }

    private void setHeight(Node node)
    {
        node.height = Math.max(height(node.rightChild), height(node.leftChild)) + 1;
    }

    private int height(Node node)
    {
        return (node == null) ? -1 : node.height;
    }

    private int balanceFactor(Node node)
    {
        return height(node.leftChild) - height(node.rightChild);
    }

    private boolean isLeftHeavy(Node node)
    {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(Node node)
    {
        return balanceFactor(node) < 1;
    }

    private Node balance(Node root)
    {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        return root;
    }
    
    private Node rotateRight(Node root)
    {
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private Node rotateLeft(Node root) {
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    public void insert(int val)
    {
        root = insert(root, val);
    }

    public static void main(String[] args) {
        AVL t = new AVL();
        t.insert(30);
        t.insert(20);
        t.insert(10);
        System.out.println("Hi");
    }
    
}