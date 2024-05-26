import java.util.*;

public class Dijkstra {
    private Graph graph;
    private Node sourceNode;

    public Dijkstra(Graph graph, String sourceId) {
        this.graph = graph;
        this.sourceNode = graph.getNode(sourceId);
    }

    public void computeShortestPaths() {
        if (sourceNode == null) return;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getMinDistance));
        sourceNode.setMinDistance(0);
        priorityQueue.add(sourceNode);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (current.isExplored()) continue;

            current.setExplored(true);

            for (Map.Entry<Node, Integer> entry : current.getNeighbors().entrySet()) {
                Node adjacent = entry.getKey();
                int weight = entry.getValue();

                if (!adjacent.isExplored()) {
                    int newDist = current.getMinDistance() + weight;
                    if (newDist < adjacent.getMinDistance()) {
                        adjacent.setMinDistance(newDist);
                        adjacent.setPreviousNode(current);
                        priorityQueue.add(adjacent);
                    }
                }
            }
        }
    }

    public List<String> getPathTo(String targetId) {
        List<String> path = new LinkedList<>();
        Node targetNode = graph.getNode(targetId);

        if (targetNode == null || targetNode.getMinDistance() == Integer.MAX_VALUE) {
            path.add("No path found");
            return path;
        }

        for (Node node = targetNode; node != null; node = node.getPreviousNode()) {
            path.add(node.getId());
        }
        Collections.reverse(path);
        return path;
    }
}
