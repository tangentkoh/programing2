// 定期預金付き銀行口座クラス【第1版】TimeAccountを書く
public class TimeAccount extends Account {
    private long timeBalance;
    TimeAccount(String n, String num, long z, long t) {
        super(n, num, z);
        timeBalance = t;
    }
    long getTimeBalance() { return timeBalance; }
    void cancel() {timeBalance = 0;}
    @Override void printBalance() {
        super.printBalance();
        System.out.println("定期預金残高：" + timeBalance + "円");
    }
    static int compBalance(Account a, Account b) {
        long tA = a.getBalance();
        long tB = b.getBalance();
        if (a instanceof TimeAccount) // 仕分け
            tA += ((TimeAccount)a).getTimeBalance();
        if (b instanceof TimeAccount)
            tB += ((TimeAccount)b).getTimeBalance();
        if (tA > tB)
            return 1;
        else if (tA < tB)
            return -1;
        else
            return 0;
    }
}
