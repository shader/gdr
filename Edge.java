import java.util.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

public class Edge implements Element {
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

    public void draw(PaintEvent e, Color foreground, Color background) {
        e.gc.setForeground(foreground);
        e.gc.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
    }
}