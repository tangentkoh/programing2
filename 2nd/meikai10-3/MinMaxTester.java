// mainメソッドを含むMinMaxTesterクラスを書く
import java.util.Scanner;
public class MinMaxTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("二値:2、三値:3、配列:4、を入力"); // 自分で選択
        int n = stdIn.nextInt();
        double min = 0, max = 0;
        if (n==2){ // 二値
            System.out.print("小数を二つ入力：");
            double a = stdIn.nextDouble();
            double b = stdIn.nextDouble();
            min = MinMax.Min(a, b);
            max = MinMax.Max(a, b);
        } 
        else if (n==3){ // 三値
            System.out.print("小数を三つ入力：");
            double a = stdIn.nextDouble();
            double b = stdIn.nextDouble();
            double c = stdIn.nextDouble();
            min = MinMax.Min(MinMax.Min(a, b), c); // aとbの比較→cと比較
            max = MinMax.Max(MinMax.Max(a, b), c);
        } 
        else if (n==4){ // 配列
            System.out.print("配列の要素数を入力：");
            int m = stdIn.nextInt();
            double[] array = new double[m];
            System.out.println("小数を" +m+ "個入力：");
            for (int i = 0; i < m; i++) {
                array[i] = stdIn.nextDouble();
            }
            min = array[0]; // [0]で初期化
            max = array[0];
            for (int i=1; i<m; i++){ // 二つの値の判定を繰り返す
                min = MinMax.Min(min, array[i]);
                max = MinMax.Max(max, array[i]);
            }
        }
        System.out.println("最小値: "+min+"ですよー。");
        System.out.println("最大値: "+max+"ですよー。");
    }
}
