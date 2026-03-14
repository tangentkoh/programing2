// 以下に必要な記述を追加せよ
import java.util.*;
// クラス宣言は変更してもよい
public class DFSTree extends BFSTree{
    public int[] getDFSTree(int root){
        int n = nodes.size();
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Stack<Integer> sta = new Stack<>();
        sta.push(root);
        parent[root] = root;
        while(!sta.isEmpty()){
            int cur = sta.pop();
            for(Edge e : nodes.get(cur).getList()){
                int next = e.To();
                if (parent[next] == -1){
                    parent[next] = cur;
                    sta.push(next);
                }
            }
        }
        return parent;
    }
    public int[] getPath(int start, int end){
        int[] parent = getDFSTree(start);
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