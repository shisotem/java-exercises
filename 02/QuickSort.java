class QuickSort {
    public static void main(String[] args) {
        String[] a = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
                "November", "December" };
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void sort(String[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        String p = arr[(left + right) / 2];
        int l = left, r = right;
        while (l <= r) {
            while (arr[l].compareTo(p) < 0) {
                l++;
            }
            while (arr[r].compareTo(p) > 0) {
                r--;
            }
            if (l <= r) {
                String t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
                l++;
                r--;
            }
        }
        sort(arr, left, r);
        sort(arr, l, right);
    }
}