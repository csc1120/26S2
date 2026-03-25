package wk9;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BinarySearchTree<E extends Comparable<E>> {
    private final static class Node<E extends Comparable<E>> {
        private E value;
        private Node<E> leftKid;
        private Node<E> rightKid;
        private Node(E value, Node<E> left, Node<E> right) {
            this.value = value;
            leftKid = left;
            rightKid = right;
        }
        private Node(E value) {
            this(value, null, null);
        }
    }

    private Node<E> root;
    private boolean changed;

    public BinarySearchTree() {
        root = null;
        changed = false;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<E> node) {
        return node == null ? 0 : 1 + size(node.leftKid) + size(node.rightKid);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(E target) {
        return contains(root, target);
    }

    private boolean contains(Node<E> node, E target) {
        boolean found = false;
        if (node != null) {
            int comparison = node.value.compareTo(target);
            if (comparison == 0) {
                found = true;
            } else if (comparison < 0) {
                found = contains(node.rightKid, target);
            } else {
                found = contains(node.leftKid, target);
            }
        }
        return found;
    }

    public boolean add(E value) {
        changed = false;
        if (value == null) {
            throw new IllegalArgumentException("Tree does not support nulls");
        }
        if (root == null) {
            root = new Node<>(value);
            changed = true;
        } else {
            add(root, value);
        }
        return changed;
    }

    private void add(Node<E> node, E value) {
        int comparison = node.value.compareTo(value);
        if (comparison < 0) {
            if (node.rightKid == null) {
                node.rightKid = new Node<>(value);
                changed = true;
            } else {
                add(node.rightKid, value);
            }
        } else if (comparison > 0) {
            if (node.leftKid == null) {
                node.leftKid = new Node<>(value);
                changed = true;
            } else {
                add(node.leftKid, value);
            }
        }
    }

    public void preOrder(Consumer<E> consumer) {
        preOrder(root, consumer);
    }

    private void preOrder(Node<E> node, Consumer<E> consumer) {
        if (node != null) {
            consumer.accept(node.value);
            preOrder(node.leftKid, consumer);
            preOrder(node.rightKid, consumer);
        }
    }

    public void inOrder(Consumer<E> consumer) {
        inOrder(root, consumer);
    }

    private void inOrder(Node<E> node, Consumer<E> consumer) {
        if (node != null) {
            inOrder(node.leftKid, consumer);
            consumer.accept(node.value);
            inOrder(node.rightKid, consumer);
        }
    }

    public void postOrder(Consumer<E> consumer) {
        postOrder(root, consumer);
    }

    private void postOrder(Node<E> node, Consumer<E> consumer) {
        if (node != null) {
            postOrder(node.leftKid, consumer);
            postOrder(node.rightKid, consumer);
            consumer.accept(node.value);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        traverse(root, 1, (e, i) -> {
            sb.append(". ".repeat(i));
            sb.append(e.toString()).append("\n");
        });
        return sb.toString();
    }

    private void traverse(Node<E> node, int depth, BiConsumer<E, Integer> consumer) {
        if (node != null) {
            traverse(node.leftKid, depth + 1, consumer);
            consumer.accept(node.value, depth);
            traverse(node.rightKid, depth + 1, consumer);
        }
    }

}
