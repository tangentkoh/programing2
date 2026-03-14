// 以下に必要な記述を追加せよ
import java.util.*;
import java.io.*;
class Edge{
    private int to;
    Edge(int to){this.to = to;}
    int To(){return to;}
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
        String[] sp2 = sp1[1].split(",");
        for (String s : sp2) {
            if (!s.isEmpty()) {
                int toId = Integer.parseInt(s.trim());
                addToList(toId);
            }
        }
    }
    void addToList(int nid){
        list.add(new Edge(nid));
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