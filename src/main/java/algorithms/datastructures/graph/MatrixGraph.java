package algorithms.datastructures.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class MatrixGraph extends AbstractGraph {

    private final int[][] matrix;
    private int E = 0;

    public MatrixGraph(GraphType graphType, int size) {
        super(graphType, size);
        this.matrix = new int[size][size];
    }

    @Override
    public void addEdge(int v1, int v2) {
        this.matrix[v1][v2] = 1;
        if (this.graphType == GraphType.UNDIRECTED) {
            this.matrix[v2][v1] = 1;
        }
        this.E++;
    }

    @Override
    public List<Integer> adj(int v) {
        return IntStream.range(0, this.matrix.length)
                .boxed()
                .filter(i -> this.matrix[i][v] == 1)
                .collect(toList());
    }

    @Override
    public int E() {
        return this.E;
    }

}
