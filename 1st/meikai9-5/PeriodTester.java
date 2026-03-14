// mainメソッドを含むPeriodTesterクラスを書く
public class PeriodTester {
    public static void main(String[] args) {
        Day start = new Day(2025, 4, 1); // ここで指定
        Day end = new Day(2025, 5, 1);
        Period p1 = new Period(start, end);
        System.out.println(p1);
    }
}