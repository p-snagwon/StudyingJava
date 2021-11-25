package array.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> {

    private static final int DEFAULT_CAPACITY = 64;

    private Object[] array;
    private int size;

    private int front;
    private int rear;

    public ArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }


    public ArrayQueue(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    private void resize(int capacity) {
        int arrayCapacity = array.length;

        Object[] newArray = new Object[capacity];

        for (int i = 1, j = front + 1; i <= size; i++, j++) {
            newArray[i] = array[j % arrayCapacity];
        }

        this.array = null;
        this.array = newArray;

        front = 0;
        rear = size;
    }

    public boolean offer(E item) {
        //용적이 가득 찼을 경우

        if ((rear + 1) % array.length == front) {
            resize(array.length * 2);
        }

        rear = (rear + 1) % array.length;

        array[rear] = item;
        size++;

        return true;
    }

    @SuppressWarnings("unchecked")
    public E poll() {

        if (size == 0) {
            return null;
        }

        front = (front + 1) % array.length;

        E element = (E) array[front];

        array[front] = null;
        size--;

        if (array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {

            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));

        }

        return element;
    }

    public E remove() {
        E item  = poll();

        if (item == null) {
            throw new NoSuchElementException();
        }

        return item;
    }

    public boolean contains(Object value) {

        int start = (front + 1) % array.length;

        for (int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
            if (array[idx].equals(value)) {

                return true;
            }
        }
        return false;
    }
}
