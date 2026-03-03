package wk7;

interface PureQueue<E> {
    boolean offer(E element);
    E peek();
    E poll();
    int size();
    boolean isEmpty();
}
