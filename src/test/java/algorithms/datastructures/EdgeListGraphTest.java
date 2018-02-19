package algorithms.datastructures;

import algorithms.datastructures.graph.*;
import org.junit.Test;

public class EdgeListGraphTest {

    @Test
    public void test() {
        Graph graph = new EdgeListGraph(GraphType.UNDIRECTED, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);

        System.out.println(graph);
        DFS.perform(graph, 0);
        BFS.perform(graph, 0);
    }
}
