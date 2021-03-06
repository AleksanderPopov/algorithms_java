package algorithms.datastructures.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.IntStream;

public class BFS {
    public static void perform(Graph graph, int v) {
        Pair[] table = new Pair[graph.V()];
        perform(graph, table, v);

        String tableToString = IntStream.range(0, table.length)
                .mapToObj(i -> String.format("%d %s", i, table[i]))
                .reduce((f, s) -> String.format("%s\n%s", f, s))
                .orElseThrow(RuntimeException::new);

        System.out.println("------");
        System.out.println("BFS:");
        System.out.println(tableToString);
        System.out.println("------");
    }

    private static void perform(Graph graph, Pair[] table, Integer v) {
        table[v] = new Pair(true, null);

        Queue<Integer> queue = new ArrayDeque<>(graph.V());
        queue.add(v);

        while (!queue.isEmpty()) {
            Integer cv = queue.poll();
            graph.adj(cv).forEach(adj -> {
                if (table[adj] == null || !table[adj].v1) {
                    queue.add(adj);
                    table[adj] = new Pair(true, cv);
                }
            });
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
            return String.format("[visited - %s : edge from - %s]", this.v1, this.v2);
        }
    }
}
