package algorithms.datastructures.graph;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DFS {
    public static void perform(Graph graph, int v) {
        Pair[] table = new Pair[graph.V()];
        perform(graph, table, null, v);

        String tableToString = IntStream.range(0, table.length)
                .mapToObj(i -> String.format("%d %s", i, table[i]))
                .reduce((f, s) -> String.format("%s\n%s", f, s))
                .orElseThrow(RuntimeException::new);

        System.out.println("------");
        System.out.println("DFS:");
        System.out.println(tableToString);
        System.out.println("------");
    }

    private static void perform(Graph graph, Pair[] table, Integer fv, Integer v) {
        table[v] = new Pair(true, fv);
        graph.adj(v).forEach(adj -> {
            if (table[adj] == null || !table[adj].v1) {
                perform(graph, table, v, adj);
            }
        });
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
            return String.format("[visited - %s : edge from - %s]", this.v1, this.v2);
        }
    }
}
