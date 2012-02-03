import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
 
public class Highlight implements Effect {
    Runnable runnable;
    PaintEvent e;
    Animator anim;

    public Highlight(final Iterable<Node> nodes) {
        runnable = new Runnable() {
            public void run() {
                for (Node node : nodes) {
                    anim.drawNode(node, Config.getHighlightColor(), Config.getBackgroundColor());
                }
            }
        };
    }

    public Highlight(final Node node) {
        runnable = new Runnable() {
            public void run() {
                anim.drawNode(node, Config.getHighlightColor(), Config.getBackgroundColor());
            }
        };
    }

    public Highlight(final Iterable<Edge> edges) {
        runnable = new Runnable() {
            public void run() {
                for (Edge edge : edges) {
                    anim.drawEdge(edge, Config.getHighlightColor());
                }
            }
        };
    }

    public Highlight(final Edge edge) {
        runnable = new Runnable() {
            public void run() {
                anim.drawEdge(edge, Config.getHighlightColor());
            }
        };
    }

    public void draw(PaintEvent e, Animator anim) {
        this.e=e;
        this.anim=anim;
        runnable.run();
    }
}