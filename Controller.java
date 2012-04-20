import java.util.*;
import java.io.*;

public class Controller {
    View view;
    Reader reader;
    Graph graph;
    private Animator animator;

    public Controller() {
        view = new View(this);
        view.Initialize();
    }

    public void LoadGraph(String path) {
        reader = new Reader();
        graph = reader.ReadFile(path);
    }

    public void LoadAnimation(String path) {}

    public void LoadTestAnimation() {
        animator = new Animator(view.getCanvas());
        TestAnim test = new TestAnim(animator, graph);
    }

    public void LoadDFSAnimation() {
        animator = new Animator(view.getCanvas());
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.LoadEffects(animator.getEffects(), graph);
    }

    public void RunAnimation() {
        if (animator != null) {
            animator.run();
        }
    }
}