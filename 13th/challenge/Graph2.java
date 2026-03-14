// Graph2.java(Graphを再利用)
import java.util.*;
import java.io.*;
class Edge2{
    private int to;
    private double weight;
    Edge2(int to, double weight){
        this.to = to;
        this.weight = weight;
    }
    int To(){return to;}
    double Weight(){return weight;}
}
class Node2{
    int id;
    ArrayList<Edge2> list;
    Node2(int id){
        this.id = id;
        list = new ArrayList<Edge2>();
    }
    Node2(int id, String line){
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
        list.add(new Edge2(nid, nweight));
    }
    ArrayList<Edge2> getList(){
        return list;
    }
}
public class Graph2{
    ArrayList<Node2> nodes;
    public void printGraph(){
        for (Node2 node : nodes){
            System.out.print(node.id + ":");
            ArrayList<Edge2> list = node.getList();
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
        try{
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            nodes = new ArrayList<Node2>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] sp1 = line.split(":");
                int id = Integer.parseInt(sp1[0].trim());
                Node2 node = new Node2(id, line);
                nodes.add(node);
            }
            scanner.close();
        } 
        catch(FileNotFoundException e){
            System.out.println("ファイルが見つからない");
        }
    }
    public Graph2(){nodes = new ArrayList<Node2>();}
    public int getNumNodes() {return nodes.size();}
    public Node2 getNode(int id) {
        for (Node2 node : nodes) {
            if (node.id == id) {return node;}
        }
        return null;
    }
}