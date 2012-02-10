import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
 
public class Highlight implements Effect {
    Runnable runnable;
    PaintEvent e;

    public Highlight(final Iterable<? extends Element> elements) {
        runnable = new Runnable() {
            public void run() {
                for (Element element : elements) {
                    element.draw(e, Config.getHighlightColor(), Config.getBackgroundColor());
                }
            }
        };
    }

    public Highlight(final Element element) {
        runnable = new Runnable() {
            public void run() {
                element.draw(e, Config.getHighlightColor(), Config.getBackgroundColor());
            }
        };
    }

    public void draw(PaintEvent e, Animator anim) {
        this.e=e;
        runnable.run();
    }
}