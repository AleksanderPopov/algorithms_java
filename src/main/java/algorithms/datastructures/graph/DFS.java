package algorithms.datastructures.graph;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DFS {
    public static void perform(Graph graph, int v) {
        Pair<Boolean, Integer>[] table = new Pair[graph.V()];
        perform(graph, table, null, v);

        String tableToString = IntStream.range(0, table.length)
                .mapToObj(i -> String.format("%d %s", i, table[i]))
                .reduce((f, s) -> String.format("%s\n%s", f, s))
                .orElseThrow(RuntimeException::new);

        System.out.println("DFS:");
        System.out.println(tableToString);
    }

    private static void perform(Graph graph, Pair<Boolean, Integer>[] table, Integer fv, Integer v) {
        table[v] = new Pair<>(true, fv);
        graph.adj(v).forEach(adj -> {
            if (table[adj] == null || !table[adj].v1) {
                perform(graph, table, v, adj);
            }
        });
    }

    static class Pair<K, V> {
        public final K v1;
        public final V v2;

        public Pair(K v1, V v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public String toString() {
            return String.format("[visited - %s : edge from - %s]", this.v1, this.v2);
        }
    }
}
