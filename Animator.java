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
    PaintEvent e;
    private Shell shell;

    public Animator() {
        effects = new ArrayList<Effect>();
        final Display display = new Display();
        shell = new Shell(display);
        shell.setText("Gallant Animation Viewer");
        createContents(shell);
        shell.open();
 
        Runnable runnable = new Runnable() {
                public void run() {
                    animate();
                    display.timerExec(Config.getTimerInterval(), this);
                }
            };
 
        display.timerExec(Config.getTimerInterval(), runnable);
 
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
 
        display.timerExec(-1, runnable);
        display.dispose();
    }
 
    private void createContents(final Shell shell) {
        shell.setLayout(new FillLayout());

        // Create the canvas for drawing
        canvas = new Canvas(shell, SWT.NO_BACKGROUND);
        canvas.addPaintListener(new PaintListener() {
                public void paintControl(PaintEvent e) {
                    Animator.this.e = e;
                    for(int i=0; i<step && i<effects.size(); i++) {
                        effects.get(i).draw(e, Animator.this);
                    }
                }
            });
    }
 
    //Perform calculations required for redrawing the canvas
    public void animate() {
        step += 1.0/Config.getStepLength();
        canvas.redraw();
    }

    public void drawGraph(Graph graph) {
        shell.setSize(graph.getWidth() + 50, graph.getHeight() + 50);
        
        for (Edge edge : graph.getEdges()) { 
            drawEdge(edge, Config.getForegroundColor());
        }

        for (Node node : graph.getNodes()) {
            drawNode(node, Config.getForegroundColor(), Config.getBackgroundColor());
        }
    }

    public void drawNode(Node n, Color foreground, Color background) {
        int x = n.getX(), y=n.getY(), d=Config.getDiameter();
        e.gc.setBackground(background);
        e.gc.fillOval(x-d/2, y-d/2, d, d);
        e.gc.setForeground(foreground);
        e.gc.drawOval(x-d/2, y-d/2, d, d);
        e.gc.drawText(n.getName(), x-d/4, y-d/4, SWT.DRAW_TRANSPARENT);
    }

    public void drawEdge(Edge edge, Color foreground) {
        Node a = edge.getA(), b = edge.getB();
        e.gc.setForeground(foreground);
        e.gc.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
    }

    public void add(Effect effect) {
        effects.add(effect);
    }
}