// ナップザック問題を解くプログラム
public class Solver{
    int capacity; // ans削除
    int[] weight, value;
    int n; // 追加
    public Solver(int n, int[] weight, int[] value, int capacity){
        this.n = n;
        this.weight = weight;
        this.value = value;
        this.capacity = capacity;
    }
    public int solve(){return knapsack();}
    private int knapsack(){
        int[][] T = new int[n+1][capacity+1];
        for(int i=0; i<n; i++) {
            for(int w=0; w<=capacity; w++){
                if(w<weight[i]){T[i+1][w]=T[i][w];}
            else{T[i + 1][w]=Math.max(T[i][w],T[i][w-weight[i]]+value[i]);}
            }
        }
        return T[n][capacity];
    }
}
