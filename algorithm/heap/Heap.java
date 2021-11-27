package heap;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {


    private final Comparator<? super  E> comparator;
    private static final int DEFUALT_CAPACITY = 10;

    private Object[] array;

    private int size;


    // 용적의 크기가 디폴트일때 1. comparator 가 제공되는 경우 2. 제공되지 않는 경우
    // 용적의 크기가 제공되는 경우 1. comparator가 제공되는 경우 2. 제공되지않는 경우

    public Heap() {
        this(null);
    }

    public Heap(Comparator<? super E> comparator) {

        this.comparator = comparator;
        this.size = size;
        this.array = new Object[DEFUALT_CAPACITY];
    }

    public Heap(int capacity) {
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator) {
        this.size = 0;
        this.comparator = comparator;
        this.array = new Object[capacity];

    }

    private int getParent(int idx) {
        return idx / 2;
    }

    private int getLeftChild(int idx) {
        return idx * 2;
    }

    private int getRightChild(int idx) {
        return (idx * 2) + 1;
    }

    private void resize(int newCapacity) {

        Object[] newArray = new Object[newCapacity];

        for (int i = 1; i <= size; i++) {
            newArray[i] = array[i];
        }

        this.array = null;
        this.array = newArray;
    }

    public void add(E value) {

        if (size + 1 == array.length) {
            resize(array.length * 2);
        }

        siftUp(size + 1, value);
        size++;

    }

    //추가할 노드의 idx, target 재배치할 노드
    private void siftUp(int idx, E target) {

        if (comparator != null) {
            siftUpComparator(idx, target, comparator);
        } else {
            siftUpComparable(idx, target);
        }

    }

    private void siftUpComparable(int idx, E target) {

        Comparable<? super E> comparable = (Comparable<? super E>) target;

        while (idx > 1) {

            int parent = getParent(idx);

            Object parentVal = array[idx];

            if (comparable.compareTo((E) parentVal) >= 0) {
                break;
            }

            array[idx] = parentVal;
            idx = parent;
        }

        array[idx] = comparable;

    }

    private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {

        while (idx > 1) {
            int parent = getParent(idx);

            Object parentVal = array[parent];

            if (comp.compare(target, (E) parentVal) >= 0) {
                break;
            }

            array[idx] = parentVal;
            idx = parent;
        }

        array[idx] = target;
    }

    public E remove() {
        if (array[1] == null) {
            throw new NoSuchElementException();
        }

        E result = (E) array[1];
        E target = (E) array[size];
        array[size] = null;

        siftDown(1, target);

        return result;
    }

    private void siftDown(int idx, E target) {
        if (comparator != null) {
            siftDownComparator(idx, target, comparator);
        } else {
            siftDownComparable(idx, target);
        }
    }

    private void siftDownComparator(int idx, E target, Comparator<? super E> comparator) {
        array[idx] = null;
        size--;

        int parent = idx;
        int child;

        while ((child = getLeftChild(parent)) <= size) {
            int right = getRightChild(parent);

            Object childVal = array[child];

            if (right <= size && comparator.compare((E) childVal, (E) array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            //target이 크면 양수
            if (comparator.compare(target, (E) childVal) <= 0) {

                break;
            }

            array[parent] = childVal;
            parent = child;
        }
    }


}
