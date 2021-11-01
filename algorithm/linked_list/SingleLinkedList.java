package algorithm.linked_list;

public class SingleLinkedList<T> {

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

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addNode(1);
        singleLinkedList.addNode(2);
        singleLinkedList.addNode(3);

        System.out.println(singleLinkedList.head.data);
        System.out.println(singleLinkedList.head.next.data);
        System.out.println(singleLinkedList.head.next.next.data);
        System.out.println(singleLinkedList.head.next.next.next);
    }
}
