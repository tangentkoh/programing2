// サブクラスHorzLine1を書く
public class HorzLine1 extends AbstLine1{
    public HorzLine1(int length){super(length);}
    @Override public String toString(){
        return "HorzLine(length:"+getLength()+")";
    }
    public void draw(){
        for(int i=1; i<=getLength(); i++){
            System.out.print('-');
        }
        System.out.println();
    }
}