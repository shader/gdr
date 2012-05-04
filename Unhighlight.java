import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

/**
 * A simple effect that acts as the reverse of a highlight, by drawing a given element or set of elements in the default foreground and background colors
 */ 
public class Unhighlight implements Effect {
    Runnable runnable;
    PaintEvent e;

    /**
     * Unhighlight a set of elements
     */
    public Unhighlight(final Iterable<? extends Element> elements) {
        //Use runnable so that the draw method can handle either a set or a single element.
        runnable = new Runnable() {
            public void run() {
                for (Element element : elements) {
                    element.draw(e, Config.getForegroundColor(), Config.getBackgroundColor());
                }
            }
        };
    }

    /**
     * Unhighlight a single element
     */
    public Unhighlight(final Element element) {
        runnable = new Runnable() {
            public void run() {
                element.draw(e, Config.getForegroundColor(), Config.getBackgroundColor());
            }
        };
    }

    /**
     * Redraw the selected element(s) on the canvas with default colors
     */
    public void draw(PaintEvent e, Canvas canvas) {
        this.e=e;
        runnable.run();
    }
}