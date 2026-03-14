// mainメソッドを含むAccountTesterクラスを書く
class AccountTester {
    public static void main(String[] args) {       
        Day da = new Day(2022, 4, 1);
        Day dn = new Day(2023, 7, 1);
        Account adachi = new Account("足立幸一", "123456", 1000, da);
        Account nakata = new Account("仲田真二", "654321", 200, dn);     
        adachi.withdraw(200);
        nakata.deposit(100);
        System.out.println("■足立君の口座");
        System.out.println("口座名義："+adachi.getNa());
        System.out.println("口座番号："+adachi.getNo());
        System.out.println("預金残高："+adachi.getZ());
        System.out.println(adachi.getday());
        System.out.println("■仲田君の口座");
        System.out.println("口座名義："+nakata.getNa());
        System.out.println("口座番号："+nakata.getNo());
        System.out.println("預金残高："+nakata.getZ());
        System.out.println(nakata.getday());
    }
}