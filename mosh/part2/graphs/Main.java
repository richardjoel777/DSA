package part2.graphs;


public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");
        graph.addEdge("X", "A");
        graph.addEdge("X", "B");
        graph.addEdge("A", "P");
        graph.addEdge("B", "P");
        // graph.breadthFirst("A");
        // graph.print();
        var res = graph.topologicalSort();
        System.out.println(res.toString());
        System.out.println("Done");
    }
}
