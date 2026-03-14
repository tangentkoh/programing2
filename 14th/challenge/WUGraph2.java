// WUGraph2.java
// Edge2, (Node,) WUGraph2クラスを書く
import java.util.*;
import java.io.*;
class Edge2 implements Comparable<Edge2>{ // 定義
    private int id;
    private int nodeU, nodeV;
    private int cost;
    Edge2(int id, int nodeU, int nodeV, int cost){
        this.id = id;
        this.nodeU = nodeU;
        this.nodeV = nodeV;
        this.cost = cost;
    }
    int getId(){return id;}
    int getNodeU(){return nodeU;}
    int getNodeV(){return nodeV;}
    int getCost(){return cost;}
    @Override public int compareTo(Edge2 e){
        return Integer.compare(this.cost , e.cost);
    }
}
public class WUGraph2{ // 可変長リストを使う
    private int numOfNodes;
    private int numOfEdges;
    private ArrayList<Edge2> edges;
    private ArrayList<ArrayList<Edge2>> adjList; 
    public void loadGraph(String filename){ // グラフを詠み込み
        try{
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            String line0 = scanner.nextLine();
            String[] sp0 = line0.split(",");
            numOfNodes = Integer.parseInt(sp0[0].trim());
            numOfEdges = Integer.parseInt(sp0[1].trim());
            this.adjList = new ArrayList<>(numOfNodes);
            for (int i=0; i<numOfNodes; i++) {
                adjList.add(new ArrayList<>());
            }
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] sp1 = line.split(":");
                int id = Integer.parseInt(sp1[0].trim());
                String[] sp2 = sp1[1].split(",");
                int nodeU = Integer.parseInt(sp2[0].trim());
                int nodeV = Integer.parseInt(sp2[1].trim());
                int cost = Integer.parseInt(sp2[2].trim());
                Edge2 edge = new Edge2(id, nodeU, nodeV, cost);
                edges.add(edge);
            }
            scanner.close();
        } 
        catch(FileNotFoundException e){
            System.out.println("ファイルが見つからない");
        }
    }
    public WUGraph2(){ // 初期のグラフ
        edges = new ArrayList<Edge2>();
    }
    public WUGraph2(int numOfNodes) { // 拡張的なグラフ
        this.edges = new ArrayList<>();
        this.numOfNodes = numOfNodes;
        this.numOfEdges = 0;
        this.adjList = new ArrayList<>(numOfNodes);
        for (int i=0; i<numOfNodes; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    public ArrayList<Edge2> getSortedEdges(){ // ソートする
        ArrayList<Edge2> al = new ArrayList<>(edges);
        Collections.sort(al);
        return al;
    }
    public void addEdge(Edge2 e) { // エッジカウント
        this.edges.add(e);
        this.numOfEdges++;
        adjList.get(e.getNodeU()).add(e);
        adjList.get(e.getNodeV()).add(e);
    }
    public int getTotalCost() { // コストカウント
        int totalCost = 0;
        for (Edge2 edge : edges) {
            totalCost += edge.getCost();
        }
        return totalCost;
    }
    WUGraph2 getMST(){ // 最小木の取得
        WUGraph2 mst = new WUGraph2(this.numOfNodes);
        ArrayList<Edge2> sortedEdges = getSortedEdges();
        UnionFind2 uf = new UnionFind2(this.numOfNodes);
        for (Edge2 e : sortedEdges) {
            if (uf.unite2(e.getNodeU(), e.getNodeV())){
                mst.addEdge(e);
            }
        }
        return mst;
    }
    public WUGraph2 getMSTPrim() {
        WUGraph2 mst = new WUGraph2(this.numOfNodes);
        boolean[] inMST = new boolean[numOfNodes];
        PriorityQueue<Edge2> pq = new PriorityQueue<>(); 
        int startNode = 0; 
        inMST[startNode] = true;
        for (Edge2 edge:adjList.get(startNode)){pq.add(edge);}
        while (!pq.isEmpty() && mst.numOfEdges < numOfNodes - 1){
            Edge2 minEdge = pq.poll();
            int u = minEdge.getNodeU();
            int v = minEdge.getNodeV();
            if (inMST[u] && !inMST[v]) {
                mst.addEdge(minEdge);
                inMST[v] = true;
                for (Edge2 edge : adjList.get(v)) {
int otherNode = (edge.getNodeU() == v) ? edge.getNodeV() : edge.getNodeU();
                    if (!inMST[otherNode]) {
                        pq.add(edge);
                    }
                }
            }
            else if (inMST[v] && !inMST[u]) { 
                mst.addEdge(minEdge);
                inMST[u] = true;
                for (Edge2 edge : adjList.get(u)) {
int otherNode = (edge.getNodeU() == u) ? edge.getNodeV() : edge.getNodeU();
                    if (!inMST[otherNode]) {
                        pq.add(edge);
                    }
                }
            }
        }
        return mst;
    }
	public void printGraph(){ // WUGraphを表示
        System.out.println(getTotalCost());
        System.out.println(numOfNodes + "," +numOfEdges);
        for (Edge2 edge : edges){
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