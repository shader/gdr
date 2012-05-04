import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import java.util.*;

/**
 * A simple effect for redrawing the graph on the canvas without any recoloring
 */
public class Reset implements Effect {
    private Graph graph;

    public Reset(Graph graph) {
        this.graph = graph;
    }
    
    /**
     * Draw the graph with normal foreground and background colors
     */
    public void draw(PaintEvent e, Canvas canvas) {
        e.gc.setBackground(Config.getBackgroundColor());
        e.gc.fillRectangle(0, 0, canvas.getBounds().width, canvas.getBounds().height);
        graph.draw(e);
    }
}