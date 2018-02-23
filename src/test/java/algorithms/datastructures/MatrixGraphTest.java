package algorithms.datastructures;

import algorithms.datastructures.graph.*;
import org.junit.Test;

public class MatrixGraphTest {

    @Test
    public void test() {
        Graph graph = new MatrixGraph(GraphType.UNDIRECTED, 5);
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

        Graph digraph = new MatrixGraph(GraphType.DIRECTED, 7);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(0, 5);
        digraph.addEdge(1, 4);
        digraph.addEdge(3, 2);
        digraph.addEdge(3, 5);
        digraph.addEdge(3, 4);
        digraph.addEdge(3, 6);
        digraph.addEdge(5, 2);
        digraph.addEdge(6, 0);
        digraph.addEdge(6, 4);

        System.out.println(digraph);
        TopologicalSort.perform(digraph);
        StrongComponents.perform(digraph, 0, 2);
    }
}
