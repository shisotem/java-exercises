class Queue {
    int a[];
    int head, tail;
    Queue() {
        a = new int[100];
        head = 0;
        tail = 0;
    }
    void enqueue(int x) {
        tail++;
        a[tail] = x;
    }
    int dequeue() {
        head++;
        int item = a[head];
        a[head] = 0;
        return item;
    }
    boolean isEmpty() {
        if (head == tail) {
            return true;
        } else {
            return false;
        }
    }
}