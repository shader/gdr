import java.util.*;
import java.io.*;

/**
 * Controller class for the MVC model. Responsible for handling actions invoked through the UI
 */
public class Controller {
    View view;
    Reader reader;
    Graph graph;
    private Animator animator;

    public Controller() {
        view = new View(this);
        view.Initialize();
    }

    /**
     * Load a graph from a file
     */
    public void LoadGraph(String path) {
        reader = new Reader();
        graph = reader.ReadFile(path);
    }

    /**
     * Load an animation from a file
     */
    public void LoadAnimation(String path) {}

    /**
     * Load the test animation (blinks nodes and then edges)
     */
    public void LoadTestAnimation() {
        animator = new Animator(view.getCanvas());
        TestAnim test = new TestAnim(animator, graph);
    }

    /**
     * Load example DFS animation
     */
    public void LoadDFSAnimation() {
        animator = new Animator(view.getCanvas());
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.Load(animator.getEffects(), graph);
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