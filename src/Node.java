import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    Map<Node, Integer> neighbours;
    String name;
    private int distance = Integer.MAX_VALUE;

    Node(String name) {
        this.name = name;
        this.neighbours = new HashMap<>();
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void addNeighbours(Node neighbourNode, int path) {
        this.neighbours.put(neighbourNode, path);
    }

    public Map<Node, Integer> getNeighbours() {
        return neighbours;
    }

}
