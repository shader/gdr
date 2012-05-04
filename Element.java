import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

/**
 * Public interface for elements that can be drawn on the canvas
 */
public interface Element {
    
    /**
     * Implementation for drawing the element on the canvas
     */
    public void draw(PaintEvent e, Color foreground, Color background);
}