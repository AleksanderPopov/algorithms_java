package algorithms.datastructures.graph;


import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ConnectedComponents {

    public static void perform(Graph graph) {
        List<Pair> table = IntStream.range(0, graph.V())
                .mapToObj(i -> (Pair) null)
                .collect(toList());
        for (int v = 0, group = 0; v < graph.V(); v++) {
            if (table.get(v) == null) {
                processVerticle(graph, table, v, group++);
            }
        }

        String tableToString = IntStream.range(0, table.size())
                .mapToObj(i -> String.format("%d %s", i, table.get(i)))
                .reduce((f, s) -> String.format("%s\n%s", f, s))
                .orElseThrow(RuntimeException::new);

        System.out.println("------");
        System.out.println("CC:");
        System.out.println(tableToString);
        System.out.println("------");
    }

    private static void processVerticle(Graph graph, List<Pair> table, int v, int group) {
        table.set(v, new Pair(true, group));
        for (Integer adj : graph.adj(v)) {
            if (table.get(adj) == null) {
                processVerticle(graph, table, adj, group);
            }
        }
    }

    static class Pair {
        final Boolean v1;
        final Integer v2;

        Pair(Boolean v1, Integer v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public String toString() {
            return String.format("[visited - %s : group - %s]", this.v1, this.v2);
        }
    }
}
