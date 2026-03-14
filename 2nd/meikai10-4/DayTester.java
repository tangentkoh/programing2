// mainメソッドを含むDayTesterクラスを書く
import java.util.Scanner;
class DayTester{
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Day s = new Day(); // 初期値の確認
        System.out.println("初期値は"+s.getYear()+"年"+s.getMonth()+"月"+s.getDate()+"日です。");
        int y,m,d;
        System.out.println("日付を入力"); // 選ばせる
        System.out.print("年："); y = stdIn.nextInt();
        System.out.print("月："); m = stdIn.nextInt();
        System.out.print("日："); d = stdIn.nextInt();
        Day a = new Day(y,m,d); 
        System.out.println(a.getYear()+"年"+a.getMonth()+"月"+a.getDate()+"日は、");
        System.out.println("閏年"+(a.isLeap()?"ですよー。":"じゃねえ。"));
        System.out.println("次の日は" + a.Next());
        System.out.println("前の日は" + a.Prev());
    }
}