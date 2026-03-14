// RangeAddTester クラス
import java.util.Scanner;
public class RangeAddTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("整数a："); int a = stdIn.nextInt();
        System.out.print("整数b："); int b = stdIn.nextInt();
        RangeAdd rangeAdd = new RangeAdd();
        try {
            int result = rangeAdd.add(a, b);
            System.out.println("結果は " + result + " です。");
        } catch (NotNaturalNumber e) {
            System.out.println("エラーです。" + e.getMessage());
        }
        stdIn.close();
    }
}
