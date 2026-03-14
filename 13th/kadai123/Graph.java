// 前回の演習で作成した Graph.java をこれへ上書きコピーし、
// 課題1で指定された拡張を施せ。
//
// （なお、前回のGraphクラスを継承した新たなクラスとして作成しても構わない）
//
import java.util.*;
import java.io.*;
class Edge{
    private int to;
    private double weight;
    Edge(int to, double weight){
        this.to = to;
        this.weight = weight;
    }
    int To(){return to;}
    double Weight(){return weight;}
}
class Node{
    int id;
    ArrayList<Edge> list;
    Node(int id){
        this.id = id;
        list = new ArrayList<Edge>();
    }
    Node(int id, String line){
        this(id);
        String[] sp1 = line.split(":");
        if (sp1.length > 1) {
            String[] sp2 = sp1[1].split(",");
            for (String s : sp2) {
                if (!s.trim().isEmpty()){
                    String[] sp3 = s.split("@"); 
                    if (sp3.length == 2) {
                        int toId = Integer.parseInt(sp3[0].trim());
                        double toWeight = Double.parseDouble(sp3[1].trim());
                        addToList(toId, toWeight);
                    }
                }
            }
        }
    }
    void addToList(int nid, double nweight){
        list.add(new Edge(nid, nweight));
    }
    ArrayList<Edge> getList(){
	    return list;
    }
}
public class Graph{
    // 可変長リストであれば
    ArrayList<Node> nodes;
    public void printGraph(){
	// Graph を表示
        for (Node node : nodes){
            System.out.print(node.id + ":");
            ArrayList<Edge> list = node.getList();
            for (int i = 0; i < list.size(); i++){
                System.out.print(list.get(i).To());
                System.out.print("@");
                System.out.print(list.get(i).Weight());
                if (i != list.size() - 1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
    public void loadGraph(String filename){
	// グラフを詠み込み
        try{
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] sp1 = line.split(":");
                int id = Integer.parseInt(sp1[0].trim());
                Node node = new Node(id, line);
                nodes.add(node);
            }
            scanner.close();
        } 
        catch(FileNotFoundException e){
            System.out.println("ファイルが見つからない");
        }
    }
    public Graph(){
        nodes = new ArrayList<Node>();
    }
}