// mainメソッドを含むTriangleTesterクラスを書くkousuke
public class TriangleTester {
    public static void main(String[] args) {
        Triangle[] triangles = new Triangle[3]; // 3つ

        triangles[0] = new Triangle(6, 7, 2); // ここでセット
        triangles[1] = new Triangle(4, 6);     
        triangles[2] = new Triangle(8);        

        for (int i = 0; i < triangles.length; i++) {
            Triangle t = triangles[i];
            System.out.println("三角形 " + (i+1) + ": " + t); // 当然三角形は三角形
            System.out.println("正三角形か？ " + t.isI());
            System.out.println("二等辺三角形か？ " + t.isE());
            System.out.println();
        }

        System.out.println("１と２は等しいか？ " + triangles[0].equal(triangles[1]));
        System.out.println("２と３は等しいか？ " + triangles[1].equal(triangles[2]));
    }
}