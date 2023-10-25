class Stack {
    int[] a;
    int top;
    Stack() {
        a = new int[100];
        top = 0;
    }
    void push(int x) {
        a[top] = x;
        top++;
    }
    int pop() {
        top--;
        int item = a[top];
        a[top] = 0;
        return item;
    }
    boolean isEmpty() {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
