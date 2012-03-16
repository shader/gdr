import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class View {
    private Shell shell;
    private Display display;
    private Image exitImg, playImg, pauseImg;
    private Canvas canvas;
    private Animator animator;


    public View() {
        display = new Display();
        shell = new Shell(display);
        shell.setText("Gallant Animation Viewer");

        FillLayout fillLayout = new FillLayout();
        fillLayout.type = SWT.VERTICAL;
        shell.setLayout(new RowLayout());

        initMenu();
        initToolbar();
        initCanvas();
        shell.open();

	while (!shell.isDisposed ()) {
            if (!display.readAndDispatch())
                display.sleep();
	}
    }

    public void initCanvas() {
        canvas = new Canvas(shell, SWT.NO_BACKGROUND | SWT.BORDER);
        canvas.addPaintListener(new PaintListener() {
                public void paintControl(PaintEvent e) {
                    e.gc.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
                    e.gc.fillOval(200,200,100,100);
                }
            });
    }

    public void initMenu() {
        Menu menuBar = new Menu(shell, SWT.BAR);
        MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
        cascadeFileMenu.setText("&File");
        
        Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
        cascadeFileMenu.setMenu(fileMenu);

        MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
        exitItem.setText("&Exit");
        shell.setMenuBar(menuBar);

        exitItem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                shell.getDisplay().dispose();
                System.exit(0);
            }
        });
    }

    public void initToolbar() {

        Device dev = shell.getDisplay();
        try {
            exitImg = new Image(dev, "img/exit.png");
            playImg = new Image(dev, "img/play.png");
            //            pauseImg = new Image(dev, "img/pause.png");

        } catch (Exception e) {
            System.out.println("Cannot load images");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        ToolBar toolBar = new ToolBar(shell, SWT.BORDER);

        ToolItem exit = new ToolItem(toolBar, SWT.PUSH);
        exit.setImage(exitImg);

        ToolItem play = new ToolItem(toolBar, SWT.PUSH);
        play.setImage(playImg);

        //        ToolItem pause = new ToolItem(toolBar, SWT.PUSH);
        //        pause.setImage(pauseImg);

        toolBar.pack();

        exit.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                System.exit(0);
            }
        });

        play.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                canvas.redraw();
            }
        });
    }

    public Shell getShell() {
        return shell;
    }

    public Display getDisplay() {
        return display;
    }

    public Animator getAnimator() {
        return animator;
    }
}