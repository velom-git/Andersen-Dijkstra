public class Main {
    public static void main(String arg[]) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addNeighbours(nodeB,10);
        nodeA.addNeighbours(nodeC,15);
        nodeB.addNeighbours(nodeD,12);
        nodeB.addNeighbours(nodeF,15);
        nodeC.addNeighbours(nodeE,10);
        nodeD.addNeighbours(nodeE,2);
        nodeD.addNeighbours(nodeF,1);
        nodeF.addNeighbours(nodeE,5);

        BreadthFirstSearch bfs = new BreadthFirstSearch(nodeA, nodeF);
        bfs.compute(nodeA);
    }
}