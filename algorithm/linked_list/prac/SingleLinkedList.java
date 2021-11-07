package algorithm.linked_list.prac;

import com.sun.javafx.scene.NodeEventDispatcher;

public class SingleLinkedList<T> {
    public Node<T> head = null;

    public class Node<T> {
        public T data;
        public Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<>(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(data);
        }
    }

    public void printAll() {

        if (this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public void addNodeInside(T data, T isData) {
        Node searchedNode = search(isData);

        if (searchedNode == null) {
            addNode(data);
        } else {
            Node searchedNodeNext = searchedNode.next;
            searchedNode.next = new Node<>(data);
            searchedNode.next.next = searchedNodeNext;


        }
    }


    private Node search(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node node = this.head;
            while (node != null) {
                if (node.data == isData) {
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }

}

    private boolean delete(T isData) {
        if (this.head == null) {
            return false;
        } else {
            Node node = this.head;
            if (node.data == isData) {
                this.head = node.next;
                return true;
            } else {
                while (node.next != null) {
                    if (node.next.data == isData) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addNode(1);
        singleLinkedList.addNode(2);
        singleLinkedList.addNode(3);
        singleLinkedList.addNode(5);

        singleLinkedList.printAll();
        System.out.println();

        singleLinkedList.addNodeInside(4, 3);
        singleLinkedList.printAll();
        System.out.println();

        singleLinkedList.delete(2);
        singleLinkedList.printAll();
        System.out.println();
    }
}
