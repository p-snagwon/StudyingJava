package algorithm.linked_list;

public class SingleLinkedList_Version2<T> {

    public Node<T> head = null;

    public class Node<T> {
        public T data;
        public Node next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T item) {
        if (this.head == null) {
            this.head = new Node<>(item);
        } else {
            Node node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(item);
        }
    }

    public void addNodeInside(T data, T isData) {
        Node<T> searchedNode = this.search(isData);

        if (searchedNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);
            searchedNode.next.next = nextNode;
        }
    }

    private Node<T> search(T data) {

        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList_Version2<Integer> singleLinkedList = new SingleLinkedList_Version2<>();
        singleLinkedList.addNode(1);
        singleLinkedList.addNode(2);
        singleLinkedList.addNode(3);

        singleLinkedList.addNodeInside(5, 2);
        singleLinkedList.addNodeInside(6, 8);
        singleLinkedList.printAll();
    }
}
