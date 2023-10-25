class BankAccount extends Chokin {
    String bank = "TokyoBank";
    BankAccount(String bank) {
        this.bank = bank;
    }
    void print() {
        System.out.println(bank + ": " + okane + "yen");
    }
}
