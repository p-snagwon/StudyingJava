package array.doubleLinkedList;

import java.util.NoSuchElementException;

public class DLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;    // 노드수

    private DLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        //뒈에서 검색
        if (index > size / 2) {
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }

        //앞에서 부터 검색
         else{
             Node<E> x = head;

            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        }
    }

    private void addFirst(E value) {

        //

        Node<E> newNode = new Node<>(value);
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

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

        if (size == 0) {
            addFirst(value);
            return;
        }

        Node<E> newNode = new Node<>(value);

        this.tail.next = newNode;
        newNode.prev = this.tail;

        this.tail = newNode;
        size++;
    }

    private void add(int index, E value) {

        Node<E> prevNode = search(index -1);
        Node<E> nextNode = prevNode.next;


        // prev  searched
        //근데 찾는 인덱스가 0이면 괜찮나?
        //prev = null;

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        //데이터가 전혀 없는 경우

        Node<E> newNode = new Node<>(value);

        prevNode.next = null;
        nextNode.prev = null;

        prevNode.next = newNode;

        newNode.prev = prevNode;
        newNode.next = nextNode;

        nextNode.prev = newNode;
        size++;




    }

    private E remove() {
        //노드가 전혀 없는 경우
        Node<E> node = this.head;

        if (node == null) {
            throw new NoSuchElementException();
        }
        E element = node.data;

        head.next = null;
        head.data = null;

        Node<E> nextNode = node.next;

        //head, nextNode

        if (nextNode != null) {
            nextNode.prev = null;
        }

        this.head = nextNode;
        size--;

        if (size == 0) {
            tail = null;
        }

        return element;
    }

    private E remove(int index) {
        // index가 범위에 벗어나는지 확인
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = this.head;

        //index가 head일경우 와 tail 경우
        if (index == 0) {
            E element = node.data;

            node.data = null;
            node.next = null;

            if (node.next != null) {
                node.next.prev = null;
                node.next = this.head;
            }
            size--;
            return element;
        }

        Node<E> tail = this.tail;

        Node<E> prevNode = search(index - 1);
        Node<E> removedNode = prevNode.next;
        Node<E> nextNode = removedNode.next;

        E element = removedNode.data;

        // 여기까지 오면 일단 항상 prevNode는 있다.

        prevNode.next = null;
        removedNode.data = null;
        removedNode.next = null;
        removedNode.prev = null;

        if (nextNode != null) {
            nextNode.prev = null;

            nextNode.prev = prevNode;
            prevNode.next = nextNode;
        }

        //nextNode가 null이라는 삭제된 노드는 PREQ
        else {
            tail = prevNode;
        }

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        size--;

        return element;
    }

    private boolean remove(Object value) {
        Node<E> prevNode = head;
        Node<E> x = head;

        for (; x != null; x = x.next) {
            if (value.equals(x.data)) {
                break;
            }
            prevNode = x;
        }

        if (x == null) {
            return false;
        }

        if (x.equals(head)) {
            remove();
            return true;
        }
        else {
            //head node

            Node<E> nextNode = x.next;

            prevNode.next = null;
            x.data = null;
            x.next = null;
            x.prev = null;

            if (nextNode != null) {
                nextNode.prev = null;

                nextNode.prev = prevNode;
                prevNode.next = nextNode;
            } else {
                tail = prevNode;
            }
        }
        size--;
        return true;
    }

    public static void main(String[] args) {
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.addFirst(3);
    }
}
