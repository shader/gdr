import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
 
public class Unhighlight implements Effect {
    Runnable runnable;
    PaintEvent e;

    public Unhighlight(final Iterable<? extends Element> elements) {
        runnable = new Runnable() {
            public void run() {
                for (Element element : elements) {
                    element.draw(e, Config.getForegroundColor(), Config.getBackgroundColor());
                }
            }
        };
    }

    public Unhighlight(final Element element) {
        runnable = new Runnable() {
            public void run() {
                element.draw(e, Config.getForegroundColor(), Config.getBackgroundColor());
            }
        };
    }

    public void draw(PaintEvent e, Canvas canvas) {
        this.e=e;
        runnable.run();
    }
}