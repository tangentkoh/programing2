// mainメソッドを含むUnionFindTesterクラスを書く
// UnionFindTesterクラスのfindメソッドとuniteメソッドをテストする
// 課題3でmainメソッドを実行するクラス
public class UnionFindTester{
    public static void main(String [] args){
        int n = 5;
        UnionFind uf = new UnionFind(n);
        System.out.println("初期状態:");
        for (int i=0; i<n; i++) {
            System.out.println("要素" + i + "は集合:" + uf.find(i) + "に属す");
        }
        System.out.println("-Example0-");
        System.out.println("0と1を結合");
        uf.unite(0, 1);
        System.out.println("-Example1-");
        System.out.println("3と4を結合");
        uf.unite(3, 4);
        System.out.println("-Example2-");
        System.out.println("0と2を結合");
        uf.unite(0, 2);
        System.out.println("最終状態:");
        for (int i=0; i<n; i++) {
            System.out.println("要素" + i + "は集合:" + uf.find(i) + "に属す");
        }
    }
}