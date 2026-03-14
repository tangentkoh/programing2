// 連番クラスExIdを書く
// mainメソッドを含むExIdTesterクラスを書く
import java.util.Scanner;
class ExId {
    static int counter = 0;
    private static int n = 1;
    private int exid;
    public ExId() {counter+=n; exid = counter;}
    public int ExgetId() {return exid;}
    public static int getMaxExId() {return counter;}
    public static void setN(int nx) {n = nx;}
}
public class ExIdTester {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("インスタンス数：");
        int m = stdIn.nextInt();
        System.out.println("なお、nの初期値は1です。");
        for(int i=1; i<=m; i++){
            ExId x = new ExId();
            System.out.println(i+"つ目の識別番号："+x.ExgetId());
            if(i==m){break;}
            System.out.print("nの値(維持したいなら同値を入力)："); // 毎回尋ねる(1入力で現状維持)
            int n2 = stdIn.nextInt();
            if(n2<1){n2=1;}
            ExId.setN(n2);
        }
        System.out.println("Id.counter = "+ExId.counter);
        System.out.println("最後の識別番号："+ExId.getMaxExId());
    }
}