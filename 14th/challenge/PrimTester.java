// PrimTester.java
// mainメソッドを含むPrimTesterクラスを書く
// プリムのMSTアルゴリズムをテストする
public class PrimTester{
    public static void main(String [] args){
        if (args.length != 1){
            System.out.println("正しく入力すること");
            System.exit(0);
        }
        String filename = args[0];
        WUGraph2 wugraph3 = new WUGraph2();
        wugraph3.loadGraph(filename);
        WUGraph2 m = wugraph3.getMSTPrim();
        m.printGraph();
    }
}