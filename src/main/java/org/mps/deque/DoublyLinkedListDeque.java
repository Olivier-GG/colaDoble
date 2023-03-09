package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    protected DequeNode<T> first;
    protected DequeNode<T> last;
    protected int size;

    public DoublyLinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        if (value == null) {
            throw new DoubleEndedQueueException("Valor introducido nulo");
        }
        DequeNode<T> node = new DequeNode<>(value,null,first);
        if(size == 0){
            last = node;
        }
        first.setPrevious(node);
        first = node;
        size++;

    }

    @Override
    public void append(T value) {
        if(value == null) {
            throw new DoubleEndedQueueException("Valor introducido nulo");
        }
        DequeNode<T> node = new DequeNode<>(value, last, null);
        if(size == 0){
            first = node;
        }
        last.setNext(node);
        last = node;
        size++;
    }

    @Override
    public void deleteFirst() {
        if(size == 0){
            throw new DoubleEndedQueueException("La cola está vacía, no se pueden eliminar elementos");
        }
        first = first.getNext();    //null si solo queda un elemento (size == 1)
        if(first == null){
            last = null;
        } else {
            first.setPrevious(null);
        }
        size--;
    }

    @Override
    public void deleteLast() {
        if(size == 0){
            throw new DoubleEndedQueueException("La cola está vacía, no se pueden eliminar elementos");
        }
        last = last.getPrevious();  //null si solo queda un elemento (size == 1)
        if(last == null){
            first = null;
        } else {
            last.setNext(null);
        }
        size--;
    }

    @Override
    public T first() {
        return first.getItem();
    }

    @Override
    public T last() {
        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }
}

