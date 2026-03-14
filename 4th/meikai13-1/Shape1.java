// 抽象クラスShape1を書く
public abstract class Shape1{
    public abstract String toString();
    public abstract void draw();
    public void print(){
        System.out.println(toString());
        draw();
    }
}