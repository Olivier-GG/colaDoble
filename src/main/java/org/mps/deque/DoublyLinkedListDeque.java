package org.mps.deque;

import java.util.Comparator;

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

        DequeNode<T> node = new DequeNode<>(value,null,first);
        if(size == 0){
            last = node;
        } else {
            first.setPrevious(node);
        }
        first = node;
        size++;

    }

    @Override
    public void append(T value) {

        DequeNode<T> node = new DequeNode<>(value, last, null);
        if(size == 0){
            first = node;
        } else {
            last.setNext(node);
        }
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

        if (size == 0) {
            throw new DoubleEndedQueueException("Cola vacia, no se puede extraer el elemento");
        }

        return first.getItem();
    }

    @Override
    public T last() {

        if (size == 0) {
            throw new DoubleEndedQueueException("Cola vacia, no se puede extraer el elemento");
        }

        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        int counter = 0;
        DequeNode<T> actual = first;

        while(counter < index){
            actual = actual.getNext();
            counter++;
        }

        return actual.getItem();
    }

    @Override
    public boolean contains(T value) {

        int counter = 0;
        DequeNode<T> actual = this.first;
        boolean encontrado = false;

        while(counter < this.size && !encontrado){
            if(actual.getItem().equals(value)){
                encontrado = true;
            }
            actual = actual.getNext();
            counter++;
        }

        return encontrado;
    }

    @Override
    public void remove(T value) {

        DequeNode<T> nodo1 = getNode(getIndex(value));

        if(nodo1 != null) {

            if (nodo1.getPrevious() == null && nodo1.getNext() == null) {
                this.first = null;
                this.last = null;
            } else if (nodo1.getPrevious() == null) {
                nodo1.getNext().setPrevious(null);
                this.first = nodo1.getNext();
            } else if (nodo1.getNext() == null) {
                nodo1.getPrevious().setNext(null);
                this.last = nodo1.getPrevious();
            } else {
                nodo1.getPrevious().setNext(nodo1.getNext());
                nodo1.getNext().setPrevious(nodo1.getPrevious());
            }

            size--;
        }
    }


    @Override
    public void sort(Comparator<? super T> comparator) {
        boolean seguir = true;
        for(int i=this.size-1; seguir; i--) {
            seguir = false;
            for(int j=0; j<i; j++)
                if(comparator.compare(this.get(j),this.get(j+1))>0) {
                    intercambiar(j, j+1);
                    seguir = true;
                }
        }

    }

    private void intercambiar (int a, int b) {

        DequeNode<T> nodo1 = this.getNode(a) , nodo2 = this.getNode(b);

        T aux = nodo1.getItem();

        nodo1.setItem(nodo2.getItem());
        nodo2.setItem(aux);

    }

    private DequeNode<T> getNode(int index) {
        if(index < 0){
            return null;
        }

        int i = 0;
        DequeNode<T> res = this.first;

        while (i< index) {
            res = res.getNext();
            i++;
        }

        return res;

    }

    private int getIndex(T value){

        int counter = 0;
        DequeNode<T> actual = this.first;
        boolean encontrado = false;

        while(counter < this.size && !encontrado){
            if(actual.getItem().equals(value)){
                encontrado = true;
            }
            actual = actual.getNext();
            counter++;
        }

        return encontrado? counter-1 : -1;
    }

}

