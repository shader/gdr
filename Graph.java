import java.util.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

/**
 * Model class for representing a graph
 */
public class Graph {
    private HashMap<String, Node> nodes;
    private ArrayList<Edge> edges;
    private int maxEdges=0, maxNodes=0, maxWidth, maxHeight;

    public Graph() {
        nodes = new HashMap<String, Node>();
        edges = new ArrayList<Edge>();
    }

    /**
     * @return an iterable for the nodes in the graph
     */
    public Iterable<Node> getNodes() {
        return Collections.unmodifiableCollection(nodes.values());
    }

    /**
     * @return an iterable for the neighbors of a given node
     */
    public Iterable<Node> getNeighbors(Node node) {
        ArrayList<Node> neighbors = new ArrayList<Node>();
        for (Edge e : edges) {
            if (e.getA() == node)
                neighbors.add(e.getB());
            else if (e.getB() == node)
                neighbors.add(e.getA());
        }
        return Collections.unmodifiableList(neighbors);
    }

    /**
     * @return an iterable for the successors of a given node. I.e. all nodes in the "b" slot of an edge that has the given node in the "a" slot.
     */
    public Iterable<Node> getSuccessors(Node node) {
        ArrayList<Node> sucessors = new ArrayList<Node>();
        for (Edge e : edges) {
            if (e.getA() == node)
                sucessors.add(e.getB());
        }
        return Collections.unmodifiableList(sucessors);
    }

    /**
     * @return an iterable for the predecessors of a node. I.e. all nodes in the "a" slot of an edge that has the given node in its "b" slot.
     */
    public Iterable<Node> getPredecessors(Node node) {
        ArrayList<Node> predecessors = new ArrayList<Node>();
        for (Edge e : edges) {
            if (e.getB() == node)
                predecessors.add(e.getA());
        }
        return Collections.unmodifiableList(predecessors);
    }

    /**
     * @return an iterable for all the edges from a particular node. I.e. have that node in their "a" slot.
     */
    public Iterable<Edge> getEdgesFrom(Node node) {
        ArrayList<Edge> fromList = new ArrayList<Edge>();
        for (Edge e : edges) {
            if (e.getA() == node)
                fromList.add(e);
        }
        return Collections.unmodifiableList(fromList);
    }

    /**
     * @return an iterable for all the edges to a particular node. I.e have that node in their "b" slot.
     */
    public Iterable<Edge> getEdgesTo(Node node) {
        ArrayList<Edge> toList = new ArrayList<Edge>();
        for (Edge e : edges) {
            if (e.getB() == node)
                toList.add(e);
        }
        return Collections.unmodifiableList(toList);
    }
    
    /**
     * Look up a particular node by its name
     */
    public Node getNode(String name) {
        return nodes.get(name);
    }
    
    /**
     * Add a node to the graph
     */
    public void addNode(Node node) {
        nodes.put(node.getName(), node);
        maxWidth = node.getX() > maxWidth ? node.getX() : maxWidth;
        maxHeight = node.getY() > maxHeight ? node.getY() : maxHeight;
    }

    /**
     * @return an iterable for all of the edges in the graph
     */
    public Iterable<Edge> getEdges() {
        return Collections.unmodifiableList(edges);
    }

    /**
     * Add an edge to the graph
     */
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    /**
     * Add a new edge between the nodes given by name.
     */
    public void addEdge(String a, String b) {
        edges.add(new Edge(getNode(a), getNode(b)));
    }

    /**
     * Set the maximum number of edges and nodes this graph can contain
     */
    public void setSize(int maxNodes, int maxEdges) {
        this.maxNodes = maxNodes;
        this.maxEdges = maxEdges;
    }

    /**
     * Determine whether the graph has reached its maximum size yet
     */
    public boolean isFull() {
        return nodes.size() == maxNodes && edges.size() == maxEdges && maxNodes != 0;
    }

    /**
     * @returns the total width of the graph
     */
    public int getWidth() {
        return maxWidth;
    }

    /**
     * @returns the total height of the graph
     */
    public int getHeight() {
        return maxHeight;
    }

    /**
     * Draw method for drawing a complete graph to the canvas.
     */
    public void draw(PaintEvent e) {
        for (Edge edge : getEdges()) { 
            edge.draw(e, Config.getForegroundColor(), Config.getBackgroundColor());
        }

        for (Node node : getNodes()) {
            node.draw(e, Config.getForegroundColor(), Config.getBackgroundColor());
        }
    }
}