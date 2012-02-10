import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

public interface Element {
    public void draw(PaintEvent e, Color foreground, Color background);
}