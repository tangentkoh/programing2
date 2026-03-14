// 以下に必要な記述を追加せよ
import java.util.*;
// クラス宣言は Dijkstra クラスを継承するよう変更する
public class PQDijkstra extends Dijkstra{

    // doDijkstra メソッドをオーバーライド（適宜変更すること）
    @Override public int [] doDijkstra(int start) {
        int n = nodes.size();
        double[] distances = new double[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distances, Double.MAX_VALUE); // 初期化
        Arrays.fill(parent, -1);
        distances[start] = 0;
        PriorityQueue<KeyValue> pq = new PriorityQueue<>(Comparator.comparingDouble(nd -> nd.value));
        pq.add(new KeyValue(start, 0.0)); // 定義
        while (!pq.isEmpty()) {
            KeyValue current = pq.poll();
            int u = current.id;
            if (visited[u]) {continue;}
            visited[u] = true;
            for (Edge edge : nodes.get(u).getList()) {
                int v = edge.To();
                double weight = edge.Weight();
                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    parent[v] = u;
                    pq.add(new KeyValue(v, distances[v]));
                }
            }
        }
        return parent;
    }
    private static class KeyValue {
        int id;
        double value;
        KeyValue(int id, double value) {
            this.id = id;
            this.value = value;
        }
    }
}
