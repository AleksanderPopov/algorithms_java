package algorithms.datastructures.graph;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

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
    public GraphType type() {
        return this.graphType;
    }

    @Override
    public String toString() {
        return (this.type() == GraphType.DIRECTED
                ? IntStream.range(0, this.V())
                .mapToObj(from -> String.format("%d -> %s", from, IntStream.range(0, this.V())
                        .boxed()
                        .filter(to -> to != from && this.adj(to).contains(from))
                        .collect(toList())))
                : IntStream.range(0, this.V())
                .mapToObj(v -> String.format("%d -> %s", v, this.adj(v)))
        ).reduce((f, s) -> String.format("%s\n%s", f, s))
                .orElseThrow(RuntimeException::new);
    }
}
