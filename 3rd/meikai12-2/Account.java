// 銀行口座クラス【第2版】Accountを書く
public class Account {
    private String name;
    private String no;
    private long balance;
    Account(String n, String num, long z) {
        name = n;
        no = num;
        balance = z;
    }
    String getName() {return name;}
    String getNo() {return no;}
    long getBalance() {return balance;}
    void deposit(long k) {balance += k;}
    void withdraw(long k) {balance -= k;}
    void printBalance() {
        System.out.println("・" + name);
        System.out.println("口座番号：" + no);
        System.out.println("普通預金残高：" + balance + "円");
    }
}