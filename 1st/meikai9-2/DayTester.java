// Daytesterの入力
import java.util.Scanner;
class DayTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        Day d1 = new Day(); // 初期値
        System.out.println("指定なし");
        System.out.print(d1.getYear()+"年");
        System.out.print(d1.getMonth()+"月");
        System.out.print(d1.getDate()+"日");
        System.out.println();

        System.out.print("年を入力："); // 2
        int y = stdIn.nextInt();
        Day d2 = new Day(y);
        System.out.println("年のみ");
        System.out.print(d2.getYear()+"年");
        System.out.print(d2.getMonth()+"月");
        System.out.print(d2.getDate()+"日");
        System.out.println();

        System.out.print("年を入力："); // 3
        y = stdIn.nextInt();
        System.out.print("月を入力：");
        int m = stdIn.nextInt();
        Day d3 = new Day(y, m);
        System.out.println("年月のみ");
        System.out.print(d3.getYear()+"年");
        System.out.print(d3.getMonth()+"月");
        System.out.print(d3.getDate()+"日");
        System.out.println();

        System.out.print("年を入力："); // 4
        y = stdIn.nextInt();
        System.out.print("月を入力：");
        m = stdIn.nextInt();
        System.out.print("日を入力：");
        int d = stdIn.nextInt();
        Day d4 = new Day(y, m, d);
        System.out.println("ぜんぶ");
        System.out.print(d4.getYear()+"年");
        System.out.print(d4.getMonth()+"月");
        System.out.print(d4.getDate()+"日");
        System.out.println();

        Day d5 = new Day(d4); // 5
        System.out.println("複製");
        System.out.print(d5.getYear()+"年");
        System.out.print(d5.getMonth()+"月");
        System.out.print(d5.getDate()+"日");
        System.out.println();
    }
}
