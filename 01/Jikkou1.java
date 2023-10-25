class Jikkou1 {
    public static void main(String[] args) {
        Saifu mySaifu = new Saifu();
        int tmpOkane = mySaifu.getOkane();
        mySaifu.setOkane(tmpOkane + 5000);
        System.out.println("okane=" + mySaifu.getOkane());
    }
}