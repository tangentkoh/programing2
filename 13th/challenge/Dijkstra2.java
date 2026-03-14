// Dijkstra2.java(Dijkstraを再利用)
import java.util.*;
public class Dijkstra2 extends Graph2 {
    private PathInfo[] dist;
    private int start;
    private int end;
    public Dijkstra2(String filename) {
        super();
        loadGraph(filename);
    }
    public void findShortestPaths(int start) {
        this.start = start;
        dist = new PathInfo[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            dist[i] = new PathInfo();
        }
        boolean[] visited = new boolean[nodes.size()];
        dist[start].dis = 0;
        ArrayList<Integer> iPath = new ArrayList<>();
        iPath.add(start);
        dist[start].paths.add(iPath);
        for (int i = 0; i < nodes.size(); i++) {
            int u = -1;
            double minDis = Double.POSITIVE_INFINITY;
            for (int v = 0; v < nodes.size(); v++) {
                if (!visited[v] && dist[v].dis < minDis) {
                    minDis = dist[v].dis;
                    u = v;
                }
            }
            if (u == -1) {break;}
            visited[u] = true; Node2 uNode = getNode(u);
            if (uNode == null){continue;}
            for (Edge2 edge : uNode.getList()){
                int v = edge.To();
                double weight = edge.Weight();
                if (dist[u].dis + weight < dist[v].dis) {
                    dist[v].dis = dist[u].dis + weight;
                    dist[v].paths.clear();
                    for (ArrayList<Integer> prevPath : dist[u].paths) {
                        ArrayList<Integer> newPath = new ArrayList<>(prevPath);
                        newPath.add(v);
                        dist[v].paths.add(newPath);
                    }
                } 
                else if (dist[u].dis + weight == dist[v].dis) {
                    for (ArrayList<Integer> prevPath : dist[u].paths) {
                        ArrayList<Integer> newPath = new ArrayList<>(prevPath);
                        newPath.add(v);
                        dist[v].paths.add(newPath);
                    }
                }
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getAllShortestPaths(int end) {
        return dist[end].paths;
    }
    public double getShortestdis(int end) {
        return dist[end].dis;
    }
}
class PathInfo { // パス記憶
    double dis;
    ArrayList<ArrayList<Integer>> paths;
    PathInfo() {
        this.dis = Double.POSITIVE_INFINITY;
        this.paths = new ArrayList<>();
    }
}