// 直角二等辺三角形を表すサブクラス/抽象クラスRAITriangleを書く
public abstract class RAITriangle extends Shape{
    private int size;
    public RAITriangle(int size){
        setSize(size);
    }
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size = size;
    }
    @Override public String toString(){
        return "RAITriahgle(size:"+size+")";
    }
}