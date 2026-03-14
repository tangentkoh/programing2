// Graph をテストする
// 課題1
public class GraphTester{
    public static void main(String [] args){
        if (args.length != 1) {
            System.out.println("使用例:java GraphTester ファイル名");
            System.exit(0);
        }
        String filename = args[0];
        Graph graph = new Graph();
        graph.loadGraph(filename);
        graph.printGraph();
    }
}