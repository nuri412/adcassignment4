import java.util.*;

public class BFS {
    private Graph graph;
    private Node startNode;

    public BFS(Graph graph, String startId) {
        this.graph = graph;
        this.startNode = graph.getNode(startId);
    }

    public void traverse() {
        if (startNode == null) return;

        Queue<Node> queue = new LinkedList<>();
        startNode.setExplored(true);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Visited node: " + current.getId());

            for (Node neighbor : current.getNeighbors().keySet()) {
                if (!neighbor.isExplored()) {
                    neighbor.setExplored(true);
                    queue.add(neighbor);
                }
            }
        }
    }
}
