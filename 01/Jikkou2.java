class Jikkou2 {
    public static void main(String[] args) {
        Saifu mySaifu = new Saifu();
        int tmpOkane = 0;

        int income = 10;
        for (int i = 1; i <= 25; i++) {
            tmpOkane = mySaifu.getOkane();
            tmpOkane += income;
            mySaifu.setOkane(tmpOkane);
            System.out.println("day=" + i + "  " + "okane=" + mySaifu.getOkane());
            income *= 2;
        }
    }
}