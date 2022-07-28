package datastructures.stack;

import java.util.Random;

public class Stack {

    int top;
    int array[];
    int size;

    public Stack(int size) {
        this.size = size;
        this.array = new int[size];
        this.top = -1;
    }

    void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        this.top++;
        this.array[this.top] = element;
        System.out.printf("%d is inserted into index %d.\n", element, this.top);
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is already empty.");
            return Integer.MIN_VALUE;
        }
        int popped = this.array[this.top];
        this.array[this.top] = Integer.MIN_VALUE;
        this.top--;
        System.out.printf("%d is popped from index %d\n", popped, this.top+1);
        return popped;
    }

    int peek(){
        if (isEmpty()) {
            System.out.println("Stack is already emptied.");
            return Integer.MIN_VALUE;
        }
        return this.array[this.top];

    }

    void wipe() {
        this.top = -1;
        System.out.println("Stack is wiped.");
    }

    void print() {
        for (int i=this.top; i > -1; i--) {
            System.out.printf("| %d |\n", this.array[i]);
        }
    }

    int search(int element) {
        for (int i=this.top; i > -1 ; i--) {
            if (element == array[i]) {
                System.out.printf("%d found at index %d\n", element, i);
                return i;
            }
        }
        System.out.printf("%d could not be found in stack.\n", element);
        return -1;

    }

    boolean isFull() {
        return this.top == this.size - 1;
    }

    boolean isEmpty() {
        return this.top == -1;
    }

//    public static void main(String[] args) {
//
//        Stack stack = new Stack(10);
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.push(6);
//        stack.push(7);
//        stack.push(8);
//        stack.push(9);
//        stack.push(0);
//        stack.push(1);
//
//        stack.print();
//        stack.peek();
//        stack.search(5);
//        stack.wipe();
//        stack.print();
//        stack.pop();
//
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.push(6);
//        stack.push(7);
//        stack.push(8);
//        stack.push(9);
//        stack.push(0);
//        stack.push(1);
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.print();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.print();
//
//
//    }


    static int recursiveCounter = 0;
    //sort a stack using another stack
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        for (int i=0; i<10; i++) {
            stack.push(new Random().nextInt(10));
        }
        stack.print();
        Stack tempStack = new Stack(10);

        orderStack(stack, tempStack);
        tempStack.print();
        System.out.println(recursiveCounter + " time run to sort.");
    }

    static void orderStack(Stack stack, Stack tempStack) {
        recursiveCounter++;
        if (stack.isEmpty())
            return;

        int popped = stack.pop();
        if (tempStack.peek() == Integer.MIN_VALUE || tempStack.peek() >= popped) {
            tempStack.push(popped);
        } else {
            while(tempStack.peek() != Integer.MIN_VALUE && tempStack.peek() <= popped) {
                stack.push(tempStack.pop());
            }
            tempStack.push(popped);
        }
        orderStack(stack, tempStack);
    }


}
