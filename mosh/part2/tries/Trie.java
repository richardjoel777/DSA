package part2.tries;

import java.util.*;

public class Trie {

    private class Node {
        private char value;
        private HashMap<Character,Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char val) {
            value = val;
        }

        @Override
        public String toString() {
            return "Value=" + value;
        }

        public void addChild(char c)
        {
            children.put(c, new Node(c));
        }

        public boolean hasChild(char c)
        {
            return children.containsKey(c);
        }

        public Node getChild(char c)
        {
            return children.get(c);
        }

        public Node[] getChildren()
        {
            return children.values().toArray(new Node[0]);
        }

        public boolean isEmpty()
        {
            return children.isEmpty();
        }

        public void removeChildren(char c)
        {
            children.remove(c);
        }
    }
    
    private Node root = new Node(' ');

    public void insert(String s)
    {
        Node current = root;
        for (char c : s.toCharArray()) {
            if (!current.hasChild(c))
                current.addChild(c);
            current = current.getChild(c);
        }
        current.isEndOfWord = true;
    }
    
    public boolean hasWord(String s)
    {
        Node current = root;
        if (s == null)
            return false;
        for (char c : s.toCharArray()) {
            if (!current.hasChild(c))
                return false;
            current = current.getChild(c);
        }
        return current.isEndOfWord;
    }
    
    public void traverse()
    {
        traverse(root);
    }

    private void traverse(Node root)
    {

        for (Node child : root.getChildren())
            traverse(child);
        System.out.println(root.value);
    }
    
    public void remove(String s)
    {
        if (s == null)
            return;
        remove(root, s, 0);
    }

    private void remove(Node root, String s, int i)
    {
        if (i == s.length()) {
            // System.out.println(root.value);
            root.isEndOfWord = false;
            return;
        }
        char c = s.charAt(i);
        var child = root.getChild(c);
        if (child == null)
            return;
        remove(child, s, i + 1);
        System.out.println(root.value);
        if (child.isEmpty() && !child.isEndOfWord)
            root.removeChildren(c);
    }

    public List<String> autoComplete(String prefix)
    {
        List<String> l = new ArrayList<>();
        if(prefix == null)
            return l;
        var lastNode = findLastNode(prefix);
        autoComplete(lastNode, prefix, l);
        return l;
    }

    private void autoComplete(Node root, String prefix, List<String> words)
    {
        if (root == null)
            return;
        if(root.isEndOfWord)
            words.add(prefix);
        for(var child : root.getChildren())
            autoComplete(child, prefix + child.value, words);
    }

    private Node findLastNode(String prefix)
    {
        var current = root;
        for(char c : prefix.toCharArray())
        {
            var child = current.getChild(c);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }



}
