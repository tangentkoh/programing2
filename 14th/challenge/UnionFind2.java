// UnionFind2.java
// UnionFindクラスを書く
class UnionFind2{
    private int[] parent;
    private int[] rank;
    UnionFind2(int n){
        parent = new int[n];
        rank = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    int find2(int x){
        if(parent[x] == x){return x;}
        return parent[x] = find2(parent[x]);
    }
    boolean unite2(int x, int y){
        int rx = find2(x);
        int ry = find2(y);
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