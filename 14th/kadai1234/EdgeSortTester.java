// mainメソッドを含むEdgeSortTesterクラスを書く
// WUGraphクラスのgetSortedEdgesメソッドをテストする
// 課題2でmainメソッドを実行するクラス
// 辺の読み込みなどは課題1のプログラムを元にしてよい
import java.util.ArrayList; // 追加せざるを得ない
public class EdgeSortTester{
    public static void main(String [] args){
        if (args.length != 1) {
            System.out.println("正しく入力すること");
            System.exit(0);
        }
        String filename = args[0];
        WUGraph wugraph = new WUGraph();
        wugraph.loadGraph(filename);
        wugraph.getSortedEdges(); // 追加
        ArrayList<Edge> sortgraph = wugraph.getSortedEdges();
        for (Edge edge : sortgraph){ // 今回はソート結果のみ表示
            System.out.print(edge.getId());
            System.out.print(":");
            System.out.print(edge.getNodeU());
            System.out.print(",");
            System.out.print(edge.getNodeV());
            System.out.print(",");
            System.out.print(edge.getCost());
            System.out.println();
        }
    }
}
