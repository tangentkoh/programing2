// 以下に必要な記述を追加せよ hori kousuke
import java.util.Scanner;
public class meikai15_1{
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("元の文字列:");
        String x = stdIn.nextLine();
        for(int i=x.length()-1; i>=0; i--){
            System.out.print(x.charAt(i));
        }
        stdIn.close();
    }
}
