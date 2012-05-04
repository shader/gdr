import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

/**
 * Simple effect for highlighting an element or set of elements.
 */ 
public class Highlight implements Effect {
    Runnable runnable;
    PaintEvent e;

    /**
     * Highlight a set of elements by drawing them with the highlight color instead of the normal foreground color.
     */
    public Highlight(final Iterable<? extends Element> elements) {
        //a runnable is used so that the draw method can handle either a set or a single element
        runnable = new Runnable() {
            public void run() {
                for (Element element : elements) {
                    element.draw(e, Config.getHighlightColor(), Config.getBackgroundColor());
                }
            }
        };
    }

    /**
     * Highlight an element by drawing it with the highlight color instead of the normal foreground color.
     */
    public Highlight(final Element element) {
        runnable = new Runnable() {
            public void run() {
                element.draw(e, Config.getHighlightColor(), Config.getBackgroundColor());
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