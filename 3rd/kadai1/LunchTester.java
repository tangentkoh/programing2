// mainメソッドを含むLunchTesterクラスを書く
class LunchTester {
    public static void main(String[] args) {
        LunchA a = new LunchA("チキンカレー",450);
        LunchA bAsA = new LunchB("お子様カレー",300,"エビフライ",200);
        LunchA cAsA = new LunchC("激辛カレー",500,"はちみつ", 100,"野菜サラダ", 180);
        LunchA x = new LunchA("レガシーカレー", 350);
        a.print();
        System.out.println("");
        bAsA.print();
        System.out.println("");
        cAsA.print();
        System.out.println("");
        x.print();
    }
}