class Jikkou3 {
    public static void main(String[] args) {
        Saifu2 mySaifu = new Saifu2();
        long tmpOkane = 0;

        int max = 25;
        if (args.length == 1) {
            max = Integer.parseInt(args[0]);
        }

        long income = 10;
        for (int i = 1; i <= max; i++) {
            tmpOkane = mySaifu.getOkane();
            tmpOkane += income;
            mySaifu.setOkane(tmpOkane);
            System.out.println("day=" + i + "  " + "okane=" + mySaifu.getOkane());
            income *= 2;
        }
    }
}