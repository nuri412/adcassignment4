import java.util.*;

public class Graph {
    private Map<String, Node> nodes = new HashMap<>();

    public Node getNode(String id) {
        return nodes.get(id);
    }

    public void addNode(String id) {
        nodes.put(id, new Node(id));
    }

    public void connectNodes(String startId, String endId, int weight) {
        Node startNode = nodes.get(startId);
        Node endNode = nodes.get(endId);

        if (startNode != null && endNode != null) {
            startNode.addNeighbor(endNode, weight);
        }
    }

    public Collection<Node> getAllNodes() {
        return nodes.values();
    }
}
