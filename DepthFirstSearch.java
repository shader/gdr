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

        Node first = graph.getNodes().iterator().next(); //pick first node
        effects.add(new Highlight(first)); //highlight it to show that it is "visited"

        //follow all edges from starting node in order
        for(Edge e : graph.getEdgesFrom(first)) {
            Follow(e);
        }

        //finished with the starting node, so fill it in
        effects.add(new Fill(first));
    }

    /**
     * Follows an edge, visually marking it and attempting to visit the node at the other end.
     */
    private void Follow(Edge e) {
        effects.add(new Highlight(e)); //highlight edge
        Visit(e.getB()); //visit node
    }

    /**
     * Visits a node, marking it visually and then following all of its edges.
     */
    private void Visit(Node n) {
        //test to make sure this node is not already visited
        if (!visited.contains(n)) {
            visited.add(n); //add it to collection of visited nodes
            effects.add(new Highlight(n)); //highlight node

            //follow all edges from node
            for (Edge e : graph.getEdgesFrom(n)) {
                Follow(e);
            }

            //fill in finished node
            effects.add(new Fill(n));
        }
    }
}