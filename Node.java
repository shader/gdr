import java.util.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.SWT;

/**
 * Model class for representing a node in a graph.
 */
public class Node implements Element {
    private String name;
    private String label;
    private int x;
    private int y;

    public Node(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    /**
     * Parse string values for x and y coordinates before placing in the graph
     */
    public Node(String name, String x, String y) {
        this(name, Integer.parseInt(x), Integer.parseInt(y));
    }

    /**
     * Set the name of the node
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @returns the string name of the node
     */
    public String getName() {
        return name;
    }
    
    /**
     * @returns the label of the node
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label for a node
     */
    public void setLabel(String label) {
        this.label = label;
    }
    
    /**
     * @returns the x coordinate of the node
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x coordinate of the node
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * @returns the y coordinate of the node
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate of the node
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Draw the node on the canvas
     */
    public void draw(PaintEvent e, Color foreground, Color background) {
        int d = Config.getDiameter();
        e.gc.setBackground(background);
        e.gc.fillOval(x-d/2, y-d/2, d, d);
        e.gc.setForeground(foreground);
        e.gc.drawOval(x-d/2, y-d/2, d, d);
        e.gc.drawText(name, x-d/4, y-d/4, SWT.DRAW_TRANSPARENT);
    }
}