// 前回の演習で作った GraphTester.java をこれへ上書きコピーして開始せよ。
// なお、入力サンプルが "sample.txt" に変わっているので注意すること
public class GraphTester{
    public static void main(String [] args){
        if (args.length != 1) {
            System.out.println("使用例:java GraphTester sample.txt");
            System.exit(0);
        }
        String filename = args[0];
        Graph graph = new Graph();
        graph.loadGraph(filename);
        System.out.println();
        graph.printGraph();
        System.out.println(); // 区切り用
    }
}