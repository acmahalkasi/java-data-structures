package datastructures.list;

public class SingleLinkedList {

    static class Node {
        Integer data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    private Node head;
    private int size;

    public SingleLinkedList() {
    }

    public SingleLinkedList(Node head) {
        this.head = head;
    }

    private void add(int data) {
        Node node = new Node(data);
        if (size == 0) {
            this.head = node;
        } else {
            Node currNode = getLast();
            currNode.nextNode = node;
        }
        this.size++;
        System.out.printf("%d is inserted at index %d\n", data, size - 1);
    }

    private void add(int index, int data) {
        if (index > size) {
            System.err.println("Out of index!");
            return;
        } else if (index == size) {
            add(data);
            return;
        }

        Node node = new Node(data);
        Node prevNode = get(index - 1);

        if (prevNode == null) {
            Node prevHead = this.head;
            this.head = node;
            this.head.nextNode = prevHead;
        } else {
            Node currNode = get(index);
            prevNode.nextNode = node;
            node.nextNode = currNode;
        }

        this.size++;
        System.out.printf("%d is inserted at index %d\n", data, index);

    }

    boolean set(int index, int data) {
        Node currNode = get(index);
        if (currNode == null) {
            return false;
        }
        currNode.data = data;
        return true;
    }

    void set(int index, Node node) {
        Node currNode = get(index);
        Node prevNode = get(index - 1);

        prevNode.nextNode = node;
        currNode.data = node.data;
    }

    Node getLast() {
        return get(size - 1);
    }

    Node getHead() {
        return get(0);
    }

    Node get(int index) {
        if (index >= size || index < 0) {
            System.err.println("Out of index!");
            return null;
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        }

        return node;
    }

    Node peek() {
        return getLast();
    }

    boolean hasNext(int index) {
        if (index >= size || index < 0) {
            System.err.println("Out of index!");
            return false;
        }
        return get(index).nextNode != null;
    }

    boolean hasNext(Node node) {
        return node.nextNode != null;
    }

    boolean delete(int index) {
        Node currNode = get(index);
        if (currNode == null)
            return false;

        Node prevNode = get(index - 1);
        if (prevNode == null) {
            this.head.data = null;
            this.head = this.head.nextNode;
            return true;
        } else {
            prevNode.nextNode = currNode.nextNode;
            currNode.data = null;
            currNode.nextNode = null;
        }
        System.out.printf("Index %d is freed\n", index);
        this.size--;
        return true;
    }

    int search(int data) {
        if (size == 0) {
            System.out.println("List is empty!");
            return -1;
        }
        Node node = this.head;
        for (int i = 0; i < size - 1; i++) {
            if (node.data == data) {
                System.out.printf("%d is found at index %d\n", data, i);
                return i;
            }
            node = node.nextNode;
        }
        return -1;
    }

    void clear() {
        Node node = this.head;
        for (int i = 0; i < size - 1; i++) {
            Node temp = node.nextNode;
            node.data = null;
            node.nextNode = null;
            node = temp;
        }
        this.size = 0;
        System.out.println("List is emptied!");
    }

    void print() {
        if (size == 0) {
            System.out.println("List is empty!");
            return;
        }
        Node node = this.head;
        System.out.println(node);
        for (int i = 0; i < size - 1; i++) {
            node = node.nextNode;
            System.out.println(node);
        }
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(2, 100);
        singleLinkedList.add(3);
        //System.out.println(singlyLinkedList.hasNext(2));
        singleLinkedList.add(4);
        singleLinkedList.search(100);
        singleLinkedList.search(200);
        //System.out.println(singlyLinkedList.hasNext(4));
        //singlyLinkedList.print();
        //singlyLinkedList.clear();
        //System.out.println(singlyLinkedList.hasNext(1));
        //singlyLinkedList.print();
        singleLinkedList.set(0, 1000);
        singleLinkedList.delete(2);
        singleLinkedList.print();
    }


}
