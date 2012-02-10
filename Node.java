import java.util.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.SWT;

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

    public Node(String name, String x, String y) {
        this(name, Integer.parseInt(x), Integer.parseInt(y));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(PaintEvent e, Color foreground, Color background) {
        int d = Config.getDiameter();
        e.gc.setBackground(background);
        e.gc.fillOval(x-d/2, y-d/2, d, d);
        e.gc.setForeground(foreground);
        e.gc.drawOval(x-d/2, y-d/2, d, d);
        e.gc.drawText(name, x-d/4, y-d/4, SWT.DRAW_TRANSPARENT);
    }
}