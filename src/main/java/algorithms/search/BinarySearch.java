package algorithms.search;

public class BinarySearch {
    public static <T extends Comparable<T>> int perform(T[] source, T value) {
        int i = source.length / 2;
        while (value.compareTo(source[i]) != 0) {
            if (i <= 1 || i > source.length - 1) {
                return -1;
            }
            i = value.compareTo(source[i]) < 0 ? i / 2 : i + i / 2;
        }
        return i;
    }
}
