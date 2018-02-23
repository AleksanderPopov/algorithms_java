package algorithms.datastructures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class EdgeListGraph extends AbstractGraph {

    private List<Pair> edges = new ArrayList<>();

    public EdgeListGraph(GraphType graphType, int size) {
        super(graphType, size);
    }

    @Override
    public void addEdge(int v1, int v2) {
        this.edges.add(new Pair(v1, v2));
        if (this.graphType == GraphType.UNDIRECTED) {
            this.edges.add(new Pair(v2, v1));
        }
    }

    @Override
    public List<Integer> adj(int v) {
        return this.edges
                .stream()
                .filter(pair -> pair.v2 == v)
                .map(pair -> pair.v1)
                .sorted()
                .distinct()
                .collect(toList());
    }

    @Override
    public int E() {
        return this.edges.size();
    }

    static class Pair {
        final Integer v1;
        final Integer v2;

        Pair(Integer v1, Integer v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }
}
