package wk7;

import java.util.NoSuchElementException;

public class CircularQueue<E> implements PureQueue<E> {
    public final static int DEFAULT_CAPACITY = 1024;
    private Object[] data;
    private int front;
    private int back;
    private int size;

    public CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircularQueue(int capacity) {
        data = new Object[capacity];
        front = 0;
        back = 0;
        size = 0;
    }

    @Override
    public boolean offer(E element) {
        boolean added = false;
        if (size < data.length) {
            added = true;
            data[back] = element;
            size++;
            back = (back + 1) % data.length;
        }
        return added;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (E) data[front];
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E retVal = (E) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        --size;
        return retVal;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
