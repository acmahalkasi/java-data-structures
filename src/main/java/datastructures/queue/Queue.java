package datastructures.queue;

public class Queue {

    int rear = -1;
    int front = -1;
    int array[];
    int size;

    public Queue(int size) {
        this.size = size;
        this.array = new int[size];
    }

    void enqueue(int num) {
        if (isFull()) {
            System.err.printf("Queue is full. %d is discarding..\n", num);
            return;
        }

        if (isEmpty()) {
            this.rear = 0;
        }

        array[++this.front] = num;
    }

    int dequeue() {
        if (isEmpty()) {
            System.err.println("Queue is already empty.");
            return -1;
        }

        int value = this.array[this.rear];
        this.rear++;

        if (this.rear > this.front) {
            this.rear = -1;
            this.front = -1;
        }
        return value;
    }

    public boolean isFull() {
        return front == size - 1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public int peek() {
        return this.array[front];
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            for (int i = this.front; i >= 0; i--) {
                System.out.printf("| %d |\n", this.array[i]);
            }
        }
    }
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.isEmpty();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6); //in case of error
        queue.print();
        System.out.flush();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); //in case of error
        queue.print();
    }

}
