// mainメソッドを含むLoadPrintTesterクラスを書く
// WUGraphクラスのloadGraphメソッドとprintGraphメソッドをテストする
// 課題1でmainメソッドを実行するクラス
// 前回作成したものと同様の検証をする
public class LoadPrintTester{
    public static void main(String [] args){
        if (args.length != 1) {
            System.out.println("正しく入力すること");
            System.exit(0);
        }
        String filename = args[0];
        WUGraph wugraph = new WUGraph();
        wugraph.loadGraph(filename);
        wugraph.printGraph();
    }
}