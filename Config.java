import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import java.util.*;

/**
 * Contains methods to retrieve configuration constants
 */
public class Config {
    /**
     * @return the diameter for a node
     */
    public static int getDiameter() { return 30; }

    /**
     * @return the interval between canvas refreshes in milliseconds
     */
    public static int getTimerInterval() { return 16; }

    /**
     * @return the amount of time between steps in an animation in milliseconds
     */
    public static int getStepLength() { return 60; }

    /**
     * @return the default color for the Highlight effect
     */
    public static Color getHighlightColor() { return Display.getCurrent().getSystemColor(SWT.COLOR_RED); }

    /**
     * @return the default color for the Fill effect
     */
    public static Color getFillColor() { return Display.getCurrent().getSystemColor(SWT.COLOR_RED); }

    /**
     * @return the default foreground color
     */
    public static Color getForegroundColor() { return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK); }

    /**
     * @return the default background color
     */
    public static Color getBackgroundColor() { return Display.getCurrent().getSystemColor(SWT.COLOR_WHITE); }
}