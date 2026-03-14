// ナップザック問題を解くプログラム
public class Solver{
    int capacity; // ans削除
    int[] weight, value;
    int n;
    int[][] T; // こっちで宣言
    public Solver(int n, int[] weight, int[] value, int capacity){
        this.n = n;
        this.weight = weight;
        this.value = value;
        this.capacity = capacity;
        this.T = new int[n+1][capacity+1];
    }
    public int solve(){
        int ans = knapsack();
        printItems();
        return ans;
    }
    private int knapsack(){
        for(int i=0; i<n; i++) {
            for(int w=0; w<=capacity; w++){
                if(w<weight[i]){T[i+1][w]=T[i][w];}
            else{T[i + 1][w]=Math.max(T[i][w],T[i][w-weight[i]]+value[i]);}
            }
        }
        return T[n][capacity];
    }
    private void printItems(){ // 追加
        int w=capacity;
        System.out.print("選択:");
        for (int i=n; i>=1; i--) {
            if (T[i][w]!=T[i-1][w]) {
                System.out.print((i-1)+" ");
                w-=weight[i-1];
            }
        }
        System.out.println();
    }
}