// 以下に必要な記述を追加せよ
import java.util.Scanner;
public class meikai15_3{
    public static void main(String[] args){
	    Scanner stdIn = new Scanner(System.in);
	    System.out.print("文字列s1:");
        String s1 = stdIn.nextLine();
        System.out.print("文字列s2:");
        String s2 = stdIn.nextLine();
        int index = s1.indexOf(s2);
        if(index == -1){System.out.println("s1中にs2が無い");}
        else{
            System.out.println("s1:"+s1);
            System.out.print("s2:");
            for(int i=0; i<index; i++){System.out.print(" ");}
            System.out.println(s2);
        }
        stdIn.close();
    }
}
