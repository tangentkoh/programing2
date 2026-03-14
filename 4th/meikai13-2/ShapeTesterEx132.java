// mainメソッドを含むShapeTesterEx132クラスを書く
class ShapeTesterEx132{
    public static void main(String[] args){
        Shape[] p = new Shape[6];
        p[0]=new Point();
        p[1]=new HorzLine(5);
        p[2]=new VertLine(3);
        p[3]=new Rectangle(4,3);
        p[4]=new LftBtmRAITriangle(4);
        p[5]=new RgtTopRAITriangle(5);
        System.out.println("図形を6つ出力します");
        System.out.println();
        for(Shape s:p){
            s.print();
            System.out.println();
        }
    }
}