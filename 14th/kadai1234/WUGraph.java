// Edge, (Node,) WUGraphクラスを書く
import java.util.*;
import java.io.*;
class Edge implements Comparable<Edge>{ // 定義
    private int id;
    private int nodeU, nodeV;
    private int cost;
    Edge(int id, int nodeU, int nodeV, int cost){
        this.id = id;
        this.nodeU = nodeU;
        this.nodeV = nodeV;
        this.cost = cost;
    }
    int getId(){return id;}
    int getNodeU(){return nodeU;}
    int getNodeV(){return nodeV;}
    int getCost(){return cost;}
    @Override public int compareTo(Edge e){
        return Integer.compare(this.cost , e.cost);
    }
}
public class WUGraph{ // 可変長リストを使う
    private int numOfNodes;
    private int numOfEdges;
    private ArrayList<Edge> edges;
    public void loadGraph(String filename){ // グラフを詠み込み
        try{
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            String line0 = scanner.nextLine();
            String[] sp0 = line0.split(",");
            numOfNodes = Integer.parseInt(sp0[0].trim());
            numOfEdges = Integer.parseInt(sp0[1].trim());
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] sp1 = line.split(":");
                int id = Integer.parseInt(sp1[0].trim());
                String[] sp2 = sp1[1].split(",");
                int nodeU = Integer.parseInt(sp2[0].trim());
                int nodeV = Integer.parseInt(sp2[1].trim());
                int cost = Integer.parseInt(sp2[2].trim());
                Edge edge = new Edge(id, nodeU, nodeV, cost);
                edges.add(edge);
            }
            scanner.close();
        } 
        catch(FileNotFoundException e){
            System.out.println("ファイルが見つからない");
        }
    }
    public WUGraph(){ // 初期のグラフ
        edges = new ArrayList<Edge>();
    }
    public WUGraph(int numOfNodes) { // 拡張的なグラフ
        this.edges = new ArrayList<>();
        this.numOfNodes = numOfNodes;
        this.numOfEdges = 0;
    }
    public ArrayList<Edge> getSortedEdges(){ // ソートする
        ArrayList<Edge> al = new ArrayList<>(edges);
        Collections.sort(al);
        return al;
    }
    public void addEdge(Edge e) { // エッジカウント
        this.edges.add(e);
        this.numOfEdges++;
    }
    public int getTotalCost() { // コストカウント
        int totalCost = 0;
        for (Edge edge : edges) {
            totalCost += edge.getCost();
        }
        return totalCost;
    }
    WUGraph getMST(){ // 最小木の取得
        WUGraph mst = new WUGraph(this.numOfNodes);
        ArrayList<Edge> sortedEdges = getSortedEdges();
        UnionFind uf = new UnionFind(this.numOfNodes);
        for (Edge e : sortedEdges) {
            if (uf.unite(e.getNodeU(), e.getNodeV())){
                mst.addEdge(e);
            }
        }
        return mst;
    }
	public void printGraph(){ // WUGraphを表示
        System.out.println(getTotalCost());
        System.out.println(numOfNodes + "," +numOfEdges);
        for (Edge edge : edges){
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