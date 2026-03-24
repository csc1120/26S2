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

    public BinarySearchTree() {
        root = null;
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

    public void add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Tree does not support nulls");
        }
        if (root == null) {
            root = new Node<>(value);
        } else {
            add(root, value);
        }
    }

    private void add(Node<E> node, E value) {
        int comparison = node.value.compareTo(value);
        if (comparison < 0) {
            if (node.rightKid == null) {
                node.rightKid = new Node<>(value);
            } else {
                add(node.rightKid, value);
            }
        } else if (comparison > 0) {
            if (node.leftKid == null) {
                node.leftKid = new Node<>(value);
            } else {
                add(node.leftKid, value);
            }
        }
    }

}
