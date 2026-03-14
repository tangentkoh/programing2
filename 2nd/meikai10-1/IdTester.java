// 連番クラスIdを書く
// mainメソッドを含むIdTesterクラスを書く
class Id {
    static int counter = 0;
    private int id;
    public Id() {id = ++counter;}
    public int getId() {return id;}
    public static int getMaxId() {return counter;} // 最終的な値は最後のID
}

public class IdTester {
    public static void main(String[] args){
        Id a = new Id();
        Id b = new Id();
        System.out.println("aの識別番号："+a.getId());
        System.out.println("bの識別番号："+b.getId());
        System.out.println("Id.counter = "+Id.counter);
        System.out.println("a.counter = "+a.counter);
        System.out.println("a.counter = "+b.counter);
        System.out.println("最後の識別番号："+Id.getMaxId());
    }
}