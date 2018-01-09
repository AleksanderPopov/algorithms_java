package algorithms.datastructures.stack;

public class StackLinkedList<T> implements Stack<T> {
    private Node<T> head = null;

    public StackLinkedList() {
    }

    public void push(T item) {
        this.head = new Node<>(this.head, item);
    }

    public T pop() {
        try {
            return peek();
        } finally {
            this.head = this.head.next;
        }
    }

    public T peek() {
        return this.head.value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> tmp = head;
        while (tmp != null) {
            builder = builder.append(tmp.value.toString()).append(", ");
            tmp = tmp.next;
        }
        builder.setLength(builder.length() - 2);
        builder = builder.append("]");
        return builder.toString();
    }

    private static class Node<T> {
        public Node<T> next;
        public T value;

        public Node(Node<T> next, T value) {
            this.next = next;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

}
