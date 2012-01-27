import java.util.*;

public class Graph {
    private Hashtable<String, Node> nodes;
    private ArrayList<Edge> edges;
    private int maxEdges=0, maxNodes=0, maxWidth, maxHeight;

    public Graph() {
        nodes = new Hashtable<String, Node>();
        edges = new ArrayList<Edge>();
    }

    public Collection<Node> getNodes() {
        return nodes.values();
    }
    
    public Node getNode(String name) {
        return (Node)nodes.get(name);
    }
    
    public void addNode(Node node) {
        nodes.put(node.getName(), node);
        maxWidth = node.getX() > maxWidth ? node.getX() : maxWidth;
        maxHeight = node.getY() > maxHeight ? node.getY() : maxHeight;
    }

    public ArrayList<Edge> getEdges() {
        return (ArrayList<Edge>)edges.clone();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void addEdge(String a, String b) {
        edges.add(new Edge(getNode(a), getNode(b)));
    }

    public void printAdjacencies() {
        System.out.println("Adjacencies are:");
        for(Node n : nodes.values()) {
            System.out.print(n.getName() + ": ");
            for(Edge e : edges) {
                if (e.getA() == n) {
                    System.out.print(e.getB().getName() + ", ");
                } else if (e.getB() == n) {
                    System.out.print(e.getA().getName() + ", ");
                }
            }
            System.out.println();
        }
    }

    public void setSize(int maxNodes, int maxEdges) {
        this.maxNodes = maxNodes;
        this.maxEdges = maxEdges;
    }

    public boolean isFull() {
        return nodes.size() == maxNodes && edges.size() == maxEdges && maxNodes != 0;
    }

    public int getWidth() {
        return maxWidth;
    }

    public int getHeight() {
        return maxHeight;
    }
}