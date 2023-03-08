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
            throw new DoubleEndedQueueException("Valor nulo");
        }
        DequeNode<T> node = new DequeNode<>(value,null,first);
        first.setPrevious(node);
        first = node;
        size++;

    }

    @Override
    public void append(T value) {
        if(value == null) {
            throw new DoubleEndedQueueException("Valor nulo");
        }
        DequeNode<T> node = new DequeNode<>(value, last, null);
        last.setNext(node);
        last = node;
        size++;
    }

    @Override
    public void deleteFirst() {
        first = first.getNext();
        first.setPrevious(null);
        size--;
    }

    @Override
    public void deleteLast() {
        last = last.getPrevious();
        last.setNext(null);
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

