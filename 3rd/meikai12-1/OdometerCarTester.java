// mainメソッドを含むOdometerCarTesterクラスを書く
// OdometerCarTesterクラス
class OdometerCarTester {
    public static void main(String[] args) {
        Day a = new Day(2020, 1, 3);
        OdometerCar A = new OdometerCar("ace", 1500, 1500, 3000, 50, a, 0);
        System.out.println("車の情報");
        A.putSpec();
        System.out.println("車を移動させます");
        double dx2 = 4.0;
        double dy2 = 3.0;
        System.out.println("走らせる距離(dx)：" + dx2);
        System.out.println("走らせる距離(dy)：" + dy2);
        if (A.move(dx2, dy2)) {
            System.out.println("移動できました");
        } else {
            System.out.println("燃料不足ですよ");
        }
        A.printOdometer();
        System.out.printf("残り燃料：%.2fL\n", A.getFuel());
    }
}
