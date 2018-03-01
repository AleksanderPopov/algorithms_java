package algorithms.datastructures;

import algorithms.datastructures.graph.*;
import org.junit.Test;

public class AdjListWeightedGraphTest {
    @Test
    public void test() {
        EdgeWeigthedGraph graph = new AdjListWeightedGraph(GraphType.UNDIRECTED, 8);

        graph.addEdge(new WeightedEdge(0, 2, 26));
        graph.addEdge(new WeightedEdge(0, 4, 38));
        graph.addEdge(new WeightedEdge(0, 6, 58));
        graph.addEdge(new WeightedEdge(0, 7, 16));

        graph.addEdge(new WeightedEdge(1, 2, 36));
        graph.addEdge(new WeightedEdge(1, 3, 29));
        graph.addEdge(new WeightedEdge(1, 5, 32));
        graph.addEdge(new WeightedEdge(1, 7, 19));

        graph.addEdge(new WeightedEdge(2, 3, 17));
        graph.addEdge(new WeightedEdge(2, 6, 40));
        graph.addEdge(new WeightedEdge(2, 7, 34));

        graph.addEdge(new WeightedEdge(3, 6, 52));

        graph.addEdge(new WeightedEdge(4, 5, 35));
        graph.addEdge(new WeightedEdge(4, 6, 93));
        graph.addEdge(new WeightedEdge(4, 7, 37));

        graph.addEdge(new WeightedEdge(5, 7, 28));

        System.out.println(new KruskalAlgorithm(graph).edges());
        System.out.println(new PrimAlgorithm(graph).edges());
    }
}
