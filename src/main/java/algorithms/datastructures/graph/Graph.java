package algorithms.datastructures.graph;

import java.util.List;

public interface Graph {

    void addEdge(int v1, int v2);

    List<Integer> adj(int v);

    int V();

    int E();
}
