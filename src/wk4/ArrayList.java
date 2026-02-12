package wk4;


import java.util.List;
import java.util.Collection;
import java.util.RandomAccess;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList<E> implements List<E>, RandomAccess {
    private Object[] data;

    public ArrayList() {
        data = new Object[0];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public void clear() {
        data = new Object[0];
    }

    @Override
    public E get(int index) {
        return (E) data[index];
    }

    @Override
    public E set(int index, E element) {
        E old = (E) data[index];
        data[index] = element;
        return old;
    }

    @Override
    public boolean add(E e) {
        Object[] newGuy = new Object[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            newGuy[i] = data[i];
        }
        newGuy[newGuy.length - 1] = e;
        data = newGuy;
        return true;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
