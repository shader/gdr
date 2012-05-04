/**
 * A simple test animation using the constructor to statically create effects. Highlights all nodes and then all edges.
 */
public class TestAnim {
    public TestAnim(Animator anim, Graph graph) {
        anim.add(new Reset(graph));        
        anim.add(new Highlight(graph.getNodes()));
        anim.add(new Reset(graph));
        anim.add(new Highlight(graph.getEdges()));
    }
}