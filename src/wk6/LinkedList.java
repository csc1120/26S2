package wk6;

public class LinkedList<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node (E data){
            this.data = data;
        }

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;

    public LinkedList(){
        head = null;
    }

    public int size(){
        if(head == null){
            return 0;
        } else {
            int count = 1;
            Node<E> walker = head;
            while(walker.next != null){
                walker = walker.next;
                count++;
            }
            return count;
        }
    }

    public boolean add(E e){
        if(head == null){
            head = new Node<>(e);
        } else {
            Node<E> tail = getNode(size() - 1);
            tail.next = new Node<>(e);
        }
        return true;
    }

    private Node<E> getNode(int index){
        Node<E> walker = head;
        int count = 0;
        while (walker.next != null && count < index) {
            walker = walker.next;
            count++;
        }
        return walker;
    }

    public E get(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Invalid index "+index);
        }
        return getNode(index).data;
    }

    public E remove(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Invalid index "+index);
        }
        if(index == 0){
            E ret = head.data;
            head = head.next;
            return ret;
        } else {
            Node<E> prev = getNode(index - 1);
            Node<E> curr = prev.next;
            prev.next = curr.next;
            return curr.data;
        }
    }

}