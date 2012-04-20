import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import java.util.*;
 
public class Animator {
    private float step = 0;
    private ArrayList<Effect> effects;
    private PaintEvent e;
    private Runnable runnable;
    private Display display;
    private Canvas canvas;

    public Animator(Canvas canvas) {
        this.canvas = canvas;
        display = canvas.getDisplay();
        effects = new ArrayList<Effect>();
        createContents(canvas);
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
 
    private void createContents(Canvas canvas) {
        canvas.addPaintListener(new PaintListener() {
                public void paintControl(PaintEvent e) {
                    for(int i=0; i<step && i<effects.size(); i++) {
                        effects.get(i).draw(e, Animator.this.getCanvas());
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

    public ArrayList<Effect> getEffects() {
        return effects;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}