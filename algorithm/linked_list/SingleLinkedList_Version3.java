package algorithm.linked_list;

public class SingleLinkedList_Version3<T> {

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

    public boolean delNode(T isData) {
        if (this.head == null) {
            return false;
        } else {
            Node<T> node = this.head;
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
        SingleLinkedList_Version3<Integer> singleLinkedList = new SingleLinkedList_Version3<>();
        singleLinkedList.addNode(1);
        singleLinkedList.addNode(2);
        singleLinkedList.addNode(3);

        singleLinkedList.addNodeInside(5, 2);
        singleLinkedList.addNodeInside(6, 8);
        singleLinkedList.printAll();

        System.out.println();
        singleLinkedList.delNode(2);
        singleLinkedList.delNode(1);
        singleLinkedList.delNode(6);
        singleLinkedList.printAll();

    }
}

