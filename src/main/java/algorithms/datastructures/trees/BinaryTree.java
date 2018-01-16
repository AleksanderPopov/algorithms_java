package algorithms.datastructures.trees;

public class BinaryTree<V extends Comparable<? super V>> {
    private Entry<V> root;

    public BinaryTree() {
    }

    public void insert(V val) {
        if (this.root == null) {
            this.root = new Entry<>(val, null, null, null);
        } else {
            this.insert(this.root, val);
        }
    }

    private void insert(Entry<V> entry, V val) {
        int result = val.compareTo(entry.value);
        if (result == 0) {
            entry.count++;
        } else if (result < 0) {
            if (entry.left == null) {
                entry.left = new Entry<>(val, null, null, entry);
            } else {
                this.insert(entry.left, val);
            }
        } else {
            if (entry.right == null) {
                entry.right = new Entry<>(val, null, null, entry);
            } else {
                this.insert(entry.right, val);
            }
        }
    }

    public V min() {
        if (this.root == null) {
            return null;
        } else {
            Entry<V> tmp = root;
            while (tmp.left != null) tmp = tmp.left;
            return tmp.value;
        }
    }

    public V max() {
        if (this.root == null) {
            return null;
        } else {
            Entry<V> tmp = root;
            while (tmp.right != null) tmp = tmp.right;
            return tmp.value;
        }
    }

    public void remove(V val) {
        Entry<V> tmp = root;
        while (tmp != null && !val.equals(tmp.value)) {
            if (val.compareTo(tmp.value) < 0) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        if (tmp == null) {
            return;
        }
        Entry<V> minBranch = tmp.left;
        Entry<V> maxBranch = tmp.right;
        boolean isRoot = tmp.top == null;
        if (isRoot) {
            if (minBranch == null) this.root = maxBranch;
            else if (maxBranch == null) this.root = minBranch;
            else {
                this.root = maxBranch;
                tmp = maxBranch;
                while (tmp.left != null) tmp = tmp.left;
                tmp.left = minBranch;
            }
        } else {
            boolean isTmpLeft = tmp.top.left == tmp;
            if (isTmpLeft) {
                if (minBranch == null) tmp.top.left = maxBranch;
                else if (maxBranch == null) tmp.top.left = minBranch;
                else {
                    tmp.top.left = maxBranch;
                    tmp = maxBranch;
                    while (tmp.left != null) tmp = tmp.left;
                    tmp.left = minBranch;
                }
            } else {
                if (minBranch == null) tmp.top.right = maxBranch;
                else if (maxBranch == null) tmp.top.right = minBranch;
                else {
                    tmp.top.right = maxBranch;
                    tmp = maxBranch;
                    while (tmp.left != null) tmp = tmp.left;
                    tmp.left = minBranch;
                }
            }
        }

    }

    @Override
    public String toString() {
        return "[" + this.root.toString() + "]";
    }

    private static class Entry<V> {
        V value;
        Entry<V> top;
        Entry<V> left;
        Entry<V> right;
        int count = 1;

        public Entry(V value, Entry<V> left, Entry<V> right, Entry<V> top) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.top = top;
        }

        @Override
        public String toString() {
            return (this.left == null ? "" : this.left.toString() + ", ") +
                    this.value.toString() +
                    (this.right == null ? "" : ", " + this.right.toString());
        }
    }
}
