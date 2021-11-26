package heap;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E>{

    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10;


    private int size; // 요소 개수

    private Object[] array;

    //생성자 Type1
    public Heap() {
        this(null);
    }

    public Heap(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    public Heap(int capacity) {
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator) {
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    private int getParent(int index) {
        return index /2;
    }

    private int getLeftChild(int index) {
        return index * 2;
    }

    private int getRightChild(int index) {
        return index * 2 + 1;
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
        if (size == array.length + 1) {
            resize(array.length * 2);
        }

        siftUp(size + 1, value);
        size++;
    }

    private void siftUp(int idx, E target) {
        if (comparator != null) {
            siftUpComparator(idx, target, comparator);
        } else {
            siftUpComparable(idx, target);
        }
    }

    private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {

        while (idx > 1) {
            int parent = getParent(idx);
            Object parentVal = array[parent];

            //타겟 노드 값이 부모노드보다 크면 종료
            if (comp.compare(target, (E) parentVal) >= 0) {
                break;
            }

            array[idx] = parentVal;
            idx = parent;

        }

        array[idx] = target;
    }

    private void siftUpComparable(int idx, E target) {
        //타겟 노드가 비교할 수 있도록 한 변수를 만든다.

        Comparable<? super E> comp = (Comparable<? super E>) target;

        while (idx > 1) {
            int parent = getParent(idx);
            Object parentVal = array[parent];

            if (comp.compareTo((E) parentVal) >= 0) {
                break;
            }

            array[idx] = parentVal;
            idx = parent;
        }

        array[idx] = comp;
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
            siftDownComparator(idx, target);
        }
    }

    private void siftDownComparator(int idx, E target, Comparator<? super E> comp) {
        array[idx] = null;
        size--;

        int parent = idx;
        int child; //교환될 자식을 가리키는 변수

        while ((child = getLeftChild(parent))<= size) {

            int right = getRightChild(parent);

            Object childVal = array[child]; //왼쪽 값

            if (right <= size && comp.compare((E) childVal, (E) array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            if (comp.compare(target, (E) childVal) <= 0) {
                break;;
            }

            array[parent] = childVal;
            parent = child;

        }

        array[parent] = target;


        if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length /2));
        }


    }

    private void siftDownComparable(int idx, E target) {
        Comparable<? super E> comp = (Comparable<? super E>) target;

        array[idx] = null;
        size--;

        int parent = idx;
        int child;

        while ((child = getLeftChild(parent)) <= size) {
            int right = getRightChild(parent);

            Object childVal = array[child];

            if(right <= size && ((Comparable<? super E>)childVal).compareTo((E)array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            if (comp.compareTo((E) childVal) <= 0) {
                break;
            }

            array[parent] = childVal;
            parent = child;
        }
        array[parent] = comp;


        if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

    }
}
