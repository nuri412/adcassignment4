public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.connectNodes("A", "B", 1);
        graph.connectNodes("A", "C", 4);
        graph.connectNodes("B", "C", 2);
        graph.connectNodes("B", "D", 5);
        graph.connectNodes("C", "D", 1);
        graph.connectNodes("D", "E", 3);

        System.out.println("BFS starting from node A:");
        BFS bfs = new BFS(graph, "A");
        bfs.traverse();

        System.out.println("\nDijkstra starting from node A:");
        Dijkstra dijkstra = new Dijkstra(graph, "A");
        dijkstra.computeShortestPaths();

        System.out.println("Shortest path from A to E:");
        System.out.println(dijkstra.getPathTo("E"));
    }
}
