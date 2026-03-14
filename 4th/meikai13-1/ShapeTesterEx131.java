// mainメソッドを含むShapeTesterEx131クラスを書く
import java.util.Scanner;
class ShapeTesterEx131{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("図形は何個ですか:");
        int n = scan.nextInt();
        Shape1[] p = new Shape1[n];
        for(int i=1; i<=n; i++){
            System.out.println(i+"番の図形の種類を選んで下さい");
            System.out.print("(1-点/2-水平直線/3-垂直直線/4-長方形):");
            int x = scan.nextInt();
            if(x==1){
                p[i-1]=new Point1();
            }
            if(x==2){
                System.out.print("長さ:");
                int a2 = scan.nextInt();
                p[i-1]=new HorzLine1(a2);
            }
            if(x==3){
                System.out.print("長さ:");
                int a3 = scan.nextInt();
                p[i-1]=new VertLine1(a3);
            }
            if(x==4){
                System.out.print("幅:");
                int a4 = scan.nextInt();
                System.out.print("高さ:");
                int b4 = scan.nextInt();
                p[i-1]=new Rectangle1(a4,b4);
            }
        }
        System.out.println();
        for(Shape1 s:p){
            s.print();
            System.out.println();
        }
    }
}