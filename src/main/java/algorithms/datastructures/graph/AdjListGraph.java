package algorithms.datastructures.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class AdjListGraph extends AbstractGraph {

    private Map<Integer, List<Integer>> adj = new HashMap<>();
    private int E = 0;

    public AdjListGraph(GraphType graphType, int size) {
        super(graphType, size);
        this.adj.forEach((k, v) -> v = new LinkedList<>());
    }

    @Override
    public void addEdge(int v1, int v2) {
        this.adj.get(v1).add(v2);
        if (this.graphType == GraphType.UNDIRECTED) {
            this.adj.get(v2).add(v1);
        }
        this.E++;
    }

    @Override
    public List<Integer> adj(int v) {
        return this.adj.get(v);
    }

    @Override
    public int E() {
        return this.E;
    }

}
