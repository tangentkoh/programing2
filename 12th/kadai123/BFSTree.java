// 以下に必要な記述を追加せよ
import java.util.*;
// クラス宣言は変更してもよい
public class BFSTree extends Graph{
    public int[] getBFSTree(int root){ // 形成
        int n = nodes.size();
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Queue<Integer> que = new LinkedList<>();
        que.add(root);
        parent[root] = root;
        while (!que.isEmpty()){
            int cur = que.poll();
            for (Edge e : nodes.get(cur).getList()){
                int next = e.To();
                if (parent[next] == -1){
                    parent[next] = cur;
                    que.add(next);
                }
            }
        }
        return parent;
    }
    public int[] getShortestPath(int start, int end){ // 辿る
        int[] parent = getBFSTree(start);
        ArrayList<Integer> path = new ArrayList<>();
        int cur = end;
        if(parent[cur] == -1){
            return new int[0];
        }
        while(cur != start){
            path.add(cur);
            cur = parent[cur];
        }
        path.add(start);
        Collections.reverse(path);
        int[] result = new int[path.size()];
        for(int i = 0; i < path.size(); i++){
            result[i] = path.get(i);
        }
        return result;
    }
}