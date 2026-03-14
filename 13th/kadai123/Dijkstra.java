// 以下に必要な記述を追加せよ
import java.util.*;
// クラス宣言はGraphクラスを継承するよう変更する
public class Dijkstra extends Graph{
    public int [] doDijkstra(int start) {
        int n = nodes.size();
        int[] parent = new int[n];
        double[] distances = new double[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(parent, -1);
        Arrays.fill(distances, Double.MAX_VALUE);
        distances[start] = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            double minDistance = Double.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    minDistance = distances[j];
                    u = j;
                }
            }
            if (u == -1) {break;}
            visited[u] = true;
            for (Edge edge : nodes.get(u).getList()) {
                int v = edge.To();
                double weight = edge.Weight();
                if (!visited[v] && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    parent[v] = u;
                }
            }
        }
        return parent;
    }

    public int [] getShortestPath(int start, int end) {
        int[] parent = doDijkstra(start);
        ArrayList<Integer> path = new ArrayList<>();
        if (parent[end] == -1 && start != end) { 
            return new int[0];
        }
        int current = end;
        while (current != -1 && current != start) {
            path.add(current);
            current = parent[current];
        }
        if (current == start) {
            path.add(start);
        } else if (start != end) { 
             return new int[0];
        }
        Collections.reverse(path); 
        int[] result = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            result[i] = path.get(i);
        }
        return result;
    }
}