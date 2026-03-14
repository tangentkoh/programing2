// フィボナッチ数を求めるプログラム（動的計画法版）
public class FiboDP{
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("使用法:java FivoDP n");
            System.out.println("例:java FivoDP 50");
            System.exit(0);
        }
        int n = Integer.parseInt(args[0]);
        long sTime = System.nanoTime();
        long r = FD(n);
        long eTime = System.nanoTime();
        System.out.println("FiboDP"+n+"の結果");
        System.out.println(r);
        System.out.println((eTime-sTime)/1_000_000.0+" ms");
    }
    public static long FD(int n){
        if(n==1||n==2){return 1;}
        long[] memo=new long[n+1];
        memo[1]=memo[2]=1;
        for (int i=3; i<=n; i++){memo[i]=memo[i-1]+memo[i-2];}
        return memo[n];
    }
}
