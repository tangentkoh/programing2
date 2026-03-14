// mainメソッドを含むHumanArrayInitクラスを書く
import java.util.Scanner;
class HumanArrayInit {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Human[] x = { // 初手代入
            new Human("Satou", 170, 55, 19),
            new Human("Kobayashi", 188, 80, 22),
            new Human("Ai", 165, 56, 16),
        };
        System.out.println("名前、身長、体重、年齢");
        for(int i=0; i<3; i++){
            System.out.println(
                x[i].getName() + " " +
                x[i].getHeight() + " " +
                x[i].getWeight() + " " +
                x[i].getAge()
            );
        }
        System.out.println();
        Human[] y = new Human[4];
        for(int i=0; i<4; i++){  // 同じ値を代入
            y[i] = new Human("Riku", 159, 44, 13);
        }
        for(int i=0; i<4; i++){
            System.out.println(
                y[i].getName() + " " +
                y[i].getHeight() + " " +
                y[i].getWeight() + " " +
                y[i].getAge()
            );
        }
        System.out.println();
        System.out.print("配列数：");
        int n = stdIn.nextInt();
        Human[] z = new Human[n];
        System.out.print("要素(名前)");
        String s = stdIn.next();
        System.out.print("要素(身長)");
        int a = stdIn.nextInt();
        System.out.print("要素(体重)");
        int b = stdIn.nextInt();
        System.out.print("要素(年齢)");
        int c = stdIn.nextInt();
        for(int i=0; i<n; i++){ // 自分で指定
            z[i] = new Human(s, a, b, c);
        }
        for(int i=0; i<n; i++){
            System.out.println(
                z[i].getName() + " " +
                z[i].getHeight() + " " +
                z[i].getWeight() + " " +
                z[i].getAge()
            );
        }
    }
}