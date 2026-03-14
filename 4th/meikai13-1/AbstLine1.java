// サブクラス/抽象クラスAbstLine1を書く
public abstract class AbstLine1 extends Shape1{
    private int length;
    public AbstLine1(int length){
        setLength(length);
    }
    public int getLength(){
        return length;
    }
    public void setLength(int length){
        this.length = length;
    }
    @Override public String toString(){
        return "AbstLine(length:"+length+")";
    }
}