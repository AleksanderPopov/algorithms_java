package algorithms.datastructures.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class TopologicalSort {
    public static void perform(Graph graph) {
        if (graph.type() != GraphType.DIRECTED) {
            throw new RuntimeException();
        }
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int v = 0; v < graph.V(); v++) {
            if (!visited.contains(v)) {
                topologicalSort(graph, queue, visited, v);
            }
        }
        String result = IntStream.range(0, graph.V())
                .mapToObj(i -> queue.remove())
                .map(String::valueOf)
                .reduce((f, s) -> f + " " + s)
                .orElseThrow(RuntimeException::new);
        System.out.println("Topological sort: " + result);
    }

    private static void topologicalSort(Graph graph, Queue<Integer> stack, List<Integer> visited, int v) {
        visited.add(v);
        List<Integer> adjs = graph.adj(v);
        if (adjs.size() > 0) {
            for (int adj : adjs) {
                if (!visited.contains(adj)) {
                    topologicalSort(graph, stack, visited, adj);
                }
            }
        }
        stack.add(v);
    }
}
