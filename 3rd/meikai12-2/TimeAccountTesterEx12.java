// mainメソッドを含むTimeAccountTesterEx12クラスを書く
class TimeAccountTesterEx12 {
    public static void main(String[] args){
        TimeAccount adachiX = new TimeAccount("足立郁哉", "123456", 1000, 500);
        TimeAccount nakataX = new TimeAccount("中田嶮山", "654321", 500, 1000);
        Account tanakaX = new Account("田中有理", "763763", 2000); // デバッグ田中
        System.out.println("各人の預金残高は");
        adachiX.printBalance();
        nakataX.printBalance();
        tanakaX.printBalance();
        System.out.println("足立vs中田：" + TimeAccount.compBalance(adachiX, nakataX));
        System.out.println("足立vs田中：" + TimeAccount.compBalance(adachiX, tanakaX));
        System.out.println("田中vs中田：" + TimeAccount.compBalance(tanakaX, nakataX));
    }
}