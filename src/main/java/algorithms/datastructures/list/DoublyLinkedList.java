package algorithms.datastructures.list;

public class DoublyLinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public DoublyLinkedList() {
    }

    @Override
    public void add(T item) {
        if (this.head == null) {
            this.head = this.tail = new Node<>(null, item, null);
        } else {
            this.tail.next = new Node<>(this.tail, item, null);
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
        Node<T> tmp = this.getNode(index);
        Node<T> prev = tmp.prev;
        Node<T> next = tmp.next;

        prev.next = next;
        next.prev = prev;
        size--;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(T item) {
        return this.getNode(item) != null;
    }

    private Node<T> getNode(int index) {
        if (index >= this.size() || index < 0) throw new RuntimeException();

        Node<T> tmp;
        if (this.size() - index > index) {
            tmp = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
        } else {
            tmp = tail;
            for (int i = this.size() - 1; i > index; i--) {
                tmp = tmp.prev;
            }
        }
        return tmp;
    }

    private Node<T> getNode(T item) {
        Node<T> tmp = this.head;
        while (tmp != null) {
            if (tmp.value != null && tmp.value.equals(item)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
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
        public Node<T> prev;
        public T value;
        public Node<T> next;

        public Node(Node<T> prev, T value, Node<T> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
