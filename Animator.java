import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import java.util.*;
 
public class Animator {
    private Canvas canvas;
    private float step = 0;
    private ArrayList<Effect> effects;
    private PaintEvent e;
    private Runnable runnable;
    private View view;
    private Display display;

    public Animator(View view) {
        this.view = view;
        this.display = view.getDisplay();
        effects = new ArrayList<Effect>();
        createContents(view.getShell());
    }

    public void run() {
        runnable = new Runnable() {
                public void run() {
                    animate();
                    display.timerExec(Config.getTimerInterval(), this);
                }
            };
 
        display.timerExec(Config.getTimerInterval(), runnable);
    }
 
    private void createContents(final Shell shell) {
        shell.setLayout(new FillLayout());

        // Create the canvas for drawing
        canvas = new Canvas(shell, SWT.NO_BACKGROUND);
        canvas.addPaintListener(new PaintListener() {
                public void paintControl(PaintEvent e) {
                    for(int i=0; i<step && i<effects.size(); i++) {
                        effects.get(i).draw(e, Animator.this);
                    }
                }
            });
    }
 
    //Perform calculations required for redrawing the canvas
    void animate() {
        step += 1.0/Config.getStepLength();
        if (step > effects.size()) {
            display.timerExec(-1, runnable); //stop animation
        }
        canvas.redraw();
    }

    public void add(Effect effect) {
        effects.add(effect);
    }

    public Shell getShell() {
        return view.getShell();
    }
}