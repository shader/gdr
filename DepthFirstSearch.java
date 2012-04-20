import java.util.*;

public class DepthFirstSearch implements Animation {
    private ArrayList<Node> visited;
    private ArrayList<Effect> effects;
    private Graph graph;
    
    public void LoadEffects(ArrayList<Effect> effects, Graph graph) {
        this.effects = effects;
        this.graph = graph;
        visited = new ArrayList<Node>();

        effects.add(new Reset(graph));

        Node first = graph.getNodes().iterator().next();
        effects.add(new Highlight(first));

        for(Edge e : graph.getEdgesFrom(first)) {
            Follow(e);
        }

        effects.add(new Fill(first));
    }

    private void Follow(Edge e) {
        effects.add(new Highlight(e));
        Visit(e.getB());
    }

    private void Visit(Node n) {
        if (!visited.contains(n)) {
            visited.add(n);
            effects.add(new Highlight(n));
            for (Edge e : graph.getEdgesFrom(n)) {
                Follow(e);
            }
            effects.add(new Fill(n));
        }
    }
}