package algorithms.datastructures.list;

public class SingleLinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public SingleLinkedList() {
    }

    @Override
    public void add(T item) {
        if (this.head == null) {
            this.head = this.tail = new Node<>(null, item);
        } else {
            this.tail.next = new Node<>(null, item);
            this.tail = this.tail.next;
        }
        size++;
    }

    @Override
    public T set(int index, T item) {
        Node<T> tmp = this.getNode(index);
        T tmpval = tmp.value;
        tmp.value = item;
        return tmpval;
    }

    @Override
    public T get(int index) {
        return this.getNode(index).value;
    }

    @Override
    public void remove(int index) {
        Node<T> prev = this.getNode(index - 1);
        Node<T> next = this.getNode(index + 1);
        prev.next = next;
        size--;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(T item) {
        Node<T> tmp = head;
        while (tmp != null && tmp.value != item && !tmp.value.equals(item)) tmp = tmp.next;
        return tmp.next != null;
    }

    private Node<T> getNode(int index) {
        if (index >= this.size()) throw new RuntimeException();
        Node<T> tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
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
                    ", next=" + next +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            if (next != null ? !next.equals(node.next) : node.next != null) return false;
            return value.equals(node.value);
        }

        @Override
        public int hashCode() {
            int result = next != null ? next.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }
}
