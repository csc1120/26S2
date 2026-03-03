package wk7;

import java.util.List;

public class Queue<E> implements PureQueue<E> {
    private final List<E> data;

    public Queue(List<E> list) {
        data = list;
        data.clear();
    }

    @Override
    public boolean offer(E element) {
        return data.add(element);
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public E poll() {
        return data.removeFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
