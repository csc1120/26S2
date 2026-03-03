package wk7;

import wk6.LinkedList;

import java.util.List;

public class Stack<E> implements PureStack<E> {
    private final List<E> data;

    public Stack(List<E> list) {
        data = list;
        data.clear();
    }

    @Override
    public boolean push(E element) {
        return data.add(element);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
