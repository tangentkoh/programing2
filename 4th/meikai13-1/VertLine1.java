// サブクラスVertLine1を書く
public class VertLine1 extends AbstLine1{
    public VertLine1(int length){super(length);}
    @Override public String toString(){
        return "VertLine(length:"+getLength()+")";
    }
    @Override public void draw(){
        for(int i=0; i<=getLength(); i++){
            System.out.println('|');
        }
    }
}