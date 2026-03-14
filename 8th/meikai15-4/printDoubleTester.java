// 以下に必要な記述を追加せよ
import java.util.Scanner;
public class printDoubleTester{
    public static void printDouble(double x, int p, int w){
        String format = String.format("%%%d.%df",w,p);
        System.out.println(String.format(format, x));
    }
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
	    System.out.print("浮動小数点数値:");
        double x1 = stdIn.nextDouble();
        System.out.print("小数点以下の部分:");
        int p1 = stdIn.nextInt();
        System.out.print("全体を少なくとも:");
        int w1 = stdIn.nextInt();
        printDouble(x1,p1,w1);
        stdIn.close();
    }
}
