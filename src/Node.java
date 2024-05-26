import java.util.*;

public class Node {
    private String id;
    private Map<Node, Integer> neighbors = new HashMap<>();
    private boolean explored;
    private int minDistance;
    private Node previousNode;

    public Node(String id) {
        this.id = id;
        this.minDistance = Integer.MAX_VALUE;
        this.explored = false;
        this.previousNode = null;
    }

    public String getId() {
        return id;
    }

    public void addNeighbor(Node node, int weight) {
        neighbors.put(node, weight);
    }

    public Map<Node, Integer> getNeighbors() {
        return neighbors;
    }

    public boolean isExplored() {
        return explored;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }
}
