import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

/**
 * Simple effect for coloring an element or set of elements.
 */ 
public class Colorize implements Effect {
    Runnable runnable;
    PaintEvent e;

    /**
     * Color a set of elements by drawing them with the specified colors
     */
    public Colorize(final Iterable<? extends Element> elements, final Color foreground, final Color background) {
        //a runnable is used so that the draw method can handle either a set or a single element
        runnable = new Runnable() {
            public void run() {
                for (Element element : elements) {
                    element.draw(e, foreground, background);
                }
            }
        };
    }

    /**
     * Color an element by drawing it with the specified colors
     */
    public Colorize(final Element element, final Color foreground, final Color background) {
        runnable = new Runnable() {
            public void run() {
                element.draw(e, foreground, background);
            }
        };
    }

    /**
     * Draw the effect on the canvas
     */
    public void draw(PaintEvent e, Canvas canvas) {
        this.e=e;
        runnable.run();
    }
}