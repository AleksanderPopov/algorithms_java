package algorithms.datastructures.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class AdjListGraph extends AbstractGraph {

    private List<Set<Integer>> adj = new ArrayList<>();
    private int E = 0;

    public AdjListGraph(GraphType graphType, int size) {
        super(graphType, size);
        IntStream.range(0, size)
                .forEach(i -> this.adj.add(i, new HashSet<>()));
    }

    @Override
    public void addEdge(int v1, int v2) {
        this.adj.get(v1).add(v2);
        if (this.type() == GraphType.UNDIRECTED) {
            this.adj.get(v2).add(v1);
        }
        this.E++;
    }

    @Override
    public List<Integer> adj(int v) {
        return this.type() == GraphType.UNDIRECTED
                ? new ArrayList<>(this.adj.get(v))
                : IntStream.range(0, this.V())
                .boxed()
                .filter(to -> to != v && this.adj.get(to).contains(v))
                .collect(toList());
    }

    @Override
    public int E() {
        return this.E;
    }

}
