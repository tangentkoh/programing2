// フィボナッチ数列を求めるプログラム（再帰法版）
public class FiboRec{
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("使用法:java FivoRec n");
            System.out.println("例:java FivoRec 50");
            System.exit(0);
        }
        int n = Integer.parseInt(args[0]);
        long sTime = System.nanoTime();
        long r = FR(n);
        long eTime = System.nanoTime();
        System.out.println("FiboRec"+n+"の結果");
        System.out.println(r);
        System.out.println((eTime-sTime)/1_000_000.0+" ms");
    }
    public static long FR(int n){
        if(n==1||n==2){return 1;}
        return FR(n-1)+FR(n-2);
    }
}
