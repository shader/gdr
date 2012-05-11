import java.util.*;
import java.io.*;

/**
 * Controller class for the MVC model. Responsible for handling actions invoked through the UI
 */
public class Controller {
    View view;
    Reader reader;
    Graph graph;
    Animator animator;
    Animation animation;

    public Controller() {
        view = new View(this);
        view.Initialize();
    }

    void InitializeAnimator() {
        if (animator == null) animator = new Animator(view.getCanvas());
        animator.Reset(graph);
    }

    /**
     * Load a graph from a file
     */
    public void LoadGraph(String path) {
        
        //read graph
        reader = new Reader();
        graph = reader.ReadFile(path);

        //draw graph on canvas
        InitializeAnimator();
        view.getCanvas().redraw();

        //re-apply animation to graph if necessary
        if (animation != null) animation.Load(animator.getEffects(), graph);
    }

    /**
     * Load an animation from a file
     */
    public void LoadAnimation(String path) {}

    /**
     * Load example DFS animation
     */
    public void LoadDFSAnimation() {
        InitializeAnimator();
        animation = new DepthFirstSearch();

        //only generate animation if graph is already loaded
        if (graph != null)
            animation.Load(animator.getEffects(), graph);
    }

    /**
     * Start the current animation
     */
    public void RunAnimation() {
        if (animator != null) {
            animator.run();
        }
    }
}