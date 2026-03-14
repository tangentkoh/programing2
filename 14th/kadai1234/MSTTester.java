// mainメソッドを含むMSTTesterクラスを書く
// WUGraphクラスのgetMSTメソッドをテストする
// 課題4でmainメソッドを実行するクラス
// 結果を指定された形式で標準出力(printlnなど)に出力する 
import java.io.*;
public class MSTTester{
    public static void main(String [] args){
        if (args.length != 2){
            System.out.println("正しく入力すること");
            System.exit(0);
        }
        String filename = args[0];
        int num = Integer.parseInt(args[1]);
        String outputFilename = "wugraph/mst"+num+".txt";
        try{ // 書き込み作業
            WUGraph wugraph2 = new WUGraph();
            wugraph2.loadGraph(filename);
            WUGraph mst = wugraph2.getMST();
            PrintStream originalOut = System.out;
            PrintStream fileOut = new PrintStream(new FileOutputStream(outputFilename));
            System.setOut(fileOut);
            mst.printGraph();
            System.setOut(originalOut);
            mst.printGraph();
        }
        catch(IOException e){
            System.exit(0);
        }
    }
}