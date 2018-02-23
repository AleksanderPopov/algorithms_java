package algorithms.datastructures.graph;


import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class StrongComponents {
    public static void perform(Graph graph, int v1, int v2) {

        boolean result = perform(
                graph,
                IntStream.range(0, graph.V()).mapToObj(i -> false).collect(toList()),
                v1,
                v2
        ) && perform(
                graph,
                IntStream.range(0, graph.V()).mapToObj(i -> false).collect(toList()),
                v2,
                v1);

        System.out.println("------");
        System.out.println(String.format("%d and %d are%s strongly connected", v1, v2, result ? "" : " not"));
        System.out.println("------");
    }

    private static boolean perform(Graph graph, List<Boolean> table, Integer v, Integer find) {
        table.set(v, true);
        List<Integer> adjs = graph.adj(v);
        return adjs.contains(find) || adjs.stream().map(adj -> !table.get(adj) && perform(graph, table, adj, find)).filter(b -> b).count() > 0;
    }

}
