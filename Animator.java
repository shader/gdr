import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import java.util.*;

/**
 * Tracks current state of the animation.
 * Contains a list of Effects that represent the animation sequence, and uses a timer to automatically step through the animation when it is playing.
 */ 
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

    /**
     * Starts the animation.
     */
    public void run() {
        runnable = new Runnable() {
                public void run() {
                    animate();
                    display.timerExec(Config.getTimerInterval(), this);
                }
            };
 
        display.timerExec(Config.getTimerInterval(), runnable);
    }
 
    /**
     * Intermal method responsible for drawing the canvas.
     * Redraws all of the effects up to the current one every refresh.
     */
    private void createContents(Canvas canvas) {
        canvas.addPaintListener(new PaintListener() {
                public void paintControl(PaintEvent e) {
                    for(int i=0; i<step && i<effects.size(); i++) {
                        effects.get(i).draw(e, Animator.this.getCanvas());
                    }
                }
            });
    }
    
    /**
     * Increment counter and redraw the canvas to automatically continue the animation.
     */
    void animate() {
        step += 1.0/Config.getStepLength();
        if (step > effects.size()) {
            display.timerExec(-1, runnable); //stop animation
        }
        canvas.redraw();
    }

    /**
     * Add an effect to the animation sequence
     */
    public void add(Effect effect) {
        effects.add(effect);
    }

    /**
     * @return the list of effects
     */
    public ArrayList<Effect> getEffects() {
        return effects;
    }

    /**
     * @return a reference to the canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }
}