// UnionFindクラスを書く
class UnionFind{
    private int[] parent;
    private int[] rank;
    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    int find(int x){
        if(parent[x] == x){return x;}
        return parent[x] = find(parent[x]);
    }
    boolean unite(int x, int y){
        int rx = find(x);
        int ry = find(y);
        if(rx == ry) {return false;}
        if(rank[rx] < rank[ry]) {parent[rx] = ry;}
        else if(rank[ry] < rank[rx]) {parent[ry] = rx;}
        else{
            parent[ry] = rx;
            rank[rx]++;
        }
        return true;
    }
}