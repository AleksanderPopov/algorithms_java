package algorithms.datastructures.queue;


public class QueueLinkedList<T> implements Queue<T> {
    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public void add(T item) {
        if (this.head == null) {
            this.head = this.tail = new Node<>(null, item);
        } else {
            this.tail.next = new Node<>(null, item);
            this.tail = this.tail.next;
        }
    }

    @Override
    public T remove() {
        T result = this.peek();
        this.head = this.head.next;
        return result;
    }

    @Override
    public T peek() {
        return (T) this.head.value;
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
