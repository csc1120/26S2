package wk4;


import java.util.*;

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
        Object[] newGuy = Arrays.copyOf(data, data.length + 1);
        newGuy[newGuy.length - 1] = e;
        data = newGuy;
        return true;
    }

    @Override
    public E remove(int index) {
        E old = (E) data[index];
        Object[] newGuy = new Object[data.length - 1];
        System.arraycopy(data, 0, newGuy, 0, index);
        if (newGuy.length - index >= 0) {
            System.arraycopy(data, index + 1, newGuy, index, newGuy.length - index);
        }
        data = newGuy;
        return old;
    }

    @Override
    public boolean contains(Object target) {
        //return indexOf(target) >= 0;
        boolean foundIt = false;
        for (int i = 0; !foundIt && i < data.length; i++) {
            foundIt = Objects.equals(data[i], target);
        }
        return foundIt;
    }

    @Override
    public int indexOf(Object target) {
        int indexFound = -1;
        for (int i = 0; indexFound == -1 && i < data.length; i++) {
//            if (Objects.equals(data[i], target)) {
//                indexFound = i;
//            }
            indexFound = Objects.equals(data[i], target) ? i : -1;
        }
        return indexFound;
    }

    @Override
    public boolean remove(Object target) {
        boolean removed = false;
        int location = indexOf(target);
        if (location != -1) {
            remove(location);
            removed = true;
        }
        return removed;
    }

    @Override
    public Object[] toArray() {
        return data;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Object[] newGuy = new Object[data.length + 1];
        System.arraycopy(data, 0, newGuy, 0, index);
        newGuy[index] = element;
        System.arraycopy(data, index + 1, newGuy, index, newGuy.length - index);
    }

    //region Unsupported Operations
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    //endregion
}
