//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package task_2;

public class CircularQueue {
    int size = 5;
    int front;
    int rear;
    Customer[] items;

    public CircularQueue() {
        this.items = new Customer[this.size];
        this.front = -1;
        this.rear = -1;
    }

    Customer getIndex(int index) {
        return this.items[index];
    }

    boolean isFull() {
        if (this.front == 0 && this.rear == this.size - 1) {
            return true;
        } else {
            return this.front == this.rear + 1;
        }
    }

    boolean isEmpty() {
        return this.front == -1;
    }

    void enQueue(Customer customer) {
        if (this.isFull()) {
            System.out.println("Queue is full");
        } else {
            if (this.front == -1) {
                this.front = 0;
            }

            this.rear = (this.rear + 1) % this.size;
            this.items[this.rear] = customer;
        }

    }

    Object deQueue() {
        if (this.isFull()) {
            System.out.println("Queue is full");
        }

        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            Customer customer = this.items[this.front];
            if (this.front == this.rear) {
                this.front = -1;
                this.rear = -1;
            } else {
                this.front = (this.front + 1) % this.size;
            }

            return customer;
        }
    }

    void display() {
        if (this.isEmpty()) {
            System.out.println("Waiting List is Empty ");
        } else {
            System.out.println("Front -> " + this.front);
            System.out.println("Items -> ");

            int i;
            for(i = this.front; i != this.rear; i = (i + 1) % this.size) {
                Customer var10001 = this.items[i];
                System.out.print("" + var10001 + " ");
            }

            System.out.println(this.items[i]);
            System.out.println("Rear -> " + this.rear);
        }

    }
}
