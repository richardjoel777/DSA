package part2.graphs;

import java.util.*;

public class Graph {
    private class Node {
        private String label;

        Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();
        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();
        adjacencyList.get(fromNode).add(toNode);
    }
    
    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty()) {
                System.out.println(source + " is connected to " + targets);
            }
        }
    }
    
    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;

        for (var n : adjacencyList.keySet()) {
            adjacencyList.get(n).remove(node);
        }

        adjacencyList.remove(node);
        nodes.remove(label);
    }
    
    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return;
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void depthFirst(String root) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> st = new Stack<>();
        Node node = nodes.get(root);
        if (node == null)
            return;
        st.push(node);
        while (!st.isEmpty()) {
            var current = st.pop();
            if (visited.contains(current))
                continue;
            System.out.println(current);
            visited.add(current);
            for (var neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour))
                    st.push(neighbour);
            }
        }
        // depthFirst(node, visited);
    }
    
    public void breadthFirst(String root) {
        Node node = nodes.get(root);
        if(node == null)
            return;
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        while(!queue.isEmpty())
        {
            var current = queue.remove();
            if (visited.contains(current))
                continue;
            System.out.println(current);
            visited.add(current);
            for(var neighbour : adjacencyList.get(current))
            {
                if(!visited.contains(neighbour))
                    queue.add(neighbour);
            }
        }
    }

    private void depthFirst(Node root, Set<Node> visited)
    {
        System.out.println(root.label);
        visited.add(root);
        for (var node : adjacencyList.get(root)) {
            if (!visited.contains(node))
                depthFirst(node, visited);
        }
    }
    
    public List<String> topologicalSort()
    {
        Set<Node> visited = new HashSet<>();
        Stack<Node> st = new Stack<>();

        for(var node : nodes.values())
            topologicalSort(node, visited, st);
        
        List<String> res = new ArrayList<>();
        while(!st.empty())
            res.add(st.pop().label);
        return res;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> st)
    {

        if (visited.contains(node))
            return;
            
        visited.add(node);

        for(var neighbour : adjacencyList.get(node))
            topologicalSort(neighbour, visited, st);
        st.push(node);
    }

} 