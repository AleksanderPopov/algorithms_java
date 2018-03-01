package algorithms.datastructures.graph;

import algorithms.datastructures.UnionFind;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.stream.Collectors.toList;

public class KruskalAlgorithm implements MSTAlgorithm {
    private final List<WeightedEdge> edges;

    public KruskalAlgorithm(EdgeWeigthedGraph graph) {
        this.edges = buildMST(graph);
    }

    private List<WeightedEdge> buildMST(EdgeWeigthedGraph graph) {
        List<WeightedEdge> result = new ArrayList<>();
        Queue<WeightedEdge> queue = new PriorityQueue<>(graph.edges());
        UnionFind unionFind = new UnionFind(graph.V());

        while (!queue.isEmpty() && result.size() < graph.V() - 1) {
            WeightedEdge edge = queue.poll();
            if (!unionFind.connected(edge.v(), edge.w())) {
                unionFind.union(edge.v(), edge.w());
                result.add(edge);
            }
        }

        return result.stream()
                .sorted((e1, e2) -> Integer.compare(e1.v(), e2.v() - Integer.compare(e1.w(), e2.w())))
                .collect(toList());
    }

    @Override
    public List<WeightedEdge> edges() {
        return this.edges;
    }
}
