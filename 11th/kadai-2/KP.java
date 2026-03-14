// ナップザック問題を解くプログラム
import java.util.Scanner;
import java.io.*;
public class KP{
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("使用法:java KP file");
            System.out.println("例:java KP 01.txt");
            System.exit(0);
        }
        try{ // ファイル関係なのでtry利用
            File file = new File(args[0]);
            Scanner sca = new Scanner(file);
            int num = sca.nextInt();
            int capacity = sca.nextInt();
            int[] weight = new int[num];
            int[] value = new int[num]; // データ数など
            for (int i=0; i<num; i++){
                weight[i]=sca.nextInt();
                value[i]=sca.nextInt(); // 読み込み
            }
            sca.close();
            Solver s = new Solver(num, weight, value, capacity);
            int answer = s.solve(); // ここでans
            System.out.println(answer);
        } 
        catch(FileNotFoundException e){System.out.println("File Lost");}
    }
}
