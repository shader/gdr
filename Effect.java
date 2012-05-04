import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

/**
 * Interface for effect objects that represent steps in the animation sequence
 * Each effect contains information on how to draw the changes between the previous step and the current one
 */ 
public interface Effect {

    /**
     * How to draw the changes on the canvas
     */
    public void draw(PaintEvent e, Canvas canvas);
}