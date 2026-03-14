// サブクラスPoint1を書く
public class Point1 extends Shape1{
    public Point1(){}
    @Override public String toString(){
        return "Point";
    }
    @Override public void draw(){
        System.out.println('+');
    }
}