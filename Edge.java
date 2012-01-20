import java.util.*;

public class Edge {
    private Node a, b;
    
    public Edge(Node a, Node b) {
        this.a = a;
        this.b = b;
    }
    
    public Node getA() {
        return a;
    }
    
    public Node getB() {
        return b;
    }
}