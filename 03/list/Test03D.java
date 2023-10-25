class Test03D {
    public static void main(String[] args) {
        MyList list = new MyList(); // リストオブジェクトを生成、初期化
        for (int i = 1; i <= 10; i++) {
            list.add(i * 100); // リスト末尾に 100, 200, …, 1000 の順に追加
        }
        MyList list2 = new MyList();
        for (int i = 1; i <= 10; i++) {
            list2.add(i * 111); // リスト末尾に 111, 222, …, 1110 の順に追加
        }
        list.concat(list2);
        list.print(); // リストの内容を出力 100 … 1000 111 … 1110 と出力されるはず

        // Additional test
        MyList list3 = list2;
        list2.concat(list3);
        list.print();
    }
}
