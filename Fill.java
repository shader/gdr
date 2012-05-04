import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


/**
 * Basic effect class that draws an element or set of elements filled in.
 */ 
public class Fill implements Effect {
    Runnable runnable;
    PaintEvent e;

    /**
     * Fill a set of elements, by setting their background color to the fill color
     */
    public Fill(final Iterable<? extends Element> elements) {
        //A runnable is used to change the way that the draw method works, allowing it to either draw a single element or a set
        runnable = new Runnable() {
            public void run() {
                for (Element element : elements) {
                    element.draw(e, Config.getForegroundColor(), Config.getFillColor());
                }
            }
        };
    }

    /**
     * Fill a single element by drawing it with the fill color as the background color
     */
    public Fill(final Element element) {
        runnable = new Runnable() {
            public void run() {
                element.draw(e, Config.getForegroundColor(), Config.getFillColor());
            }
        };
    }

    /**
     * Required draw function. Invokes the runnable set by the constructors to draw the effect
     */
    public void draw(PaintEvent e, Canvas canvas) {
        this.e=e;
        runnable.run();
    }
}