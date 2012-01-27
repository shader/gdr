import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;

public class View {
    private Graph graph;

    public View(Graph graph) {
        this.graph = graph;

	Display display = new Display();
	Shell shell = new Shell(display);

        shell.addPaintListener(new GraphPaintListener());

        shell.setText("GDR");
        shell.setSize(graph.getWidth() + 50, graph.getHeight() + 50);
	shell.open();

	while (!shell.isDisposed ()) {
            if (!display.readAndDispatch())
                display.sleep();
	}

	display.dispose();
    }

    private class GraphPaintListener implements PaintListener {
        public void paintControl(PaintEvent e) {
            drawGraph(e);
            e.gc.dispose();
        }
    }

    private void drawGraph(PaintEvent e) {
        Color white = new Color(e.display, 255, 255, 255);
        int r = 30;
        
        for (Edge edge : graph.getEdges()) {
            Node a = edge.getA(), b = edge.getB();
            e.gc.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
        }

        for (Node n : graph.getNodes()) {
            int x = n.getX(), y=n.getY();
            e.gc.setBackground(white);
            e.gc.fillOval(x-r/2, y-r/2, r, r);
            e.gc.drawOval(x-r/2, y-r/2, r, r);
            e.gc.drawText(n.getName(), x-r/4, y-r/4, SWT.DRAW_TRANSPARENT);
        }
    }
}