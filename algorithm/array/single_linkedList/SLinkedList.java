package array.single_linkedList;

import java.util.NoSuchElementException;

public class SLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size; // 요소의 개수

    public SLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index) {

        //index가 범위에서 벗어난 경우
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> x = this.head;

        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x;
    }

    private void addFirst(E value) {

        Node<E> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;

        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    private boolean add(E value) {
        addLast(value);
        return true;
    }

    private void addLast(E value) {
        Node<E> newNode = new Node<>(value);

        //데이터가 없을떄
        if (size == 0) {
            addFirst(value);
            return;
        }

       tail.next = newNode;

        tail = newNode;
        size++;
    }

    private void add(int index, E value) {

        //index가 범위에서 벗어난 경우
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        //추가하려는 index가 가장 앞에 일 경우
        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        Node<E> newNode = new Node<>(value);

        Node<E> prev_Node = search(index - 1);

        Node<E> next_Node = prev_Node.next;

        // prev OO next_Node

        prev_Node.next = null;
        prev_Node.next = newNode;
        newNode.next = next_Node;
        size++;

    }

    public E remove() {
        // 가장 앞에 있는 데이터를 삭제;

        Node<E> headNode = this.head;

        //데이터가 없는 경우
        if (headNode == null) {
            throw new NoSuchElementException();
        }
        E element = head.data;

        Node<E> next_node = headNode.next;

        head.data = null;
        head.next = null;

        head = next_node;
        size--;

        if (size == 0) {
            tail = null;
        }

        return  element;

    }

    private E remove(int index) {

        //index가 범위에서 벗어난 경우
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {

            return remove();
        }

        Node headNode = this.head;

        Node<E> removedNode = search(index);
        Node<E> prevNode = search(index - 1);
        Node<E> nextNode = removedNode.next;

        E element = removedNode.data;
        // prev  searched  next

        removedNode.data = null;
        removedNode.next = null;
        size--;

        prevNode.next = nextNode;


        return element;
    }

    private boolean remove(Object value) {
        // 일단 value가 있는지 확인해봐야하거든?



    }
}
