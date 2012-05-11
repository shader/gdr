import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

/**
 * Simple effect for drawing an element or set of elements with thicker lines.
 */ 
public class Thicken implements Effect {
    Runnable runnable;
    PaintEvent e;

    /**
     * Draw a set of elements using the specified parameters
     */
    public Thicken(final Iterable<? extends Element> elements, final Color foreground, final Color background, final int width) {
        //a runnable is used so that the draw method can handle either a set or a single element
        runnable = new Runnable() {
            public void run() {
                e.gc.setLineWidth(width);
                for (Element element : elements) {
                    element.draw(e, foreground, background);
                }
                e.gc.setLineWidth(Config.getDefaultLineWidth());
            }
        };
    }

    /**
     * Thicken a set of elements using default parameters
     */
    public Thicken(final Iterable<? extends Element> elements) {
        this(elements, Config.getForegroundColor(), Config.getBackgroundColor(), Config.getThickLineWidth());
    }

    /**
     * Draw a single element by with the specified parameters, including line width
     */
    public Thicken(final Element element, final Color foreground, final Color background, final int width) {
        runnable = new Runnable() {
            public void run() {
                e.gc.setLineWidth(width);
                element.draw(e, foreground, background);
                e.gc.setLineWidth(Config.getDefaultLineWidth());
            }
        };
    }

    /**
     * Thicken a single element using default parameters
     */
    public Thicken(final Element element) {
        this(element, Config.getForegroundColor(), Config.getBackgroundColor(), Config.getThickLineWidth());
    }

    /**
     * Draw the effect on the canvas
     */
    public void draw(PaintEvent e, Canvas canvas) {
        this.e=e;
        runnable.run();
    }
}