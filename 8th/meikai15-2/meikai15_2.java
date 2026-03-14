// 以下に必要な記述を追加せよ
import java.util.Scanner;
public class meikai15_2{
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
	    System.out.print("元の文字列:");
        String x = stdIn.nextLine();
        for(int i=0; i<x.length(); i++){
            char c = x.charAt(i);
            int code = (int)c;
            System.out.println(Integer.toHexString(code));
        }
        stdIn.close();
    }
}
