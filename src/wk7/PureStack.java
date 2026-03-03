package wk7;

interface PureStack<E> {
    boolean push(E element);
    E pop();
    int size();
    E peek();
    boolean isEmpty();
}
