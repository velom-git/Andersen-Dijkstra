import java.util.*;

public class BreadthFirstSearch {

    static String firstNode;
    static String lastNode;
    private Node fiNode;

    public BreadthFirstSearch(Node firstNode, Node lastNode) {
        this.fiNode = firstNode;
        BreadthFirstSearch.firstNode = firstNode.name;
        BreadthFirstSearch.lastNode = lastNode.name;
    }

    public void compute(Node node) {
        Map<Node, Integer> mapNeighbours = node.getNeighbours();
        if (!mapNeighbours.isEmpty()) {
            for (Map.Entry<Node, Integer> f : mapNeighbours.entrySet()) {
                if (node.getDistance() > (put(f.getKey()) + f.getValue()) && (put(f.getKey()) + f.getValue()) > 0) {
                    node.setDistance(put(f.getKey()) + f.getValue());
                }
            }
        }
        System.out.println("Наименьшей путь равен " + fiNode.getDistance());
    }


    public int put(Node node) {
        Map<Node, Integer> mapNeighbours = node.getNeighbours();
        if (!mapNeighbours.isEmpty()) {
            for (Map.Entry<Node, Integer> f : mapNeighbours.entrySet()) {
                if (f.getKey().name.equals(lastNode)) {
                    if (node.getDistance() > f.getValue()) {
                        node.setDistance(f.getValue());
                    }
                    return f.getValue();
                } else {
                    Map<Node, Integer> fNeighbours = f.getKey().getNeighbours();
                    if (!fNeighbours.isEmpty()) {
                        for (Map.Entry<Node, Integer> x : fNeighbours.entrySet()) {
                            if (x.getKey().name.equals(lastNode)) {
                                if (node.getDistance() > x.getValue()) {
                                    node.setDistance(x.getValue());
                                }
                                return x.getValue() + f.getValue();
                            } else {
                                Map<Node, Integer> xNeighbours = x.getKey().getNeighbours();
                                if (!xNeighbours.isEmpty()) {
                                    for (Map.Entry<Node, Integer> z : xNeighbours.entrySet()) {
                                        if (z.getKey().name.equals(lastNode)) {
                                            if (node.getDistance() > z.getValue()) {
                                                node.setDistance(z.getValue());
                                            }
                                            return z.getValue() + x.getValue();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
