public class TestAnim {
    public TestAnim(Animator anim, Graph graph) {
        anim.add(new Highlight(graph.getNodes()));
        anim.add(new Reset(graph));
        anim.add(new Highlight(graph.getEdges()));
    }
}