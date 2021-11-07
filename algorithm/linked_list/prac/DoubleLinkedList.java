package algorithm.linked_list.prac;

public class DoubleLinkedList<T> {

    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        public T data;

        public Node<T> prev = null;
        public Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public boolean insertToFrontData(T data, T isData) {
        if (this.head == null) {
            Node<T> node = new Node<>(data);
            node = this.head;
            return true;
        } else if (this.head.data == isData) {
            Node<T> newNode = new Node<>(data);
            newNode.next = this.head;
            newNode = this.head;
            return true;
        } else {
            Node node = this.head;
            while (node != null) {
                if (node.data == isData) {
                    Node prevNode = node.prev;
                    prevNode.next = new Node<>(data);
                    prevNode.next.next = node;

                    node.prev = prevNode.next;
                    prevNode.next.prev = node.prev;
                }
            }
            return false;
        }
    }
    public T searchFromHead(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    public T searchedFromTail(T isData) {
        if (this.tail == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public void printAll() {
        if (this.head != null) {
            Node node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList MyLinkedList = new DoubleLinkedList();

        MyLinkedList.addNode(2);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);
        MyLinkedList.addNode(6);
        MyLinkedList.addNode(8);
        MyLinkedList.printAll();
        System.out.println();

        System.out.println(MyLinkedList.searchFromHead(4));
        System.out.println(MyLinkedList.searchedFromTail(5));
        System.out.println(MyLinkedList.searchedFromTail(9));


        MyLinkedList.insertToFrontData(4, 3);

        System.out.println();
        MyLinkedList.printAll();
    }
}
