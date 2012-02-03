import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import java.util.*;

public class Config {
    public static int getDiameter() { return 30; }

    public static int getTimerInterval() { return 16; }
    public static int getStepLength() { return 60; }

    public static Color getHighlightColor() { return Display.getCurrent().getSystemColor(SWT.COLOR_RED); }
    public static Color getForegroundColor() { return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK); }
    public static Color getBackgroundColor() { return Display.getCurrent().getSystemColor(SWT.COLOR_WHITE); }
}