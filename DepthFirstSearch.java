import java.util.*;

/**
 * An example implementation of an animation for the Depth First Search algorithm
 */
public class DepthFirstSearch implements Animation {
    private ArrayList<Node> visited;
    private ArrayList<Effect> effects;
    private Graph graph;
    
    /**
     * Required public method for implementing Animation. Entry point for animation algorithm.
     * Picks a node from the graph and starts a dfs from there, recursively calling Follow and Visit
     */
    public void Load(ArrayList<Effect> effects, Graph graph) {
        this.effects = effects;
        this.graph = graph;

        visited = new ArrayList<Node>(); //collection of already visited nodes

        for (Node n : graph.getNodes()) { //search through all nodes in graph
            Visit(n);
        }
    }

    /**
     * Visits a node, marking it visually and then following all of its edges.
     */
    private void Visit(Node n) {
        //test to make sure this node is not already visited
        if (!visited.contains(n)) {
            visited.add(n); //add it to collection of visited nodes
            effects.add(new Highlight(n)); //highlight node to show current focus
            effects.add(new Thicken(n)); //thicken node to show it's already been visited

            //follow all edges from node
            for (Edge e : graph.getEdgesFrom(n)) {
                effects.add(new Highlight(e)); //highlight edge to indicate current focus
                effects.add(new Thicken(e)); //thicken to show already followed
                Visit(e.getB()); //visit node
            }

            //fill in finished node
            effects.add(new Fill(n));
        }
    }
}