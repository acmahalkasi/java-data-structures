package datastructures.list;

public class CircularLinkedList {

    static class Node {
        Integer data;
        Node nextNode;
        Node prevNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
            this.prevNode = null;
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

    public CircularLinkedList() {
    }

    public CircularLinkedList(Node head) {
        this.head = head;
    }

    private void add(int data) {
        Node node = new Node(data);
        if (size == 0) {
            this.head = node;
            node.nextNode = node;
            node.prevNode = node;
        } else {
            Node currNode = head.prevNode;
            currNode.nextNode = node;
            node.prevNode = currNode;
            node.nextNode = head;
            head.prevNode = node;
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
        // 1 2 x 3
        Node node = new Node(data);
        Node prevNode = get(index - 1);

        node.prevNode = prevNode;
        node.nextNode = prevNode.nextNode;
        prevNode.nextNode = node;

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
        Node prevNode = currNode.prevNode;

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
        if (size == 0)
            return false;

        Node currNode = get(index);
        if (currNode == null)
            return false;

        Node prevNode = currNode.prevNode;
        // 1 2 3
        if (prevNode == currNode) {
            this.head = null;
        } else {
            prevNode.nextNode = currNode.nextNode;
            currNode.nextNode.prevNode = prevNode;
            currNode = null;
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
            node.prevNode = null;
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

    //todo search

    public static void main(String[] args) {
        var circularLinkedList = new CircularLinkedList();
        circularLinkedList.add(1);
        circularLinkedList.add(2);
        circularLinkedList.add(2, 100);
        circularLinkedList.add(3);
        //System.out.println(singlyLinkedList.hasNext(2));
        circularLinkedList.add(4);
        circularLinkedList.search(100);
        circularLinkedList.search(200);
        //System.out.println(singlyLinkedList.hasNext(4));
        //singlyLinkedList.print();
        //singlyLinkedList.clear();
        //System.out.println(singlyLinkedList.hasNext(1));
        //singlyLinkedList.print();
        circularLinkedList.set(0, 1000); // 1000 2 3 4
        circularLinkedList.delete(2);
        circularLinkedList.delete(circularLinkedList.size-1);
        circularLinkedList.print();
    }


}
