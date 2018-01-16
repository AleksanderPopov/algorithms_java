package algorithms.datastructures;

import algorithms.datastructures.trees.BinaryTree;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {
    @Test
    public void test() {
        for (int i = 0; i < 1000; i++) {
//            List<Integer> a = new Random().ints(1000, 10_000).limit(10).distinct().boxed().collect(toList());
            List<Integer> a = IntStream.of(9931, 2186, 8488, 4794, 2973, 6851, 5597, 4821, 7046, 5243).boxed().collect(toList());
            Integer max = a.stream().max(Integer::compareTo).get();
            Integer min = a.stream().min(Integer::compareTo).get();
            Collections.shuffle(a);
            BinaryTree<Integer> binaryTree = new BinaryTree<>();
            a.forEach(binaryTree::insert);
            String descr = String.format("\nwas: %s\nin tree: %s\nexpected max: [%s] actual max [%s]\nexpected min: [%s] actual min: [%s]\n", a, binaryTree, max, binaryTree.max(), min, binaryTree.min());
            assertEquals(a.stream().sorted().map(String::valueOf).reduce((i1, i2) -> String.format("%s, %s", i1, i2)).get(), binaryTree.toString().replaceAll("\\[", "").replaceAll("]", ""));
            assertEquals(descr, max, binaryTree.max());
            assertEquals(descr, min, binaryTree.min());
            binaryTree.remove(max);
            descr+= String.format("after removing max: %s\n", binaryTree);
            assertEquals(descr, false, max.equals(binaryTree.max()));
            binaryTree.remove(min);
            descr+= String.format("after removing min: %s\n", binaryTree);
            try {
            assertEquals(descr, false, min.equals(binaryTree.min()));

            } catch (Error error) {
                binaryTree.remove(min);
            }
        }
    }
}
