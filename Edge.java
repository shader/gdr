import java.util.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

/**
 * Class for modelling edges in a graph
 */
public class Edge implements Element {
    private Node a, b;
    
    public Edge(Node a, Node b) {
        this.a = a;
        this.b = b;
    }
   
    /** 
     * @return node in the "a" slot. Represents starting node if the graph is interpreted as directional
     */
    public Node getA() {
        return a;
    }
    
    /**
     * @return node in the "b" slot. Represents end node if the graph is interpreted as directional
     */
    public Node getB() {
        return b;
    }

    /**
     * Implementation of actual drawing of an edge using a particular foreground color
     */
    public void draw(PaintEvent e, Color foreground, Color background) {
        e.gc.setForeground(foreground);
        e.gc.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
    }
}