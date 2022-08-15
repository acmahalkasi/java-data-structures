package datastructures.binarytree;

import java.util.TreeSet;

public class BinaryTree {

    Node root;
    static int callCount;
    public BinaryTree(Node root) {
        this.root = null;
    }

    boolean add(Node node, int data) {
        callCount++;
        if (node.data == Integer.MIN_VALUE) {
            node.data = data;
            return true;
        }
        if (data <= node.data) {
            if (node.left != null)
                add(node.left, data);
             else {
                System.out.println("  Inserted " + data + " to left of Node " + node.data);
                node.left = new Node(data);
            }
        } else if (data > node.data) {
            if (node.right != null)
                add(node.right, data);
            else {
                System.out.println("  Inserted " + data + " to right of Node " + node.data);
                node.right = new Node(data);
            }
        }

        return false;
    }


    public Node delete(Node node, int value) {
        callCount++;
        node = deleteRecursive(node, value);
        return node;
    }
    Node deleteRecursive(Node node, int data) {
        callCount++;
        if (node == null)
            return null;

        if (data == node.data) {
            if (node.left == null && node.right == null) {
                node.data = Integer.MIN_VALUE;
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            //has two child
            node.left.right = node.right;
            return node.left;

        }
        if (data < node.data) {
            node.left = deleteRecursive(node.left, data);
            return node;
        }

        node.right = deleteRecursive(node.right, data);
        return node;
    }



    Node search(Node node, int data) {
        if (node.data == data)
            return node;

        if (node.left == null && node.right == null) {
            return null;
        }

        if (node.data <= data) {
            return search(node.right, data);
        } else
            return search(node.left, data);

    }

    void travelsal(OrderType ot, Node node) {
        if (node.data == Integer.MIN_VALUE) {
            System.out.println("no element on the tree.");
            return;
        }
        switch (ot) {
            case INORDER -> {
                inorder(node);
            }
            case PREORDER -> {
                preorder(node);
            }
            case POSTORDER -> {
                postorder(node);
            }
        }
    }

    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.println(node.data + " ");
        inorder(node.right);
    }

    void postorder(Node node){
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.data);
    }
    void preorder(Node node){
        if (node == null) return;

        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);

    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(null);
        Node root = new Node(7);
        bt.add(root, 6);
        bt.add(root, 4);
        bt.add(root, 8);
        bt.add(root, 5);
        bt.add(root, 3);
        bt.add(root, 6);
        bt.add(root, 9);
        bt.add(root, 2);
        System.out.println(bt.search(root, 7));
        //System.out.println("-----------------PREORDER---------------------------");
        //bt.travelsal(OrderType.PREORDER, root);
        //System.out.println("-----------------POSTORDER---------------------------");
        //bt.travelsal(OrderType.POSTORDER, root);
        //System.out.println("-----------------INORDER---------------------------");
        //bt.travelsal(OrderType.INORDER, root);
        //System.out.println("-----------------DELETING---------------------------");
        bt.delete(root,4);
        bt.delete(root,2);
        bt.delete(root,9);
        bt.delete(root,8);
        bt.delete(root,3);
        bt.delete(root,5);
        bt.delete(root,6);
        bt.delete(root,6);
        bt.delete(root,7);
        //System.out.println("-----------------PREORDER---------------------------");
        //bt.travelsal(OrderType.PREORDER, root);
        //System.out.println("-----------------POSTORDER---------------------------");
        //bt.travelsal(OrderType.POSTORDER, root);
        //System.out.println("-----------------INORDER---------------------------");
        //bt.travelsal(OrderType.INORDER, root);
        //System.out.println("-----------------ADDING---------------------------");
        bt.add(root, 8);
        System.out.println(bt.search(root, 8));
        bt.travelsal(OrderType.INORDER, root);
        System.out.println(callCount);

    }

    enum OrderType {
        PREORDER,
        POSTORDER,
        INORDER
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
