class MyList {
    ListNode head = null;

    void add(int x) {
        ListNode node = new ListNode(x);
        if (head == null) {
            head = node;
        } else {
            ListNode p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
    }

    void print() {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.key + " ");
            p = p.next;
        }
        System.out.println();
    }

    int indexOf(int x) {
        ListNode p = head;
        int i = 0;
        while (p != null) {
            if (p.key == x) {
                return i;
            }
            p = p.next;
            i++;
        }
        return -1;
    }

    int get(int x) {
        ListNode p = head;
        int i = 0;
        while (p != null) {
            if (i == x) {  // 今見ているidx == 所望のidx
                return p.key;
            }
            p = p.next;
            i++;
        }
        throw new IndexOutOfBoundsException();
    }

    void concat(MyList list) {
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = list.head;
    }
}
