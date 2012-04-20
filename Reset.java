import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import java.util.*;

public class Reset implements Effect {
    private Graph graph;

    public Reset(Graph graph) {
        this.graph = graph;
    }

    public void draw(PaintEvent e, Canvas canvas) {
        e.gc.setBackground(Config.getBackgroundColor());
        e.gc.fillRectangle(0, 0, canvas.getBounds().width, canvas.getBounds().height);
        graph.draw(e);
    }
}