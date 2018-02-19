package algorithms.datastructures.graph;

import java.util.stream.IntStream;

public abstract class AbstractGraph implements Graph {

    protected final GraphType graphType;
    protected final int size;

    AbstractGraph(GraphType graphType, int size) {
        this.graphType = graphType;
        this.size = size;
    }

    @Override
    public int V() {
        return this.size;
    }

    @Override
    public String toString() {
        return IntStream.range(0, this.V())
                .mapToObj(i -> String.format("%d -> %s", i, this.adj(i)))
                .reduce((f, s) -> String.format("%s\n%s", f, s))
                .orElseThrow(RuntimeException::new);
    }
}
