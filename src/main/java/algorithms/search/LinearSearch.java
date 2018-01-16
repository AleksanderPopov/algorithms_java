package algorithms.search;

public class LinearSearch {
    public static <T> int perform(T[] source, T value) {
        for (int i = 0; i < source.length; i++) {
            if (value.equals(source[i])) {
                return i;
            }
        }
        return -1;
    }
}
