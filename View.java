import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class View {
    private Shell shell;
    private Display display;
    private Image exitImg, playImg, pauseImg, openImg;
    private Canvas canvas;
    private Animator animator;


    public View() {
        display = new Display();
        shell = new Shell(display);
        shell.setText("Gallant Animation Viewer");

        shell.setLayout(new GridLayout());

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
        animator = new Animator(canvas);

        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.verticalAlignment = GridData.FILL;
        gridData.grabExcessHorizontalSpace = true;
        gridData.grabExcessVerticalSpace = true;
        canvas.setLayoutData(gridData);
    }

    public void initMenu() {
        Menu menuBar = new Menu(shell, SWT.BAR);
        MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
        cascadeFileMenu.setText("&File");
        
        Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
        cascadeFileMenu.setMenu(fileMenu);

        MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
        exitItem.setText("&Exit");

        MenuItem openGraphItem = new MenuItem(fileMenu, SWT.PUSH);
        openGraphItem.setText("Open &Graph");

        MenuItem openAnimationItem = new MenuItem(fileMenu, SWT.PUSH);
        openAnimationItem.setText("Open &Animation");

        shell.setMenuBar(menuBar);

        exitItem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                shell.getDisplay().dispose();
                System.exit(0);
            }
        });

        openGraphItem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(shell, SWT.NULL);
                String path = dialog.open();
                Reader reader = new Reader();
                reader.ReadFile(path);
            }
        });

        openAnimationItem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(shell, SWT.NULL);
                String path = dialog.open();
            }
        });
    }

    public void initToolbar() {

        Device dev = shell.getDisplay();
        try {
            exitImg = new Image(dev, "img/exit.png");
            //            openImg = new Image(dev, "img/open.png");
            playImg = new Image(dev, "img/play.png");
            //            pauseImg = new Image(dev, "img/pause.png");

        } catch (Exception e) {
            System.out.println("Cannot load images");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        ToolBar toolBar = new ToolBar(shell, SWT.BORDER);

        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.grabExcessHorizontalSpace = true;
        toolBar.setLayoutData(gridData);
        
        ToolItem exit = new ToolItem(toolBar, SWT.PUSH);
        exit.setImage(exitImg);
 
        // ToolItem open = new ToolItem(toolBar, SWT.PUSH);
        // exit.setImage(openImg);
 
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

        // open.addSelectionListener(new SelectionAdapter() {
        //     @Override
        //     public void widgetSelected(SelectionEvent e) {
        //         FileDialog dialog = new FileDialog(shell, SWT.NULL);
        //         String path = dialog.open();
        //     }
        // });

        play.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                animator.run();
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